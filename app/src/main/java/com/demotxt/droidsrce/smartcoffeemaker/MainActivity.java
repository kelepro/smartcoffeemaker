package com.demotxt.droidsrce.welcomescreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginbtn = (Button)findViewById(R.id.loginbtn);
        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById(R.id.password);
        final TextView errormessagefield =(TextView)findViewById(R.id.errormessagetxt);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!username.getText().toString().equals("user")||!password.getText().toString().equals("coffee")){
                    errormessagefield.setText("Login error");
                }else{
                    Intent intent = new Intent(getApplicationContext(),welcomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}

