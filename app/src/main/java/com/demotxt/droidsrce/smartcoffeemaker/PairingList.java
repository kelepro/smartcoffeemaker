package com.demotxt.droidsrce.welcomescreen;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Ervin-PC on 2017. 11. 20..
 */

public class PairingList extends Activity {
    ListView lview;
    String[] paires;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pairinglist_layout);
        lview=(ListView)findViewById(R.id.listviewid);
        Bundle bn = getIntent().getExtras();
        paires = bn.getStringArray("paires");

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,paires);
        lview.setAdapter(adapter);

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            }
        });
    }
}