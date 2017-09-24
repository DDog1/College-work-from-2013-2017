package com.example.darren.q2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Button retrieveImage;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrieveImage = (Button) findViewById(R.id.retrieveImage);
        url = (EditText) findViewById(R.id.url);
        image = (ImageView) findViewById(R.id.imageSpot);

        retrieveImage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String stringUrl = url.getText().toString();
                ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    new DownloadWebpageTask().execute(stringUrl);
                } else {
                    Log.e("Network", "No network");
                    Toast.makeText(getApplicationContext(),"No network connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
        }
    }

}