package com.example.sqlite;

import java.text.DecimalFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Schedule_timing extends Activity implements  OnClickListener, OnItemSelectedListener, OnRatingBarChangeListener
{

	Spinner spinnerdate, spinnername;
	TextView starttext, stoptext, viewfeedback, ratingset;
	Button  submitbtn;
	EditText startbtn, stopbtn;
	ImageView startImage, stopImage;
	private String[] date_info = {"Monday to Saturday", "Mon-Wed-Fri", "Tue-Thu-Sat", "Mon-Tue-Wed", "Thu-Fri-Sat"};
	private String[] trainer_name={"Nayan Sir"};
	private int mYear, mMonth, mDay;
	RatingBar rating, setrating;
	int count;
    float curRate;

    Database db;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.schedule_timing);
		 db = new Database(this);
		 
		 spinnerdate=(Spinner)findViewById(R.id.spinnerdate);
		 spinnername=(Spinner)findViewById(R.id.spinnertrainer);
		 
		 startImage=(ImageView)findViewById(R.id.imageStartdate);
		 stopImage=(ImageView)findViewById(R.id.imageStopdate);
		 
		 startbtn=(EditText)findViewById(R.id.editStart);
		 stopbtn=(EditText)findViewById(R.id.editStop);
		 submitbtn=(Button)findViewById(R.id.buttonsubmit);
		 
		 viewfeedback=(TextView)findViewById(R.id.textfeedback);
		 
		 ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, date_info);
		 adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 spinnerdate.setAdapter(adapter1);
		 spinnerdate.setOnItemSelectedListener(this);
		 
		 
		 ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, trainer_name);
		 adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 spinnername.setAdapter(adapter2);
		 spinnername.setOnItemSelectedListener(this);
		 
		 startImage.setOnClickListener(this);
		 stopImage.setOnClickListener(this);
		 
		 rating=(RatingBar)findViewById(R.id.ratingBar1);
		 setrating=(RatingBar)findViewById(R.id.ratingBar2);
		 ratingset=(TextView)findViewById(R.id.textView1);
		 
		 setrating.setRating(curRate);
	     rating.setOnRatingBarChangeListener(this);
		 
		 
		 submitbtn.setOnClickListener(new OnClickListener()
		 {
			
			@Override
			public void onClick(View v) 
			{
				
				String startdate=startbtn.getText().toString();
				String stopdate=stopbtn.getText().toString();
				String days=spinnerdate.getSelectedItem().toString().trim();
				String trainernanme=spinnername.getSelectedItem().toString().trim();
				String rating_value=ratingset.getText().toString();
				
				db.Insert_Schedule(startdate, stopdate, days, trainernanme, rating_value);
				
				Toast.makeText(getApplicationContext(), "Success.....", Toast.LENGTH_LONG).show();
			
				Intent i=new Intent(Schedule_timing.this, Thank_you.class);
		        startActivity(i);	
			}
		});
		 
		 
		 viewfeedback.setOnClickListener(new OnClickListener() 
		 {
			
			@Override
			public void onClick(View v) 
			{
				Intent feedback=new Intent(Schedule_timing.this, Feed_back.class);
				startActivity(feedback);
				
			}
		});
			 
	}
	
	
	 public void onRatingChanged(RatingBar rateBar, float rating,
	            boolean fromUser) 
	 {
	        DecimalFormat decimalFormat = new DecimalFormat("#.#");
	        curRate = Float.valueOf(decimalFormat.format((curRate * count + rating)
	                / ++count));
	        Toast.makeText(Schedule_timing.this,
	                "New Rating: " + curRate, Toast.LENGTH_SHORT).show();
	        setrating.setRating(curRate);
	        ratingset.setText(count + " Ratings");
	    }
	
	
	
   @Override	
	public void onClick(View v)
	{
		if(v == startImage)
		{
			final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
 
            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() 
            {
 
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                        {
                            // Display Selected date in textbox
                        	startbtn.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                              
                        }
              }, mYear, mMonth, mDay);
            
            dpd.show();
		}
		
		else if(v == stopImage)
		{
			final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
 
            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() 
            {
 
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                        {
                            // Display Selected date in textbox
                        	stopbtn.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                              
                        }
              }, mYear, mMonth, mDay);
            
            dpd.show();
		}
			
	}
	
		
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) 
	{
		String days_info=parent.getItemAtPosition(position).toString();
		String name=parent.getItemAtPosition(position).toString();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
