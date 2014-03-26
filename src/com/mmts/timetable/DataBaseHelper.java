package com.mmts.timetable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DataBaseHelper extends SQLiteAssetHelper {

	// The Android's default system path of your application database.
	private static final String DATABASE_NAME = "northwind";
	private static final int DATABASE_VERSION = 1;


	/**
	 * Constructor Takes and keeps a reference of the passed context in order to
	 * access to the application assets and resources.
	 * 
	 * @param context
	 */
	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
		// you can use an alternate constructor to specify a database location 
		// (such as a folder on the sd card)
		// you must ensure that this folder is available and you have permission
		// to write to it
		//super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);
		
	}
	public Cursor getTimeTable() {

		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		String arrivaltime = "08:00:00";
		String departuretime = "10:00:00";
		

		String [] sqlSelect = {"Train_no", "Departure_station","Departure_time","Destination_time","Destination_Station","Arriva_time"}; 
		String sqlTables = "Employees";
		String arrival = "Arriva_time between ? and ?";
		
		String [] times = new String[]{arrivaltime,departuretime};
		
		qb.setTables(sqlTables);
		Cursor c = qb.query(db, sqlSelect, arrival, times,
				null, null, null);

		c.moveToFirst();
		return c;

	}


	
	
	
	/**
	 * Creates a empty database on the system and rewrites it with your own
	 * database.
	 * */
/**	public void createDataBase() throws IOException {

		boolean dbExist = checkDataBase();
		SQLiteDatabase db_Read = null;

		if (!dbExist) {

			// By calling this method and empty database will be created into
			// the default system path
			// of your application so we are gonna be able to overwrite that
			// database with our database.
			db_Read = this.getReadableDatabase();
			db_Read.close();
			try {

				copyDataBase();

			} catch (IOException e) {

				throw new Error("Error copying database");

			}
		}

	}

	/**
	 * Check if the database already exist to avoid re-copying the file each
	 * time you open the application.
	 * 
	 * @return true if it exists, false if it doesn't
	 */
	/**    private boolean checkDataBase() 
    { 
        File dbFile = new File(DB_PATH + DB_NAME); 
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists()); 
        return dbFile.exists(); 
    } 

	/**
	 * Copies your database from your local assets-folder to the just created
	 * empty database in the system folder, from where it can be accessed and
	 * handled. This is done by transfer of byte stream.
	 * */

}