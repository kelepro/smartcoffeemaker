package com.demotxt.droidsrce.welcomescreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.*;

public class CapsuleTypes extends AppCompatActivity {

    String[] products = {"Intense","Intense 2","Elegant", "Indonesia", "Pure Black", "Vanilla", "Cream"};
    Integer[] images = {R.drawable.intense, R.drawable.intense2, R.drawable.vanilla, R.drawable.indonesia,R.drawable.pureblack,R.drawable.vanilla,R.drawable.crem};
    String[] prices = {"12.00", "13.99", "14.00", "13.99", "12.00", "14.00", "13.99"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capsule_activity);

        final ListAdapter adapter = new ListAdapter(CapsuleTypes.this,images,products,prices);
        ListView lista = (ListView) findViewById(R.id.capsulelist);
        lista.setAdapter(adapter);
        

    }
}