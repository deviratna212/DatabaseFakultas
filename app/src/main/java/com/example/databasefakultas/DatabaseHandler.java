package com.example.databasefakultas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    //deskripsi nama dan database version
    private static final int DATABASE_version = 1;
    private static final String DATABASE_NAME = "dbFakultas.db";

    //deskripsi tabel dan kolom aktivitas
    private static final String TABLE_FK = "fakultas";
    private static final String KEY_FK_ID = "id_fk";
    private static final String KEY_FK_NAME = "fk_name";

    //create tabel aktivitas
    private static final String CREATE_TABLE_FAKULTAS = "CREATE TABLE " + TABLE_FK + "("
            + KEY_FK_ID + " STRING PRIMARY KEY,"
            + KEY_FK_NAME + " STRING NOT NULL)";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_version);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FAKULTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ TABLE_FK);
        onCreate(db);

    }

}
