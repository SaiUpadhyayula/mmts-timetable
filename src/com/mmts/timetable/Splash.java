package com.mmts.timetable;

import com.mmts.timetable.R;
import com.mmts.timetable.ViewActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class Splash extends Activity {

	TextView view1;
    /* Called when Activity is first created */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		view1 = (TextView)findViewById(R.id.textView1);
	}
	
	/* Called when the Button in the Activity is clicked */

	public void onIconClick(View v){
    	startActivity(new Intent(this, ViewActivity.class));    	
    }
    
  

}
