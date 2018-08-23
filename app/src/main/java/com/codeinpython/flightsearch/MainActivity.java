package com.codeinpython.flightsearch;

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

    EditText fromCity, toCity, passNo, deptDate;
    Button datebtn, searchbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            databaseSetup();


            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        }


        fromCity = (EditText)findViewById(R.id.fromInput);
        toCity = (EditText)findViewById(R.id.toInput);
        deptDate = (EditText)findViewById(R.id.deptDateInput);
        passNo = (EditText)findViewById(R.id.passengerInput);

        datebtn = (Button)findViewById(R.id.datepickerBtn);
        searchbtn = (Button)findViewById(R.id.searchFlightBtn);


        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int mYear = calendar.get(Calendar.YEAR);
                int mMonth = calendar.get(calendar.MONTH);
                int mDay = calendar.get(calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        deptDate.setText(""+dayOfMonth+"/"+""+(month+1)+"/"+""+year);
                    }
                },mYear,mMonth,mDay);

                datePickerDialog.show();
            }
        });

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
                //intent.putExtra("passNo",passNo.getText().toString());
                startActivity(intent);
            }
        });


    }
void databaseSetup()
        {
            DBHelper db = new DBHelper(this);
            DBAdapter adapter = new DBAdapter(this);
            adapter.openDB();
            adapter.insert("Air India","28/8/2018","12:00","14:00","2:00","MAA","BOM","1200");
            adapter.insert("Indigo","28/8/2018","12:00","14:00","2:00","MAA","BOM","1500");
            adapter.insert("Indigo","28/8/2018","12:00","15:00","3:00","MAA","BOM","1800");
            adapter.insert("Jet Airways","29/8/2018","12:00","16:00","4:00","MAA","BOM","2000");
            adapter.insert("Jet Airways","29/8/2018","12:00","16:00","4:00","AHM","BOM","2100");
            adapter.insert("Jet Airways","29/8/2018","12:00","16:00","4:00","MAA","CCU","2500");
            adapter.insert("Jet Airways","29/8/2018","12:00","16:00","4:00","CCU","BOM","3000");
        }

}
