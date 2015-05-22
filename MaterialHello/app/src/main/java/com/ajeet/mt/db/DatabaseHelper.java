package com.ajeet.mt.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private Context context;
	private static String DB_NAME = "greymeter";
	private static int DB_VERSION = 1;
	public static final String TABLE_USER_DETAILS = "UserDetails";
	public static final String TABLE_POSTS = "Posts";

	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE UserDetails(UserId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , UserName TEXT NOT NULL,	Email TEXT ,MobileNumber TEXT,CreatedDate DATE NOT NULL, LastUpdatedDate DATE NOT NULL)");
		db.execSQL("CREATE TABLE Posts(Id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,PostText TEXT NOT NULL,PostedBy TEXT NOT NULL, Likes INTEGER, CreatedDate DATE NOT NULL,LastUpdatedDate DATE NOT NULL)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE " + TABLE_USER_DETAILS + "IF EXISTS");
		db.execSQL("DROP TABLE " + TABLE_POSTS + "IF EXISTS");
		onCreate(db);
	}

}
