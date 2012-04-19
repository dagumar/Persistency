package org.persistency.dagumar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SavingFilesInSDCardActivity extends Activity {

	Button btnTry = null;

	OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			stateOfSDCard();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sd_card);
		btnTry = (Button) findViewById(R.id.btnTry);
		btnTry.setOnClickListener(onClickListener);

	}

	private void stateOfSDCard(){
		String state = Environment.getExternalStorageState();
		
			if(  Environment.MEDIA_REMOVED.equals(state))				
				showToast( "No SD present");
			else if(  Environment.MEDIA_MOUNTED.equals(state))				
				showToast( "SD mounted");
			else if(  Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))				
				showToast( "SD read only");
			else if(  Environment.MEDIA_UNMOUNTED.equals(state))				
				showToast( "SD present but unmounted");
			else 
				showToast( "Other state");
			
	}
	
	private void showToast(String text){
		Toast.makeText(this,text, Toast.LENGTH_LONG).show();
		
	}
}
