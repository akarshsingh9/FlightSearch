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
          //  cv.put(Flight.FROM_CITY, from);
            cv.put(Flight.TO_CODE, tocode);
          //  cv.put(Flight.TO_CITY, to);
            cv.put(Flight.PRICE, price);
          //  cv.put(Flight.AIRPORT, airport);


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
        //String[] columns={Flight.FLIGHT_NAME,Flight.DEPT_TIME,Flight.ARR_TIME,Flight.HOURS,Flight.FROM_CODE,Flight.TO_CODE,Flight.PRICE};
       /*
        Cursor c=null;

        if(fromcode != null && tocode!=null && deptDate!=null)
        {
            String sql="SELECT flightname,depttime,arrtime,hours,fromcode,tocode,price FROM "+Flight.TB_NAME+" WHERE "+Flight.FROM_CODE+" LIKE '%"+searchTerm+"%'";
            c=db.rawQuery(sql,null);
            return c;

        }

        c=db.query(Flight.TB_NAME,columns,null,null,null,null,null);
        return c;
        */
        String query = "SELECT * from "+Flight.TB_NAME+" WHERE "+Flight.FROM_CODE+"=? AND "+Flight.TO_CODE+"=? AND "+Flight.DEPT_DATE+"=?;";
        //+fromcode
              //  +" AND tocode="+tocode+") AND deptdate="+deptDate+";";
        //where (column1 like ? and column2 like ?) and column3 like ?";
        //String[] params = {"%" + fromcode + "%", "%" + tocode + "%", "%" + deptDate + "%"};
        Cursor c = db.rawQuery(query, new String[]{fromcode,tocode,deptDate});
        return c;
    }
}
