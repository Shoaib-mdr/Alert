package com.kuce2k15.alert;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "FriendsDatabase";

    // Table name
    private static final String TABLE_Friends = "FriendsTable";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_Name = "Name";
    private static final String KEY_Phone = "Phone";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_Friends_TABLE = "CREATE TABLE " + TABLE_Friends +
                "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_Name + " TEXT,"
                + KEY_Phone + " TEXT " + ")";
        db.execSQL(CREATE_Friends_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Friends);

        // Create tables again
        onCreate(db);
    }

    // Adding new Friends
    public void addFriends(Friends Friends){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_Name , Friends.getmName());
        values.put(KEY_Phone , Friends.getmPhone());

        // Inserting Row
        long ID = db.insert(TABLE_Friends, null, values);
        db.close();
    }

    // Getting all Friends
    public List<Friends> getAllFriends(){
        List<Friends> FriendsList = new ArrayList<>();

        // Select all Query
        String selectQuery = "SELECT * FROM " + TABLE_Friends;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if(cursor.moveToFirst()){
            do{
                Friends Friends = new Friends();
                Friends.setmID(Integer.parseInt(cursor.getString(0)));
                Friends.setmName(cursor.getString(1));
                Friends.setmPhone(cursor.getString(2));
                // Adding Friends to list
                FriendsList.add(Friends);
            } while (cursor.moveToNext());
        }
        return FriendsList;
    }

    // Getting Friends Count
    public int getFriendsCount(){
        String countQuery = "SELECT * FROM " + TABLE_Friends;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();

        return cursor.getCount();
    }

    // Updating single Friends
    public int updateFriends(Friends Friends){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_Name , Friends.getmName());
        values.put(KEY_Phone , Friends.getmPhone());


        // Updating row
        return db.update(TABLE_Friends, values, KEY_ID + "=?",
                new String[]{String.valueOf(Friends.getmID())});
    }

    // Deleting single Friends
    public void deleteFriends(Friends Friends){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Friends, KEY_ID + "=?",
                new String[]{String.valueOf(Friends.getmID())});
        db.close();
    }
}
