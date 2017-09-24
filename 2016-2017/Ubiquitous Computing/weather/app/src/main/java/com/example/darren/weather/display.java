package com.example.darren.weather;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

public class display extends AppCompatActivity {
    String API_KEY = "b2203f6e5bdafd4d9bb915543d08c508";
    String city,day;
    int rain;
    double testlat, testlon;
    double lat, lon;
    String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=json&units=metric&cnt="+day+"&appid="+API_KEY;
    String USER_LOCATION_URL = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lat+"&appid="+API_KEY;
    String data=null;
    Location location = null;
    TextView dataArea,cityArea,locationArea,weatherTypeArea,weatherLevelArea,rainLevel,tempArea;
    ImageView image;
    Bitmap downloadImage;
    NotificationManager notificationManager;
    boolean isNotificationActive,rainFound=false;
    int notificationID = 33;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUSER_LOCATION_URL() {
        return USER_LOCATION_URL;
    }

    public void setUSER_LOCATION_URL(String USER_LOCATION_URL) {
        this.USER_LOCATION_URL = USER_LOCATION_URL;
    }

    public String getBASE_URL() {
        return BASE_URL;
    }

    public void setBASE_URL(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        dataArea = (TextView) findViewById(R.id.data);
        cityArea = (TextView) findViewById(R.id.cityArea);
        locationArea = (TextView) findViewById(R.id.locationArea);
        weatherTypeArea = (TextView) findViewById(R.id.weatherTypeArea);
        weatherLevelArea = (TextView) findViewById(R.id.weatherLevelArea);
        image = (ImageView) findViewById(R.id.imageSpot);
        rainLevel = (TextView) findViewById(R.id.rainLevel);
        tempArea = (TextView) findViewById(R.id.temp);

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root+"/weather");
        String fileName = "userData.txt";
        File file = new File(myDir,fileName);
        @SuppressWarnings("MismatchedQueryAndUpdateOfStringBuilder") StringBuilder text = new StringBuilder();
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                int count = 0;
                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append("\n");
                    if (count == 0) {
                        city = line;
                        Toast.makeText(getApplicationContext(), "City" + city, Toast.LENGTH_SHORT).show();
                    } else if (count == 1) {
                        day = line;
                        Toast.makeText(getApplicationContext(), "Day" + day, Toast.LENGTH_SHORT).show();
                    } else {
                        rain = Integer.parseInt(line);
                        Toast.makeText(getApplicationContext(), "Rain" + rain, Toast.LENGTH_SHORT).show();
                    }
                    count++;
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Please make sure you have set up your settings", Toast.LENGTH_SHORT).show();
        }

        if (city.equals("Current Location")){
            LocationManager locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
            LocationListener locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location loc) {
                    makeUseOfThisLocation(loc);
                }
                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) { }
                @Override
                public void onProviderEnabled(String provider) { }
                @Override
                public void onProviderDisabled(String provider) { }
            };
            //************************************************
            //******************* GPS CODE *******************
            //************************************************
            //LocationManager locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
            try {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                //location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                lat = location.getLatitude();
                lon = location.getLongitude();
                Log.e("Location HERE","TEST Lon = "+lon);
                Log.e("Location HERE","TEST Lat = "+lat);
                //lat = testlat;
                //lon = testlon;
                setUSER_LOCATION_URL("http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+API_KEY);
                URL_PICK(getUSER_LOCATION_URL());

            } catch (SecurityException ex) {
                ex.printStackTrace();
            }
            //************************************************
            //******************* GPS CODE *******************
            //************************************************
        } else{
            setBASE_URL("http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=json&units=metric&cnt="+day+"&appid="+API_KEY);
            URL_PICK(getBASE_URL());
        }
    }

    public void URL_PICK(String url){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new DownloadJSONTask().execute(url);
        } else {
            Log.e("Network", "No network");
            Toast.makeText(getApplicationContext(),"No network connection", Toast.LENGTH_SHORT).show();
        }
    }

    class DownloadJSONTask extends AsyncTask<String, Void, StringBuffer>{

        @Override
        protected StringBuffer doInBackground(String... url) {
            try {
                return downloadJSON(url[0]);
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        private StringBuffer downloadJSON(String urlString) throws IOException{
            InputStream is = null;
            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();

                StringBuffer stringBuffer = new StringBuffer();
                is = conn.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                String line = null;

                while ((line = bufferedReader.readLine())!=null){
                    stringBuffer.append(line+"\r\n");
                }
                is.close();
                conn.disconnect();

                return stringBuffer;
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @SuppressLint("SetTextI18n")
        protected void onPostExecute(StringBuffer result){
            setData(result.toString());
            dataArea.setText(getData());
            dataArea.setVisibility(View.GONE);
            Log.e("TEST",data);

            try {
                if (!city.equals("Current Location")) {
                    JSONObject jsonObject = new JSONObject(getData());
                    JSONObject cityJSON = jsonObject.getJSONObject("city");
                    JSONObject coord = cityJSON.getJSONObject("coord");
                    String cityName = cityJSON.getString("name");
                    String LON = coord.getString("lon");
                    String LAT = coord.getString("lat");

                    StringBuffer buffer = new StringBuffer();
                    JSONArray jsonArray = jsonObject.getJSONArray("list");
                    for (int i = 0;i<jsonArray.length();i++){

                        JSONObject list = jsonArray.getJSONObject(i);

                        //*************************************************
                        JSONObject temp = list.getJSONObject("temp");
                        String max = temp.getString("max");
                        String min = temp.getString("min");
                        //*************************************************
                        JSONObject rainObject = jsonArray.getJSONObject(i);

                        //*************************************************
                        JSONArray weatherArray = list.getJSONArray("weather");
                        JSONObject weather = weatherArray.getJSONObject(0);

                        String type = weather.getString("main");
                        String weatherDescription = weather.getString("description");
                        String icon = weather.getString("icon");
                        if (i==0){
                            buffer.append("City : "+cityName+"\n");
                            buffer.append("Lat :" + LAT + "\nLon : " + LON+"\n\n");
                        }
                        buffer.append("Day : "+(i+1)+"\n");
                        buffer.append("Max : "+max+" Min : "+min+"\n");
                        buffer.append("Weather Type : " + type+"\n");
                        buffer.append("Weather Level : "+weatherDescription+"\n");
                        if (rainObject.has("rain")) {
                            String rainValue = rainObject.getString("rain");
                            buffer.append("Rain Level : "+rainValue+"\n\n");
                            double rainDouble= Double.parseDouble(String.valueOf(rain));
                            double rainValueDouble = Double.parseDouble(rainValue);
                            boolean test = rainDouble>=rainValueDouble;
                            Log.e("TEST : "+i, String.valueOf(test));
                            if (rainDouble>=rainValueDouble) {
                                rainFound=true;
                                showNotification(i);


                                //USED TO SHOW OFF THE ALERT NOTIFICATION
                                //setAlarm();
                            }
                        } else {
                            buffer.append("Rain Level : Not stated\n\n");
                        }
                    }
                    dataArea.setVisibility(View.VISIBLE);
                    dataArea.setText(buffer);
                    cityArea.setVisibility(View.GONE);
                    locationArea.setVisibility(View.GONE);
                    tempArea.setVisibility(View.GONE);
                    weatherTypeArea.setVisibility(View.GONE);
                    weatherLevelArea.setVisibility(View.GONE);
                    rainLevel.setVisibility(View.GONE);
                    image.setVisibility(View.GONE);
                    /*cityArea.setText("City : " + cityName);
                    locationArea.setText("Lat :" + LAT + "\nLon : " + LON);
                    tempArea.setText("Max : "+max+" Min : "+min);
                    weatherTypeArea.setText("Weather Type : " + type);
                    double rainDouble= Double.parseDouble(String.valueOf(rain));
                    if (rainDouble>=Double.parseDouble(rainValue)) {
                        weatherLevelArea.setText("Weather Level : " + weatherDescription);
                        weatherLevelArea.setTextColor(Color.RED);
                        rainLevel.setText("Rain Level : "+rainValue);
                        rainLevel.setTextColor(Color.RED);
                    } else {
                        weatherLevelArea.setText("Weather Level : " + weatherDescription);
                        rainLevel.setVisibility(View.GONE);
                    }*/
                    //new DownloadWebpageTask().execute("http://openweathermap.org/img/w/"+icon+".png");
                } else {
                    JSONObject jsonObject = new JSONObject(getData());
                    JSONObject coord = jsonObject.getJSONObject("coord");
                    JSONObject temp = jsonObject.getJSONObject("main");
                    String max = temp.getString("temp_max");
                    String min = temp.getString("temp_min");
                    tempArea.setText("Max : "+max+" Min : "+min);
                    String LON = coord.getString("lon");
                    String LAT = coord.getString("lat");
                    JSONArray weatherArray = jsonObject.getJSONArray("weather");
                    JSONObject weather = weatherArray.getJSONObject(0);
                    String type = weather.getString("main");
                    String weatherDescription = weather.getString("description");
                    String icon = weather.getString("icon");
                    cityArea.setText("Your Location");
                    //cityArea.setVisibility(View.GONE);
                    locationArea.setText("Lat :" + LAT + "\nLon : " + LON);
                    weatherTypeArea.setText("Weather Type : " + type);
                    if (jsonObject.has("rain")) {
                        JSONObject rainObject = jsonObject.getJSONObject("rain");
                        String rainValue = rainObject.getString("3h");
                        Log.e("Rain", rainValue);
                        rainLevel.setText("Rain Level : "+rainValue);
                        weatherLevelArea.setText("Weather Level : " + weatherDescription);
                        rainLevel.setTextColor(Color.RED);
                        weatherLevelArea.setTextColor(Color.RED);
                    } else {
                        rainLevel.setText("Rain Level : Not stated");
                        weatherLevelArea.setText("Weather Level : " + weatherDescription);
                    }
                    //weatherLevelArea.setText("Weather Level : " + weatherDescription);
                    new DownloadWebpageTask().execute("http://openweathermap.org/img/w/"+icon+".png");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    class DownloadWebpageTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... url) {
            try {
                return downloadUrl(url[0]);
            } catch (IOException x) {
                Log.e("Url", "Unable to download image from web page");
                Toast.makeText(getApplicationContext(),"Unable to download image from the web page", Toast.LENGTH_SHORT).show();
                return null;
            }
        }

        private Bitmap downloadUrl(String urlString) throws IOException {
            InputStream is = null;

            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();

                int response = conn.getResponseCode();
                Log.d("Status", "The response is : " + response);
                is = conn.getInputStream();

                Bitmap bitmap = BitmapFactory.decodeStream(is);

                return bitmap;
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }

        protected void onPostExecute(Bitmap result) {
            image.setImageBitmap(result);
            downloadImage=result;
        }
    }

    public void showNotification(int i){
        NotificationCompat.Builder notificBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Rain Alert")
                .setContentText("Please check the forecast.\n" +
                        "Rain on day "+(i+1)+"\n" +
                        "Rain over the user limit")
                .setTicker("Alert Rain")
                .setSmallIcon(R.mipmap.rain);
        Intent moreInfoIntent = new Intent(this,display.class);
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addParentStack(display.class);
        taskStackBuilder.addNextIntent(moreInfoIntent);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        notificBuilder.setContentIntent(pendingIntent);
        notificBuilder.setAutoCancel(true);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationID,notificBuilder.build());

        isNotificationActive = true;
    }

    public  void stopNotification(View view){
        if (isNotificationActive){
            notificationManager.cancel(notificationID);
        }
    }

    public void setAlarm(){
        //Long alertTime = new GregorianCalendar().getTimeInMillis()+5*1000;
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 13); // For 1 PM
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Intent alarmIntent = new Intent (this,AlertReceiver.class);
        AlarmManager alarmManager = (AlarmManager)
                getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                PendingIntent.getBroadcast(this,1,alarmIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
    }


    private void makeUseOfThisLocation(Location loc) {
        lat = loc.getLatitude();
        lon = loc.getLongitude();
        Log.e("Location","Lon = "+lon);
        Log.e("Location","Lat = "+lat);
    }
}
