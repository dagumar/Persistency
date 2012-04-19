package org.persistency.dagumar;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BDPersistenceActivity extends Activity {

	Button btnSave = null;
	private Button btnGet;
	EditText txtSurname = null;
	EditText txtMark = null;
	DatabaseHelper dbHelper = null;
	SQLiteDatabase db = null;

	OnClickListener onclickListenerSave = new OnClickListener() {

		@Override
		public void onClick(View v) {
			saveAlumno();
		}
	};
	OnClickListener onclickListenerGet = new OnClickListener() {

		@Override
		public void onClick(View v) {
			getAlumno();
		}
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_alumnos);
		initComponents();

	}

	private void initComponents() {

		btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(onclickListenerSave);
		btnGet = (Button) findViewById(R.id.btnGet);
		btnGet.setOnClickListener(onclickListenerGet);
		txtSurname = (EditText) findViewById(R.id.txtSurname);
		txtMark = (EditText) findViewById(R.id.txtMark);
		dbHelper = new DatabaseHelper(this.getApplicationContext());
	}

	protected void saveAlumno() {
		String surname = txtSurname.getText().toString();
		String mark = txtMark.getText().toString();

		AlumnosManager.Factory(dbHelper).createAlumno(surname,
				Integer.parseInt(mark));
	}
	protected void getAlumno() {
		AlumnosManager alumno = AlumnosManager.Factory(dbHelper);
		alumno.getAlumnos();
		showAlumno(alumno.getSurname() + " " + alumno.getMark());
	}
	
	private void showAlumno(String text){
		Toast.makeText(getBaseContext(), text, Toast.LENGTH_LONG).show();
	}

}
