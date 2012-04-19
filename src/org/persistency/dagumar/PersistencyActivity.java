package org.persistency.dagumar;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PersistencyActivity extends Activity {

	private static final String LVL = "lvl";
	Button btnSave;
	EditText edtDificultyLvl;
	SharedPreferences prefs = null;
	String savedLvl = "";

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			savePreferences();
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(onClickListener);
		edtDificultyLvl = (EditText) findViewById(R.id.edtDificultyLvl);
		edtDificultyLvl.setText(readPreferences());

	}

	private String readPreferences() {
		return prefs.getString(LVL, "");

	}

	private void savePreferences() {
		SharedPreferences.Editor editorPreferences = prefs.edit();
		editorPreferences.putString(LVL, edtDificultyLvl.getText().toString());
		editorPreferences.commit();

	}

}