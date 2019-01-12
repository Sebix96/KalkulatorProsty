package com.example.sebastian.kalkulatorprosty;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String database_name ="Historia";
    public static final String database_table ="Historiaa";
    public static final String database_id_column ="ID";
    public static final String database_patch ="Equation";

    private static final String database_entries =
            "CREATE TABLE "+ database_table + "(" + database_id_column + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ database_patch + " TEXT)";
    private static final String database_entries_delete = "DROP TABLE IF EXISTS " + database_table;

    public DatabaseHelper(Context context){
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(database_entries);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(database_entries_delete);
        onCreate(db);
    }
    public boolean addData(String TextE)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(database_patch, TextE);
        if(database.insert(database_table, null, contentValues)==-1) {
            return false;
        }
        else{
            return true;
        }

    }
    public ArrayList<String> getData()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor result = database.rawQuery("SELECT * FROM " + database_table, null);
        ArrayList<String> listOfEquations = new ArrayList<>();
        while(result.moveToNext())
        {
            listOfEquations.add(result.getString(1));
        }
        return listOfEquations;

    }
    public void cleanDatebase(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(database_entries_delete);
        onCreate(database);
    }
}
