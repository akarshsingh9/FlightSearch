package com.codeinpython.flightsearch;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

class BookDBAdapter {
    /*
    *   BookDBAdapter to insert data into database after user clicks book btn
    *   collects user booking details
     */
    private Context c;
    private SQLiteDatabase db;
    private BookDBHelper helper;

    public BookDBAdapter(Context c) {
        this.c = c;
        helper=new BookDBHelper(c);
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
    public boolean insert(String flightName,String deptTime,String arrTime, String fromcode, String tocode, String price)
    {
        try
        {
            ContentValues cv=new ContentValues();

            cv.put(Book.FLIGHT_NAME, flightName);
            cv.put(Book.DEPT_TIME, deptTime);
            cv.put(Book.ARR_TIME, arrTime);
            cv.put(Book.FROM_CODE, fromcode);
            cv.put(Book.TO_CODE, tocode);
            cv.put(Book.PRICE, price);


            db.insert(Book.TB_NAME, Book.BOOK_ID, cv);

            return true;

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

}
