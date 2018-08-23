package com.codeinpython.flightsearch;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    /*
    *   DBHelper extends SQLiteOpenHelper
    *   Used to create table or destroy using upgrade
     */

    public DBHelper(Context context)
    {
        super(context, Flight.DB_NAME,null,Flight.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try
        {
            db.execSQL(Flight.CREATE_TB);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Flight.DROP_TB);
        onCreate(db);
    }
}
