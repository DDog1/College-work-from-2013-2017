package com.example.darren.googlemapsfragments;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CityList extends Fragment {

    public CityList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_city_list, container, false);

        //String[] items = new String[] { "Current Location","Dublin","Kerry","Belfast","Cork","Galway","Wexford" };

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1, items);
        ListView list = (ListView) view.findViewById(R.id.listView);
        //list.setAdapter(adapter);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> list, View row, int index, long rowID) {
                        // code to run when user clicks that item
                        // launch new Activity with holes details
                        ((googleMaps)getActivity()).setCity((String)list.getItemAtPosition(index));
                        ((googleMaps)getActivity()).showMap();
                    }
                }
        );
        return view;
    }
}
