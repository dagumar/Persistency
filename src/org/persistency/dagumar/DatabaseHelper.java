package org.persistency.dagumar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 8;
	private static final String DATABASE_NAME = "data";

	DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(AlumnosManager.DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//db.execSQL("DROP TABLE IF EXISTS " + AlumnosManager.TABLE);
		db.execSQL("ALTER TABLE " + AlumnosManager.TABLE + " ADD " + AlumnosManager.KEY_NAME + " text");
		Log.e("Activity", "Alter table!!");
		//onCreate(db);
	}
	
	
}
