package com.demotxt.droidsrce.welcomescreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Ervin-PC on 2018. 03. 11..
 */

public class DatabaseManager extends SQLiteOpenHelper{

    private static final int DBVersion = 1;
    private static final String DBName = "Database";

    private static final String Table_Name = "Capsules";

    private static final String Capsule_Type = "Capsule_Type";
    private static final String Number = "Number";
    private static final String Number_Of_Brewing = "Number_Of_Brewing";

    private static final String Create_Table = "CREATE TABLE "+ Table_Name + "("
            + Capsule_Type + " TEXT, "
            + Number + " INTEGER, "
            + Number_Of_Brewing + " INTEGER)";

    private static final String Drop_Database = "DROP TABLE IF EXISTS "+Table_Name;

    public DatabaseManager(Context context){
        super(context,DBName,null,DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Create_Table);
        //baseInsert();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Drop_Database);
        onCreate(sqLiteDatabase);
    }

    public void insert(String Cap_Type){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Capsule_Type,Cap_Type);
        values.put(Number,0);
        values.put(Number_Of_Brewing,0);
        db.insert(Table_Name,null,values);
    }

    public void updateDB(String Capsule_Name,int number,int number_of_growing){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Number,number);
        values.put(Number_Of_Brewing,number_of_growing);
        db.update(Table_Name,values,Capsule_Type + " =?",new String[]{Capsule_Name});
    }

    public String[] selectCapsuleNames(){
        ArrayList list = new ArrayList<String>();
        String selectQuery = "SELECT "+ Capsule_Type +" FROM "+Table_Name;
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()) {
            do {
                result = cursor.getString(cursor.getColumnIndex(Capsule_Type));
                list.add(result);
            } while (cursor.moveToNext());
        }

        String[]retlist = new String[list.size()];
        retlist = (String[])list.toArray(retlist);
        return retlist;
    }

    public Integer[] getNumbers(){
        Integer[] list = new Integer[3];
        int mark = 0;
        String selectQuery = "SELECT "+ Number +" FROM "+Table_Name;
        int result;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()) {
            do {
                result = cursor.getInt(cursor.getColumnIndex(Number));
                list[mark] = result;
                mark++;
            } while (cursor.moveToNext());
        }
        return list;
    }

    public Integer[] getNumber_Of_Growing(){
        Integer[] list = new Integer[3];
        int mark = 0;
        String selectQuery = "SELECT "+ Number_Of_Brewing +" FROM "+Table_Name;
        int result;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()) {
            do {
                result = cursor.getInt(cursor.getColumnIndex(Number_Of_Brewing));
                list[mark] = result;
                mark++;
            } while (cursor.moveToNext());
        }
        return list;
    }
}