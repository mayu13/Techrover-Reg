package com.example.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Feed_back extends Activity implements OnCheckedChangeListener
{

	TextView textexp, textknw, textoff, emailview;
	Button submit;
	RatingBar exprating, offrating, knwrating, setexp, setoff, setknw;
	RadioGroup radiogrp1, radiogrp2;
	RadioButton grp1, grp2;
	int count;
    float curRate;
    private int radio_selected;
    String value1, value2;
    EditText feedbackdata;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feed_back);
	
		exprating=(RatingBar)findViewById(R.id.ratingBar1);
		setexp=(RatingBar)findViewById(R.id.ratingexp);
		
		offrating=(RatingBar)findViewById(R.id.ratingBar2);
		setoff=(RatingBar)findViewById(R.id.ratingoff);
		
		knwrating=(RatingBar)findViewById(R.id.ratingBar3);
		setknw=(RatingBar)findViewById(R.id.ratingknw);
		
		textexp=(TextView)findViewById(R.id.textViewexp);
		textknw=(TextView)findViewById(R.id.textViewknw);
		textoff=(TextView)findViewById(R.id.textViewoff);
		
		emailview=(TextView)findViewById(R.id.textViewEmail);
		
		feedbackdata=(EditText)findViewById(R.id.EditTextFeedbackBody);
		
		
		addListenerOnRatingBar();
		
		submit=(Button)findViewById(R.id.button1);
		
		radiogrp1=(RadioGroup)findViewById(R.id.radioGroup1);
		radiogrp2=(RadioGroup)findViewById(R.id.radioGroup2);
		
		/*radiogrp1.setOnCheckedChangeListener(this);
		radiogrp2.setOnCheckedChangeListener(this);
		*/
		radiogrp1.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				checkedId=radiogrp1.getCheckedRadioButtonId();
				grp1=(RadioButton)findViewById(checkedId);
				value1=grp1.getText().toString();
			
			}
		});
		
		radiogrp2.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				checkedId=radiogrp2.getCheckedRadioButtonId();
				grp2=(RadioButton)findViewById(checkedId);
				value2=grp2.getText().toString();
			
			}
		});
			
		/*String radiovalue1=((RadioButton)this.findViewById(radiogrp1.getCheckedRadioButtonId())).getText().toString();
		String radiovalue2=((RadioButton)this.findViewById(radiogrp2.getCheckedRadioButtonId())).getText().toString();
	*/
	    submit.setOnClickListener(new OnClickListener()
	    {
			
			@Override
			public void onClick(View v) 
			{
				String exp=textexp.getText().toString();
				String off=textoff.getText().toString();
				String knw=textknw.getText().toString();
				String r1=value1;
				String r2=value2;
				String emailv=emailview.getText().toString();
				String other_data=feedbackdata.getText().toString();
				
				String message= "Hello "
						+'\n'
						+ exp
						+ '\n' 
						+ "My Learning Experience"
						+ '\n'
						+ off
						+ '\n' 
						+ "Office Infrastructure"
						+ '\n'
						+ knw
						+ '\n' 
						+ "Trainer Knowledge"
						+ '\n'
						+ r1
						+ '\n' 
						+ "Interested in next class ?"
						+'\n'
						+ r2
						+ '\n' 
						+ "Will refer My Friends"
						+ '\n'
						+ other_data
						+ '\n'
						+ "Other Feedback..."
						+ '\n' + "Thank you so much...";
				
				String email[]={ emailv };
				Intent emailIntent=new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, email);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Feedback..");
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
				startActivity(emailIntent);
				
				//Toast.makeText(getApplicationContext(), "Thanks.....", Toast.LENGTH_LONG).show();
				
			}
			
		});
	    Intent i=new Intent(Feed_back.this, Thank_you.class);
		startActivity(i);
       
	}
	
	public void addListenerOnRatingBar()
	{
		exprating.setOnRatingBarChangeListener(new OnRatingBarChangeListener() 
		{
			public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) 
			{
	 
				textexp.setText(String.valueOf(rating));
	 
			}
		});
		
		offrating.setOnRatingBarChangeListener(new OnRatingBarChangeListener() 
		{
			public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) 
			{
	 
				textoff.setText(String.valueOf(rating));
	 
			}
		});
		
		knwrating.setOnRatingBarChangeListener(new OnRatingBarChangeListener() 
		{
			public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) 
			{
	 
				textknw.setText(String.valueOf(rating));
	 
			}
		});
	}
	

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId)
	{
		 switch(checkedId)
		    {

		    case R.id.radio0:
		        radio_selected = R.id.radio0;
		        Toast.makeText(getApplicationContext(),"Yes",Toast.LENGTH_LONG).show();

		    case R.id.radio1:
		        radio_selected = R.id.radio1;
		        Toast.makeText(getApplicationContext(),"No",Toast.LENGTH_LONG).show();
		        
		    case R.id.radio3:
		        radio_selected = R.id.radio3;
		        Toast.makeText(getApplicationContext(),"Yes",Toast.LENGTH_LONG).show();

		    case R.id.radio4:
		        radio_selected = R.id.radio4;
		        Toast.makeText(getApplicationContext(),"No",Toast.LENGTH_LONG).show();    
		        
		    }
		
	}
}
