package org.persistency.dagumar;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SharedPrefsPersistencyActivity extends Activity {

	private static final String LVL = "lvl";
	Button btnSave = null;
	EditText edtDificultyLvl = null;
	SharedPreferences prefs = null;
	SharedPreferences.Editor editorPreferences = null;

	OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			savePreferences();
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		initSharedPreferences();
		
		btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(onClickListener);

		edtDificultyLvl = (EditText) findViewById(R.id.edtDificultyLvl);
		edtDificultyLvl.setText(readPreferences());

	}
	
	private void initSharedPreferences(){
		prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		editorPreferences = prefs.edit();
	}

	private String readPreferences() {
		return prefs.getString(LVL, "");
	}

	private void savePreferences() {
		editorPreferences.putString(LVL, edtDificultyLvl.getText().toString());
		editorPreferences.commit();
	}

}