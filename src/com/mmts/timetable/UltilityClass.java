package com.mmts.timetable;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.view.Gravity;
import android.widget.Toast;

public class UltilityClass {

	public static ArrayList GetColumnValue(Cursor cur, String ColumnName) {
		ArrayList<String> aList= new ArrayList<String>();
		try {
			cur.moveToFirst();
			while(!cur.isAfterLast()){
				 aList.add(cur.getString(cur.getColumnIndex(ColumnName)));
			}
			return aList;
		} catch (Exception ex) {
			return aList;
		}
	}
	
	public static void ShowMessageBox(Context cont, String msg) {
		Toast toast = Toast.makeText(cont, msg, Toast.LENGTH_SHORT);
		// toast.setGravity(Gravity.CENTER, 0, 0);
		toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
		toast.show();
	}
}
