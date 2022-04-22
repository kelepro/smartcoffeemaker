package com.demotxt.droidsrce.welcomescreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Ervin-PC on 2018. 03. 07..
 */

public class StatisticsActivity extends AppCompatActivity {

    String[] types ={"Espresso","Cream","Filter"};
    Integer[] images ={R.drawable.intense,R.drawable.crem,R.drawable.indonesia};


    @Override
    protected void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.statistics_list_activity);

        final StatAdapter adapter = new StatAdapter(StatisticsActivity.this,images,types);
        ListView lista2 = findViewById(R.id.statistics_list);
        lista2.setAdapter(adapter);

        lista2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(getApplicationContext(),StatisticsDetailsActivity.class);
                intent.putExtra("kep",images[position]);
                intent.putExtra("nev",types[position]);
                startActivity(intent);
            }
        });

    }
}
