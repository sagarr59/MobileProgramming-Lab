package com.example.crudapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "db.db";
    private static final int DB_VERSION = 1;
    private static final String TBL_NAME = "tbl";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TBL_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY, " +
                COL_NAME + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_NAME);
        onCreate(db);
    }

    public void insert(int id, String name) {
        ContentValues cv = new ContentValues();
        cv.put(COL_ID, id);
        cv.put(COL_NAME, name);
        getWritableDatabase().insert(TBL_NAME, null, cv);
    }

    public Cursor read() {
        return getReadableDatabase().rawQuery("SELECT * FROM " + TBL_NAME, null);
    }

    public void update(int id, String name) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, name);
        getWritableDatabase().update(TBL_NAME, cv, COL_ID + "=?", new String[]{String.valueOf(id)});
    }

    public void delete(int id) {
        getWritableDatabase().delete(TBL_NAME, COL_ID + "=?", new String[]{String.valueOf(id)});
    }
}
