package com.codeinpython.flightsearch;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class flightsSearched extends AppCompatActivity {

    List<SearchedModelClass> list;
    String passNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights_searched);

        Intent intent = getIntent();
        String from = intent.getStringExtra("from");
        String to = intent.getStringExtra("to");
        String date = intent.getStringExtra("date");
        passNo = intent.getStringExtra("passNo");

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.searchedFlightRecycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //TextView log = (TextView)findViewById(R.id.log);

        DBAdapter adapter = new DBAdapter(this);
        adapter.openDB();
        Cursor c = adapter.retrieve(from,to,date);
         list = new ArrayList<>();
        //StringBuffer buffer = new StringBuffer();
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
            list.add(new SearchedModelClass(imageres,flight,fromcode,tocode,deptTime,arrTime,hrs,price));
        }

        SearchedAdapter adapter1 = new SearchedAdapter(list);
        recyclerView.setAdapter(adapter1);

    }
}
