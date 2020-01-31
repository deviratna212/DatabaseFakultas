package com.example.databasefakultas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class FakultasHelper {

    private DatabaseHandler databaseHandler;

    public FakultasHelper(Context context){
        databaseHandler = new DatabaseHandler(context);
    }

    //Method Insert
    public int insertFakultas(Fakultas fakultas){
        SQLiteDatabase sqLiteDatabase = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Fakultas.KEY_FK_ID, fakultas.idFk);
        values.put(Fakultas.KEY_FK_NAME, fakultas.fakName);

        long result = sqLiteDatabase.insert(Fakultas.TABLE_FK, null, values);
        sqLiteDatabase.close();;
        return (int) result;
    }

    //Method Update
    public int updateFakultas(Fakultas fakultas){
        SQLiteDatabase sqLiteDatabase = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Fakultas.KEY_FK_ID, fakultas.idFk);
        values.put(Fakultas.KEY_FK_NAME, fakultas.fakName);

        long result = sqLiteDatabase.update(Fakultas.TABLE_FK, values, Fakultas.KEY_FK_ID + "=?", new String[] {
                String.valueOf(fakultas.idFk)
        });
        sqLiteDatabase.close();;
        return (int) result;
    }

    //Method Delete
    public boolean deleteFakultas(String id){
        SQLiteDatabase sqLiteDatabase = databaseHandler.getWritableDatabase();
        return sqLiteDatabase.delete(Fakultas.TABLE_FK, Fakultas.KEY_FK_ID + "='" + id + "';", null) > 0;
    }

    //Method get Data Fakultas
    public ArrayList<Fakultas> getFakultasData(){
        SQLiteDatabase sqLiteDatabase = databaseHandler.getReadableDatabase();
        ArrayList<Fakultas> fakultasList = new ArrayList<Fakultas>();

        String selectQuery = "select * from " + Fakultas.TABLE_FK;
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        Fakultas fakultas;
        if (cursor.getCount() > 0){
            do {
                fakultas = new Fakultas();
                fakultas.setIdFk(cursor.getString(cursor.getColumnIndexOrThrow(Fakultas.KEY_FK_ID)));
                fakultas.setFakName(cursor.getString(cursor.getColumnIndexOrThrow(Fakultas.KEY_FK_NAME)));

                fakultasList.add(fakultas);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return  fakultasList;
    }
}
