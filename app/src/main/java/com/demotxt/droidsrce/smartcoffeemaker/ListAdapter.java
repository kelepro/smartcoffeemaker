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
 * Created by Ervin-PC on 2018. 02. 17..
 */

public class ListAdapter extends ArrayAdapter {

    private final Activity context;
    private final Integer[] imageIDarray;
    private final String[] products;
    private final String[] priceArray;

    public ListAdapter(@NonNull Activity context, Integer[] imageIDarray, String[] products, String[] priceArray) {
        super(context, R.layout.list_row, products);
        this.context = context;
        this.imageIDarray = imageIDarray;
        this.products = products;
        this.priceArray = priceArray;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_row, null, true);


        ImageView image = rowView.findViewById(R.id.row_image);
        TextView type = rowView.findViewById(R.id.typetxt);
        TextView status = rowView.findViewById(R.id.statustxt);
        TextView price = rowView.findViewById(R.id.eurotxt);

        image.setImageResource(imageIDarray[position]);
        type.setText(products[position]);
        status.setText("10 piece/box");
        price.setText(priceArray[position] + " RON");

        return rowView;

    }
}
