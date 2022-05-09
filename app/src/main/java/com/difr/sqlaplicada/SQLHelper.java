package com.difr.sqlaplicada;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {
    private static final String COMENTS_TABLE_CREATE =
            "CREATE TABLE informe("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, concepto TEXT, fecha TEXT,tipo TEXT,monto INTEGER)";
    private static final String DB_NAME = "informe.sqlite";
    public static final int DB_VERSION = 1;
    public SQLHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(COMENTS_TABLE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}