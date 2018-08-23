package com.codeinpython.flightsearch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

//Perform CRUD operation with DBAdapter
public class DBAdapter {

    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c) {
        this.c = c;
        helper=new DBHelper(c);
    }

    //OPEN DB
    public void openDB()
    {
        try
        {
            db=helper.getWritableDatabase();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //CLOSE
    public void closeDB()
    {
        try
        {
            helper.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //INSERT DATA
    public boolean insert(String flightName, String deptDate,String deptTime,String arrTime,String hrs, String fromcode, String tocode, String price)
    {
        try
        {
            ContentValues cv=new ContentValues();

            cv.put(Flight.FLIGHT_NAME, flightName);
            cv.put(Flight.DEPT_DATE, deptDate);
            cv.put(Flight.DEPT_TIME, deptTime);
            cv.put(Flight.ARR_TIME, arrTime);
            cv.put(Flight.HOURS, hrs);
            cv.put(Flight.FROM_CODE, fromcode);
            cv.put(Flight.TO_CODE, tocode);
            cv.put(Flight.PRICE, price);


            db.insert(Flight.TB_NAME, Flight.FLIGHT_ID, cv);

            return true;

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    //RETRIEVE DATA AND FILTER
    public Cursor retrieve(String fromcode, String tocode, String deptDate)
    {
        String query = "SELECT * from "+Flight.TB_NAME+" WHERE "+Flight.FROM_CODE+"=? AND "+Flight.TO_CODE+"=? AND "+Flight.DEPT_DATE+"=?;";
        Cursor c = db.rawQuery(query, new String[]{fromcode,tocode,deptDate});
        return c;
    }
}
