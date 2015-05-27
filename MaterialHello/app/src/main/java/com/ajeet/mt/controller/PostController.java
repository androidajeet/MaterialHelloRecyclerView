package com.ajeet.mt.controller;


		import java.util.ArrayList;
		import java.util.List;

		import android.content.ContentValues;
		import android.content.Context;
		import android.database.Cursor;
		import android.database.sqlite.SQLiteDatabase;

		import com.ajeet.mt.db.DatabaseHelper;
		import com.ajeet.mt.model.Post;
		import com.ajeet.mt.util.Common;


public class PostController {
	private Context context;

	public PostController(Context context) {
		this.context = context;

	}

	public long addNewPost(Post post) {
		SQLiteDatabase sqldb = new DatabaseHelper(context)
				.getWritableDatabase();
		long addPost;
		ContentValues values = new ContentValues();
		// values.put("Id", post.getPostId());
		values.put("PostText", post.getPostText());
		values.put("PostedBy", post.getPostedBy());
		values.put("Likes", 0);
		values.put("CreatedDate", Common.getCurrentLocalDateTime());
		values.put("LastUpdatedDate", Common.getCurrentLocalDateTime());

		addPost = sqldb.insert(DatabaseHelper.TABLE_POSTS, null, values);
		sqldb.close();
		return addPost;

	}

	public List<Post> getAllPost() {
		SQLiteDatabase sqldb = null;
		Cursor cursor = null;
		// String date = Common.getCurrentDate();
		List<Post> postList = new ArrayList<Post>();
		try {

			sqldb = new DatabaseHelper(context).getReadableDatabase();
			cursor = sqldb.rawQuery("SELECT * FROM Posts", null);

			if (cursor != null && cursor.getCount() > 0) {

				while (cursor.moveToNext()) {
					postList.add(getPost(cursor));
				}
			}

		} catch (Exception exc) {

			System.out.println(exc);
			exc.printStackTrace();
		} finally {
			if (cursor != null)
				cursor.close();
			if (sqldb.isOpen())
				sqldb.close();
		}

		return postList;

	}

	public Post getPost(Cursor cursor) {
		Post post = new Post();

		post.setPostId(cursor.getInt(cursor.getColumnIndex("Id")));

		post.setPostText(cursor.getString(cursor.getColumnIndex("PostText")));
		post.setPostedBy(cursor.getString(cursor.getColumnIndex("PostedBy")));
		post.setLikes(cursor.getInt(cursor.getColumnIndex("Likes")));

		post.setCreatedDate(cursor.getString(cursor
				.getColumnIndex("CreatedDate")));

		post.setLastUpdatedDate(cursor.getString(cursor
				.getColumnIndex("LastUpdatedDate")));

		return post;
	}

	public boolean updateTask(int postId,int count) {


		SQLiteDatabase sqldb = null;
		boolean isUpdated=false;
		try {
			sqldb = new DatabaseHelper(context).getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("Likes",count);
			long x = sqldb.update(DatabaseHelper.TABLE_POSTS, values, "Id=?",
					new String[] {postId+"" });
			if (x > 0){
				isUpdated=true;
			}
			else{
				isUpdated=false;
			}

		} catch (Exception exce) {
			exce.printStackTrace();
			isUpdated=false;
		} finally {

			if (sqldb.isOpen())
				sqldb.close();
		}
		return isUpdated;

	}








}
