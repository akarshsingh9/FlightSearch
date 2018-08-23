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

    TextView airlineText,fromFinal,toFinal,deptFinal,arrFinal,fareText,passText,datedept;
    ImageView imageView;
    Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String passno = prefs.getString("passNo","");
        String deptdate = prefs.getString("dept","");

        Intent intent = getIntent();
        final String fromCode = intent.getStringExtra("fromCode");
        final String toCode = intent.getStringExtra("toCode");
        final String deptTime = intent.getStringExtra("deptTime");
        final String arrTime = intent.getStringExtra("arrTime");
        final String price = intent.getStringExtra("price");
        int imageres = intent.getIntExtra("image",0);
        final String airline = intent.getStringExtra("airline");


        airlineText = (TextView)findViewById(R.id.airlineText);
        fromFinal = (TextView)findViewById(R.id.frominfo);
        toFinal = (TextView)findViewById(R.id.toinfo);
        deptFinal = (TextView)findViewById(R.id.deptinfo);
        arrFinal = (TextView)findViewById(R.id.arrinfo);
        passText = (TextView)findViewById(R.id.passinfo);
        fareText = (TextView)findViewById(R.id.fareinfo);
        datedept = (TextView)findViewById(R.id.datedept);

        imageView = (ImageView)findViewById(R.id.airlineImage);
        book = (Button)findViewById(R.id.bookbtn);

        imageView.setImageResource(imageres);
        airlineText.setText(airline);
        fromFinal.setText(fromCode);
        toFinal.setText(toCode);
        deptFinal.setText(deptTime);
        arrFinal.setText(arrTime);
        fareText.setText(price);
        passText.setText(passno);
        datedept.setText(deptdate);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookDBAdapter adapter = new BookDBAdapter(BookActivity.this);
                adapter.openDB();
                adapter.insert(airline,deptTime,arrTime,fromCode,toCode,price);
                Toast.makeText(BookActivity.this,"Flight Successfully Booked!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
