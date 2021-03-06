package com.codeinpython.flightsearch;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class BookDBHelper extends SQLiteOpenHelper {
/*
*   BookDBHelper - used for Database created for user who has already booked a flight ticket
*   Create table, onUpgrade to newer version
 */

    public BookDBHelper(Context context)
    {
        super(context, Book.DB_NAME,null,Book.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try
        {
            db.execSQL(Book.CREATE_TB);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Book.DROP_TB);
        onCreate(db);
    }
}
