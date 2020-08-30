package com.example.complaintapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    private static final String dbname="mydb";
    private static final int version=1;
    public MyHelper(Context context){
        super(context,dbname,null,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql="CREATE TABLE PRODUCTS(ID INTEGER PRIMARY KEY AUTOINCREMENT, Title TEXT)";
        db.execSQL(sql);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    /*private void insertData(String name, String descrition, double price, SQLiteDatabase database){

        values.put("NAME",name);
        values.put("DESCRIPTION",descrition);
        values.put("PRICE",price);
        database.insert("PRODUCTS", null,values);
    }*/
    public boolean addData(String item){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("Title",item);
        long result= database.insert("PRODUCTS",null,values);

        if (result==-1){
            return false;
        }
        else{
            return true;
        }
    }
}
