package com.mmts.timetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class ViewActivity extends Activity {

	private Spinner	sp1;
	private Spinner	sp2;
	private Spinner	sp3;
	private Spinner	sp4;
	private Button	findTrains;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timetable);
		
		sp1 = (Spinner)findViewById(R.id.spinner1);
		sp2 = (Spinner)findViewById(R.id.spinner2);
		sp3 = (Spinner)findViewById(R.id.spinner3);
		sp4 = (Spinner)findViewById(R.id.spinner4);
		findTrains = (Button)findViewById(R.id.button1);

		/*Create an ArrayAdapter to display the data when we click on the Spinner, to select Source Station*/
		ArrayAdapter<CharSequence> stationAdapter = ArrayAdapter.createFromResource(
				this, R.array.src_array, android.R.layout.simple_spinner_item);
		stationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp1.setAdapter(stationAdapter);
		
		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		        sp1.getSelectedItemPosition();
		        Toast.makeText(getBaseContext(), 
		            "Station Name: " +  arg0.getItemAtPosition(arg2).toString(), 
		            Toast.LENGTH_SHORT).show();
		    }

		    @Override
		    public void onNothingSelected(AdapterView<?> arg0) {
		    }
		});
		
		/*Create an ArrayAdapter to display the data when we click on the Spinner, to select Destination Station*/
		ArrayAdapter<CharSequence> stationAdapter2 = ArrayAdapter.createFromResource(
				this, R.array.desc_array, android.R.layout.simple_spinner_item);
		stationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp2.setAdapter(stationAdapter2);
		
		sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				sp2.getSelectedItemPosition();
				Toast.makeText(getBaseContext(), 
						"Station Name: " +  arg0.getItemAtPosition(arg2).toString(), 
						Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		
		/*Create an ArrayAdapter to display the data when we click on the Spinner, to select Start Time*/
		ArrayAdapter<CharSequence> stationAdapter3 = ArrayAdapter.createFromResource(
				this, R.array.time_array, android.R.layout.simple_spinner_item);
		stationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp3.setAdapter(stationAdapter3);

		sp3.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				sp3.getSelectedItemPosition();
				Toast.makeText(getBaseContext(), 
						"Time: " +  arg0.getItemAtPosition(arg2).toString(), 
						Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		/*Create an ArrayAdapter to display the data when we click on the Spinner, to select Reach Time*/
		ArrayAdapter<CharSequence> stationAdapter4 = ArrayAdapter.createFromResource(
				this, R.array.times_array, android.R.layout.simple_spinner_item);
		stationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp4.setAdapter(stationAdapter4);
		
		sp4.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				sp4.getSelectedItemPosition();
				Toast.makeText(getBaseContext(), 
						"Time: " +  arg0.getItemAtPosition(arg2).toString(), 
						Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		
		/*Create a Listener and do certain Task when the Button is Clicked.*/
		findTrains.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				addTask();
			}

			private void addTask() {
			
				Intent trainIntent = new Intent(ViewActivity.this, ResultActivity.class);
				trainIntent.putExtra("srcStationName", sp1.getSelectedItem().toString());
				trainIntent.putExtra("destStationName", sp2.getSelectedItem().toString());
				trainIntent.putExtra("startTime", sp3.getSelectedItem().toString());
				trainIntent.putExtra("reachTime", sp4.getSelectedItem().toString());
				startActivity(trainIntent);
				
			}
		});
	}
}
