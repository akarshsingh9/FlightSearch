package com.codeinpython.flightsearch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {

    /*
    *   BookActivity - is called after flightSearched Activity as intent from onItemClick at recyclerview
    *   BookActivity stores and display flight booking details of user
    *   total price, fare per head, number of passenger, from and to location, date of departure etc.
    *   Calculation of total fare is done and stored in database.
    *   when user clicks book button a toast is displayed and data is pushed to database.
     */

    TextView airlineText,fromFinal,toFinal,deptFinal,arrFinal,fareText,passText,datedept,totalfare,pass,fare1;
    ImageView imageView;
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        //get passenger number and dept date
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String passno = prefs.getString("passNo","");
        String deptdate = prefs.getString("dept","");

        //get intent values passed when recyclerview item was clicked.
        Intent intent = getIntent();
        final String fromCode = intent.getStringExtra("fromCode");
        final String toCode = intent.getStringExtra("toCode");
        final String deptTime = intent.getStringExtra("deptTime");
        final String arrTime = intent.getStringExtra("arrTime");
        final String price = intent.getStringExtra("price");
        int imageres = intent.getIntExtra("image",0);
        final String airline = intent.getStringExtra("airline");


        //initialize views
        airlineText = (TextView)findViewById(R.id.airlineText);
        fromFinal = (TextView)findViewById(R.id.frominfo);
        toFinal = (TextView)findViewById(R.id.toinfo);
        deptFinal = (TextView)findViewById(R.id.deptinfo);
        arrFinal = (TextView)findViewById(R.id.arrinfo);
        passText = (TextView)findViewById(R.id.passinfo);
        fareText = (TextView)findViewById(R.id.fareinfo);
        datedept = (TextView)findViewById(R.id.datedept);
        fare1 = (TextView)findViewById(R.id.priceperhead);
        pass = (TextView)findViewById(R.id.pass);
        totalfare = (TextView)findViewById(R.id.fare);

        imageView = (ImageView)findViewById(R.id.airlineImage);
        book = (Button)findViewById(R.id.bookbtn);

        //calc total fare
        int pph = Integer.parseInt(price);
        int num = Integer.parseInt(passno);
        int total = pph*num;
        final String totalfare1 = ""+total;

        //set views for display
        imageView.setImageResource(imageres);
        airlineText.setText(airline);
        fromFinal.setText(fromCode);
        toFinal.setText(toCode);
        deptFinal.setText(deptTime);
        arrFinal.setText(arrTime);
        fareText.setText(price);
        passText.setText(passno);
        datedept.setText(deptdate);
        fare1.setText(price);
        pass.setText(passno);
        totalfare.setText(totalfare1);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //store in database when button clicked
                BookDBAdapter adapter = new BookDBAdapter(BookActivity.this);
                adapter.openDB();
                adapter.insert(airline,deptTime,arrTime,fromCode,toCode,totalfare1);
                Toast.makeText(BookActivity.this,"Flight Successfully Booked!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
