package com.demotxt.droidsrce.welcomescreen;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Set;

public class welcomeActivity extends AppCompatActivity {
    LinearLayout l1,l2;
    Button btnsub;
    Animation uptodown,downtoup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnsub = (Button) findViewById(R.id.buttonsub);
        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);
    }

    public void onButtonClick(View v){

        if(v.getId()==R.id.btn2)
        {
            Intent i = new Intent(welcomeActivity.this,CapsuleTypes.class);
            startActivity(i);
        }
        if(v.getId()==R.id.buttonsub)
        {
            Intent i = new Intent(welcomeActivity.this,StatisticsActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.fragment)
        {
            Intent i = new Intent(welcomeActivity.this,StartActivity.class);
            startActivity(i);
        }
    }
}
