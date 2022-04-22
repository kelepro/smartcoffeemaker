package com.demotxt.droidsrce.welcomescreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ervin-PC on 2018. 03. 08..
 */

public class StatisticsDetailsActivity  extends AppCompatActivity{

    TextView showValue;
    int counter = 0;
    EditText mEditText1;
    EditText mEditText2;
    Button mButton;
    TextView mTextView;
    Integer[] images ={R.drawable.intense,R.drawable.crem,R.drawable.indonesia,R.drawable.tea};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.statistics_details_activity );
        final DatabaseManager manager = new DatabaseManager( getApplicationContext() );
        if (manager.selectCapsuleNames().length == 0 || manager.selectCapsuleNames() == null) {
            new AutoInsert( getApplicationContext() );
        }
        mEditText1 = findViewById( R.id.drinkprice );
        mEditText2 = findViewById( R.id.brewed_number );
        mButton = findViewById( R.id.result_button );
        mButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        } );
        mTextView = findViewById( R.id.textView6 );
        showValue = findViewById( R.id.coffee_counter );
        ImageView images = findViewById( R.id.imagedetail );
        TextView types = findViewById( R.id.namedetail );
        final Intent intent = getIntent();
        types.setText( intent.getStringExtra( "nev" ) );
        images.setImageResource( intent.getIntExtra( "kep", 0 ) );

        final TextView name = findViewById( R.id.namedetail );

        final EditText coffeecounter = findViewById( R.id.coffee_counter );

        final EditText breweddrinknumber = findViewById( R.id.breweddrinknumber );

        Integer[] numbers = manager.getNumbers();
        Integer[] numberofgrowing = manager.getNumber_Of_Growing();


        if (intent.getStringExtra( "nev" ).equals( "Espresso" )){

            coffeecounter.setText(String.valueOf(numbers[0]));
            breweddrinknumber.setText(String.valueOf(numberofgrowing[0]));

        }
        if (intent.getStringExtra( "nev" ).equals( "Cream" )){

            coffeecounter.setText(String.valueOf(numbers[1]));
            breweddrinknumber.setText(String.valueOf(numberofgrowing[1]));

        }
        if (intent.getStringExtra( "nev" ).equals( "Filter" )){

            coffeecounter.setText(String.valueOf(numbers[2]));
            breweddrinknumber.setText(String.valueOf(numberofgrowing[2]));
        }

        findViewById(R.id.save_stock).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (intent.getStringExtra( "nev" ).equals( "Espresso" )) {
                    manager.updateDB( "Espresso",
                    Integer.parseInt( coffeecounter.getText().toString()),
                    Integer.parseInt( breweddrinknumber.getText().toString()));

                }
                if (intent.getStringExtra( "nev" ).equals( "Cream" )) {
                    manager.updateDB( "Cream",
                            Integer.parseInt( coffeecounter.getText().toString()),
                            Integer.parseInt( breweddrinknumber.getText().toString()));
                }
                if (intent.getStringExtra( "nev" ).equals( "Filter" )) {
                    manager.updateDB( "Filter",
                            Integer.parseInt( coffeecounter.getText().toString()),
                            Integer.parseInt( breweddrinknumber.getText().toString()));
                }
                Toast.makeText(getApplicationContext(),"Values updated!",
                        Toast.LENGTH_SHORT).show();
            }
        } );

    }

    public void countIN (View view){
        counter = Integer.parseInt(showValue.getText().toString());
        counter ++;
        showValue.setText(Integer.toString(counter));

    }
    public void countDE (View v){
        counter = Integer.parseInt(showValue.getText().toString());
        counter--;
        showValue.setText(Integer.toString(counter));

    }
    public void calculate(){
        Double value1= Double.parseDouble( mEditText1.getText().toString() );
        Double value2= Double.parseDouble( mEditText2.getText().toString() );
        // do the calculation
        Double calculatedValue= (value1*value2);
        mTextView.setText(calculatedValue.toString()+" RON");
    }



}
