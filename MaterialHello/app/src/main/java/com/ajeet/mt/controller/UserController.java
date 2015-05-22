package com.ajeet.mt.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ajeet.mt.db.DatabaseHelper;
import com.ajeet.mt.model.UserDetail;
import com.ajeet.mt.util.Common;


public class UserController {
	private Context context;
	
	public UserController(Context context) {
		this.context = context;
		
	}
	
	

	public long addNewUser(UserDetail user){
		SQLiteDatabase sqldb = new DatabaseHelper(context)
		.getWritableDatabase();
		long addUser;
		ContentValues values = new ContentValues();
		//values.put("UserId", user.getUserId());
		values.put("UserName", user.getUserName());
		values.put("Email", user.getEmail());
		values.put("MobileNumber", user.getMobile());
		values.put("CreatedDate",Common.getCurrentDateTime());
		values.put("LastUpdatedDate", Common.getCurrentDateTime());
		
		addUser = sqldb.insert(DatabaseHelper.TABLE_USER_DETAILS, null, values);
		sqldb.close();
		return addUser;
		
	}
	
}
