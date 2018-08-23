package com.codeinpython.flightsearch;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/*
*   Intent from MainActivity -> flightSearched Activity
*   receives intent Extras from MainActivity
*   passes from , to ,  date as parameter to retrieve method in DBAdapter to search the database for given condition
*   Displays result in RecyclerView
 */

public class flightsSearched extends AppCompatActivity {

    List<SearchedModelClass> list;
    String passNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights_searched);

        //getIntent from MainActivity
        Intent intent = getIntent();
        String from = intent.getStringExtra("from");
        String to = intent.getStringExtra("to");
        String date = intent.getStringExtra("date");
        passNo = intent.getStringExtra("passNo");

        //Initialize RecyclerView
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.searchedFlightRecycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //retrieve search result
        DBAdapter adapter = new DBAdapter(this);
        adapter.openDB();
        Cursor c = adapter.retrieve(from,to,date);
         list = new ArrayList<>();
        String flight ="";
        String deptTime ="";
        String arrTime ="";
        String hrs ="";
        String fromcode ="";
        String tocode = "";
        String price = "";
        int imageres = 0;

        while (c.moveToNext())
        {
            flight = c.getString(1);
            switch (flight)
            {
                case "Air India":imageres = R.drawable.airindia;
                                            break;
                case "Indigo": imageres = R.drawable.indigo;
                                            break;
                case "Jet Airways": imageres = R.drawable.jetairways;
                                                break;
            }
            deptTime = c.getString(3);
            arrTime = c.getString(4);
            hrs = c.getString(5);
            fromcode = c.getString(6);
            tocode = c.getString(7);
            price = c.getString(8);
            //add search result to list which will then be added to recyclerview adapter
            list.add(new SearchedModelClass(imageres,flight,fromcode,tocode,deptTime,arrTime,hrs,price));
        }

        //set adapter
        SearchedAdapter adapter1 = new SearchedAdapter(list);
        recyclerView.setAdapter(adapter1);

    }
}
