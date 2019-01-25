package com.example.sebastian.kalkulatorprosty.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Database extends SQLiteOpenHelper {
    private static final String database_name = "Historia";
    protected static final String database_table = "Historiaa";
    private static final String database_id_column = "ID";
    protected static final String database_patch = "Equation";

    private static final String database_entries =
            "CREATE TABLE " + database_table + "(" + database_id_column + " INTEGER PRIMARY KEY AUTOINCREMENT," + database_patch + " TEXT)";
    protected static final String database_entries_delete = "DROP TABLE IF EXISTS " + database_table;

    public Database(Context context) {
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
}

