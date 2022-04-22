package com.demotxt.droidsrce.welcomescreen;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ervin-PC on 2017. 11. 20..
 */

public class StatAdapter extends ArrayAdapter {


    private final Activity context;
    private final Integer[] imageID;
    private final String[] typeID;


    public StatAdapter(@NonNull Activity context, Integer[] imageID, String[] typeID){
        super(context,R.layout.stat_row,typeID);
        this.context=context;
        this.imageID=imageID;
        this.typeID=typeID;

    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.stat_row, null, true);


        ImageView image = rowView.findViewById(R.id.coffee_type);
        TextView type = rowView.findViewById(R.id.coffee_name);

        image.setImageResource(imageID[position]);
        type.setText(typeID[position]);

        return rowView;
    }

}