package com.example.licho.sesion6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<MyLocation> {

    public LocationAdapter(Context context, ArrayList<MyLocation> locations) {
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MyLocation location = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_location, parent, false);
        }
        // Lookup view for data population
        TextView ilatitude = (TextView) convertView.findViewById(R.id.ilatitude);
        TextView ilongitude = (TextView) convertView.findViewById(R.id.ilongitude);
        TextView idate = (TextView) convertView.findViewById(R.id.idate);
        // Populate the data into the template view using the data object
        ilatitude.setText(String.valueOf(location.getLatitud()));
        ilongitude.setText(String.valueOf(location.getLongitud()));
        //idate.setText(location.getFecha().toString());
        // Return the completed view to render on screen
        return convertView;
    }
}
