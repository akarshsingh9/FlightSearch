package com.codeinpython.flightsearch;

/*
*   MainActivity or entry point of the project
*   Landing page, asking user details regarding source and destination airport codes, departure date, number of passengers
*   databaseSetup() method populates the database only once when app is launched for first time
*   databaseSetup() - Flight, DBHelper, DBAdapter java class helps to create a SQLite database which will be searched
*   Database is searched on basis of fromCode, toCode, deptDate
 */

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //declare EditText and Button objects
    private EditText fromCity;
    private EditText toCity;
    private EditText passNo;
    private EditText deptDate;
    private Button datebtn;
    private Button searchbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SharedPreferences are used to check if first time app opened then populate database otherwise not
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            databaseSetup();


            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        }
        //findViewById
        fromCity = (EditText)findViewById(R.id.fromInput);
        toCity = (EditText)findViewById(R.id.toInput);
        deptDate = (EditText)findViewById(R.id.deptDateInput);
        passNo = (EditText)findViewById(R.id.passengerInput);

        datebtn = (Button)findViewById(R.id.datepickerBtn);
        searchbtn = (Button)findViewById(R.id.searchFlightBtn);

        //date picker pops on clicking select button
        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int mYear = calendar.get(Calendar.YEAR);
                int mMonth = calendar.get(Calendar.MONTH);
                int mDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        deptDate.setText(""+dayOfMonth+"/"+""+(month+1)+"/"+""+year);
                    }
                },mYear,mMonth,mDay);

                datePickerDialog.show();
            }
        });

        //search btn intents to flightSearched Activity and passes necessary info for searching the database
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("passNo", passNo.getText().toString());
                editor.putString("dept",deptDate.getText().toString());
                editor.apply();
                Intent intent = new Intent(MainActivity.this,flightsSearched.class);
                intent.putExtra("from",fromCity.getText().toString());
                intent.putExtra("to",toCity.getText().toString());
                intent.putExtra("date",deptDate.getText().toString());
                startActivity(intent);
            }
        });


    }
    //Database setup method - more cities and flight details can be added to database from here
    /* Currently you can select from
      * BOM - Mumbai
      * MAA - Chennai
      * DEL - Delhi
      * BLR - Bangalore
      * AHM - Ahmedabad
      * CCU - Kolkata
      * PAT - Patna
      */
    private void databaseSetup()
        {
            DBHelper db = new DBHelper(this);
            DBAdapter adapter = new DBAdapter(this);
            adapter.openDB();
            adapter.insert("Air India","25/8/2018","08:00","12:00","4:00","BOM","CCU","3200");
            adapter.insert("Indigo","25/8/2018","12:00","14:00","2:00","BOM","AHM","2200");
            adapter.insert("Indigo","25/8/2018","14:00","17:00","3:00","BOM","DEL","2800");
            adapter.insert("Jet Airways","25/8/2018","09:00","12:00","3:00","BOM","AHM","2000");
            adapter.insert("Air India","25/8/2018","08:00","10:00","2:00","PAT","CCU","3200");
            adapter.insert("Indigo","25/8/2018","09:00","12:00","3:00","BOM","CCU","3600");
            adapter.insert("Air India","25/8/2018","08:00","12:00","4:00","DEL","MAA","4200");
            adapter.insert("Jet Airways","25/8/2018","12:00","16:00","4:00","DEL","MAA","4000");
            adapter.insert("Indigo","25/8/2018","09:00","12:00","3:00","DEL","MAA","3600");
            adapter.insert("Air India","25/8/2018","08:00","12:00","4:00","BOM","CCU","4200");
            adapter.insert("Jet Airways","25/8/2018","12:00","15:00","3:00","BOM","BLR","4000");
            adapter.insert("Indigo","25/8/2018","09:00","12:00","3:00","BLR","DEL","3600");
            adapter.insert("Air India","25/8/2018","08:00","12:00","4:00","BLR","DEL","4000");
            adapter.insert("Jet Airways","25/8/2018","12:00","15:00","3:00","BLR","DEL","4200");

            adapter.insert("Air India","26/8/2018","08:00","12:00","4:00","BOM","CCU","3200");
            adapter.insert("Indigo","26/8/2018","12:00","14:00","2:00","BOM","AHM","2200");
            adapter.insert("Indigo","26/8/2018","14:00","17:00","3:00","BOM","DEL","2800");
            adapter.insert("Jet Airways","26/8/2018","09:00","12:00","3:00","BOM","AHM","2000");
            adapter.insert("Air India","26/8/2018","08:00","10:00","2:00","PAT","CCU","3200");
            adapter.insert("Indigo","26/8/2018","09:00","12:00","3:00","BOM","CCU","3600");
            adapter.insert("Air India","26/8/2018","08:00","12:00","4:00","DEL","MAA","4200");
            adapter.insert("Jet Airways","26/8/2018","12:00","16:00","4:00","DEL","MAA","4000");
            adapter.insert("Indigo","26/8/2018","09:00","12:00","3:00","DEL","MAA","3600");
            adapter.insert("Air India","26/8/2018","08:00","12:00","4:00","BOM","CCU","4200");
            adapter.insert("Jet Airways","26/8/2018","12:00","15:00","3:00","BOM","BLR","4000");
            adapter.insert("Indigo","26/8/2018","09:00","12:00","3:00","BLR","DEL","3600");
            adapter.insert("Air India","26/8/2018","08:00","12:00","4:00","BLR","DEL","4000");
            adapter.insert("Jet Airways","26/8/2018","12:00","15:00","3:00","BLR","DEL","4200");

            adapter.insert("Air India","27/8/2018","08:00","12:00","4:00","BOM","CCU","3200");
            adapter.insert("Indigo","27/8/2018","12:00","14:00","2:00","BOM","AHM","2200");
            adapter.insert("Indigo","27/8/2018","14:00","17:00","3:00","BOM","DEL","2800");
            adapter.insert("Jet Airways","27/8/2018","09:00","12:00","3:00","BOM","AHM","2000");
            adapter.insert("Air India","27/8/2018","08:00","10:00","2:00","PAT","CCU","3200");
            adapter.insert("Indigo","27/8/2018","09:00","12:00","3:00","BOM","CCU","3600");
            adapter.insert("Air India","27/8/2018","08:00","12:00","4:00","DEL","MAA","4200");
            adapter.insert("Jet Airways","27/8/2018","12:00","16:00","4:00","DEL","MAA","4000");
            adapter.insert("Indigo","27/8/2018","09:00","12:00","3:00","DEL","MAA","3600");
            adapter.insert("Air India","27/8/2018","08:00","12:00","4:00","BOM","CCU","4200");
            adapter.insert("Jet Airways","27/8/2018","12:00","15:00","3:00","BOM","BLR","4000");
            adapter.insert("Indigo","27/8/2018","09:00","12:00","3:00","BLR","DEL","3600");
            adapter.insert("Air India","27/8/2018","08:00","12:00","4:00","BLR","DEL","4000");
            adapter.insert("Jet Airways","27/8/2018","12:00","15:00","3:00","BLR","DEL","4200");


            adapter.insert("Air India","28/8/2018","12:00","14:00","2:00","MAA","BOM","1200");
            adapter.insert("Indigo","28/8/2018","12:00","14:00","2:00","MAA","BOM","1500");
            adapter.insert("Indigo","28/8/2018","12:00","15:00","3:00","MAA","BOM","1800");

            adapter.insert("Jet Airways","29/8/2018","12:00","16:00","4:00","MAA","BOM","2000");
            adapter.insert("Jet Airways","29/8/2018","12:00","16:00","4:00","AHM","BOM","2100");
            adapter.insert("Jet Airways","29/8/2018","12:00","16:00","4:00","MAA","CCU","2500");
            adapter.insert("Jet Airways","29/8/2018","12:00","16:00","4:00","CCU","BOM","3000");

            adapter.insert("Air India","30/8/2018","12:00","14:00","2:00","BLR","BOM","1400");
            adapter.insert("Air India","30/8/2018","12:00","14:00","2:00","BLR","CCU","1200");
            adapter.insert("Air India","30/8/2018","08:00","10:00","2:00","BLR","BOM","1000");

        }

}
