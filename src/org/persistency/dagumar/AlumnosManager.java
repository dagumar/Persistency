package org.persistency.dagumar;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class AlumnosManager {

	private String surname = "";
	private Integer mark = null;
	public static final String TABLE = "alumnos";
	public static final String KEY_SURNAME = "surname";
	public static final String KEY_MARK = "mark";
	public static final String KEY_NAME = "name";
	public static final String DATABASE_CREATE = "" + "CREATE TABLE " + TABLE
			+ " (" + "	" + KEY_SURNAME + " varchar2(20), " 
			+ "	" + KEY_MARK + " int(2), " 
			+ " "+ KEY_NAME +  " varchar2(20) )";

	private DatabaseHelper dbHelper = null;
	private SQLiteDatabase db = null;

	public static AlumnosManager Factory(DatabaseHelper dbHelper) {
		return new AlumnosManager(dbHelper);
	}

	private AlumnosManager(DatabaseHelper dbHelper) {
		this.dbHelper = dbHelper;

	}

	private AlumnosManager alumnoFromCursor(Cursor cursor, AlumnosManager alumno){
		alumno.setSurname(cursor.getString(cursor.getColumnIndex(KEY_SURNAME)));
		alumno.setMark(cursor.getInt(cursor.getColumnIndex(KEY_MARK)));
		return alumno;
	}
	private AlumnosManager alumnoFromCursor(Cursor cursor){
		this.setSurname(cursor.getString(cursor.getColumnIndex(KEY_SURNAME)));
		this.setMark(cursor.getInt(cursor.getColumnIndex(KEY_MARK)));
		return this;
	}
	
	public void getAlumnos() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues content = new ContentValues();
		content.put("surname", surname);
		content.put("mark", mark);
		Cursor cursor = db.query(TABLE, new String[] { KEY_SURNAME, KEY_MARK },
				null, null, null, null, null);

		if (cursor != null) {
			cursor.moveToFirst();
			do {
				alumnoFromCursor(cursor);
			} while (cursor.moveToNext());
			cursor.close();
		}

	}

	public void createAlumno(String surname, int mark) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues content = new ContentValues();
		content.put("surname", surname);
		content.put("mark", mark);
		db.insert(TABLE, null, content);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

}
