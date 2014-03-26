package com.mmts.timetable;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ResultActivity extends ListActivity {

	private TextView	resTextView;
	private ListView	resListView;
	private String		destination_station;
	private String		departure_time;
	private String		departure_station;
	private String		arriva_time;
	private DataBaseHelper db;
	private Cursor trains;

	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultstable);

		resTextView = (TextView) findViewById(R.id.dataFound);
		resListView = (ListView) findViewById(R.id.list);

		destination_station = getIntent().getExtras().getString("srcStationName");
		departure_station = getIntent().getExtras().getString("descStationName");
		departure_time = getIntent().getExtras().getString("startTime");
		arriva_time = getIntent().getExtras().getString("reachTime");

		//findTrains();
		
		db = new DataBaseHelper(this);
		trains = db.getTimeTable(); 

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, 
				android.R.layout.simple_list_item_2, 
				trains, 
				new String[] {"Departure_Time","Arrival_Time"}, 
				new int[] {android.R.id.text1, android.R.id.text2});

		resListView.setAdapter(adapter);
	}

/**	private void findTrains() {

        ResultsAdapter tdbHelper = new ResultsAdapter(this);
        tdbHelper.createDatabase();
        tdbHelper.open();

        Cursor testdata = tdbHelper.getTestData(departure_time , arriva_time);
	
        ArrayList<String> depttime = UltilityClass.GetColumnValue(testdata, "Departure_time");
    	ArrayList<String> arrivaltime = UltilityClass.GetColumnValue(testdata, "Arriva_time");
    	
    	UltilityClass.ShowMessageBox(this, "Depttime: "+ depttime + " and Email: "+ arrivaltime);
    	tdbHelper.close();
 **/   	
	

}
