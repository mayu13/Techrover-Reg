package com.example.sqlite;

import java.util.ArrayList;

import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;


public class Database extends SQLiteOpenHelper
{
	
	 private static final String  DATABAE_NAME="MyDatabase";
	 private static final int DATABASE_VERSION=3;
	 //table name
	 private static final String CONTACT="My_Table";
	 private static final String TABLE_SCHEDULE="My_Table2";
	 private static final String COURSE_SEL="My_table3";
	 private static final String CONTACT_ID="_id";
	 
	 //contact column name
	 private static final String CONTACT_FNAME="FirstName";
	 private static final String CONTACT_LNAME="LastName";
	 private static final String CONTACT_CITY="City";
	 private static final String CONTACT_EMAIL="Email";
	 private static final String CONTACT_NO="No";
	/* private static final String USERNAME="username";
	 private static final String PASSWORD="password";*/
	 private static final String IMAGE="Photo";
	 
	 public static final String APP_NAME = "AdvancedSearch";
	 
	 //schedule column name
	 
	 private static final String START_DATE="Start_date";
	 private static final String STOP_DATE="Stop_date";
	 private static final String DAYS_WEEK="Days_of_week";
	 private static final String TRAINER_NAME="Trainer_name";
	 private static final String RATING="Rating_bar";
	 
	 //course_sel colume name
	 
	 private static final String SUBJECT="Subject_name";
	 private static final String START="Start_date_info";
	 
	  Bundle bundle;
	
	 private static final String DATABASE_CREATE = "Create Table " + CONTACT+ "(" 
	         + CONTACT_ID+ " integer primary key autoincrement," 
			 + CONTACT_FNAME+ " text," 
			 + CONTACT_LNAME+ " text,"
			 + CONTACT_CITY+ " text," 
			 + CONTACT_EMAIL+ " text," 
			 + CONTACT_NO+ " text," 
		     + IMAGE+ " BLOB)";
	 
	 
	 private static final String SCHEDULE_DATABASE="Create Table " + TABLE_SCHEDULE+ "("
			 + CONTACT_ID+ " integer primary key autoincrement,"
			 + START_DATE+ " text,"
			 + STOP_DATE+ " text,"
			 + DAYS_WEEK+ " text,"
			 + TRAINER_NAME+ " text,"
			 + RATING+ " text)";
	 
	 private static final String COURSE_DATABASE="Create Table " + COURSE_SEL+ "("
			 + CONTACT_ID+ " integer primary key autoincrement,"
			 + SUBJECT+ " text,"
			 + START+ " text)";
			 
	 

	public Database(Context context)
	{
		super(context, DATABAE_NAME, null, DATABASE_VERSION);
		
	}
	
	@Override 
	public void onCreate(SQLiteDatabase db)
	{
		
		db.execSQL(DATABASE_CREATE);
		db.execSQL(SCHEDULE_DATABASE);
		db.execSQL(COURSE_DATABASE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// TODO Auto-generated method stub
		db.execSQL("Drop Table if exists " +CONTACT);
		db.execSQL("Drop Table if exists " +TABLE_SCHEDULE);
		db.execSQL("Drop Table if exists " +COURSE_SEL);
		onCreate(db);
	}
	
	
	public void InsertData(List list)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		
		cv.put(CONTACT_FNAME, list.FirstName);
		cv.put(CONTACT_LNAME, list.LastName);
		cv.put(CONTACT_CITY, list.City);
		cv.put(CONTACT_EMAIL, list.Email);
		cv.put(CONTACT_NO, list.No);
	
		cv.put(IMAGE, list.image);
		
		
		db.insert(CONTACT, null, cv);
		db.close();
	}
	
	public void Insert_Schedule(String sd, String st, String days, String name, String rating)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		
		cv.put(START_DATE, sd);
		cv.put(STOP_DATE, st);
		cv.put(DAYS_WEEK, days);
		cv.put(TRAINER_NAME, name);
		cv.put(RATING, rating);
		
		db.insert(TABLE_SCHEDULE, null, cv);
		db.close();
	}
	
	public void Insert_course(String result, String start)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		
		cv.put(SUBJECT, result);
		cv.put(START, start);
	
		db.insert(COURSE_SEL, null, cv);
		db.close();
	}
	
	
	public ArrayList<List> GetData()
	{
		SQLiteDatabase db=this.getReadableDatabase();
		ArrayList<com.example.sqlite.List> array=new ArrayList<com.example.sqlite.List>();
		String q="select * from " + CONTACT;
		Cursor cr = db.rawQuery(q, null);
		cr.moveToFirst();
		
		
		while(cr.isAfterLast()==false)
		{
			List list=new List();
			
			list.setFname(cr.getString(cr.getColumnIndex(CONTACT_FNAME)));
			list.setLname(cr.getString(cr.getColumnIndex(CONTACT_LNAME)));
			list.setCity(cr.getString(cr.getColumnIndex(CONTACT_CITY)));
			list.setMail(cr.getString(cr.getColumnIndex(CONTACT_EMAIL)));
			list.setNo(cr.getString(cr.getColumnIndex(CONTACT_NO)));
		    list.setImage(cr.getBlob(cr.getColumnIndex(IMAGE)));
			
			array.add(list);
			cr.moveToNext();
		}
		System.out.println("array size in getdata is : "+array.size());
		return array ;
	}
	
	
	
	
	
	
	
	

}
