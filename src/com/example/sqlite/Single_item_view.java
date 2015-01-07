package com.example.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Single_item_view extends Activity
{

   TextView fn,ln,city, mail,call;
   String firstname,lastname, cities, email,phno;
   
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_item_view);
		
		Intent i=getIntent();
		
		firstname=i.getStringExtra("firstname");
		lastname=i.getStringExtra("lastname");
		cities=i.getStringExtra("cities");
		email=i.getStringExtra("email");
		phno=i.getStringExtra("phno");
		
		
		fn=(TextView)findViewById(R.id.textView1);
		ln=(TextView)findViewById(R.id.textView2);
		city=(TextView)findViewById(R.id.textView3);
		mail=(TextView)findViewById(R.id.textView4);
		call=(TextView)findViewById(R.id.textView5);
		
		
		fn.setText(firstname);
		ln.setText(lastname);
		city.setText(cities);
		mail.setText(email);
		call.setText(phno);
		
	}
}
