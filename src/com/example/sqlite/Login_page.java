package com.example.sqlite;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Login_page extends Activity implements OnItemSelectedListener 
{

	Button signup, signIn, viewdata;
	Database db;
	ArrayList<String> un,pw;
	LoginDataBaseAdapter loginDataBaseAdapter;
	Spinner spinner;
	EditText username, password;
	
	
	//private String[] Info = { "Student", "Employee"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.login_page);
		db = new Database(this);
		
		 loginDataBaseAdapter=new LoginDataBaseAdapter(this);
	     loginDataBaseAdapter=loginDataBaseAdapter.open();
		
	    
	    signup=(Button)findViewById(R.id.signupbutton);
	    signIn=(Button)findViewById(R.id.signinbutton);
	    viewdata=(Button)findViewById(R.id.viewbutton);
	    
	  //  spinner=(Spinner)findViewById(R.id.spinner1);
	
	     un=new ArrayList<String>();
		 pw=new ArrayList<String>();
		 
		 
		/* ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Info);
		 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 spinner.setAdapter(adapter);
		 spinner.setOnItemSelectedListener(this);	*/
	    
	    
	    signup.setOnClickListener(new OnClickListener()
	    {
			
			@Override
			public void onClick(View v) 
			{
				Intent reg=new Intent(Login_page.this, MainActivity.class);
				startActivity(reg);
				
			}
		});
	    
	    viewdata.setOnClickListener(new OnClickListener()
	    {
			
			@Override
			public void onClick(View v) 
			{
				Intent intent=new Intent(Login_page.this, ListActivity.class);
				
				startActivity(intent);
				
			}
		});
	  
	}
	    
	    public void signIn(View V) 
	    {
			final Dialog dialog=new Dialog(Login_page.this);
			dialog.setContentView(R.layout.sign_in);
			dialog.setTitle("Login");
			
			username=(EditText)dialog.findViewById(R.id.userSignin);
			password=(EditText)dialog.findViewById(R.id.pwSignin);
			signIn=(Button)dialog.findViewById(R.id.buttonsignin);
		
			signIn.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v) 
				{
					String un=username.getText().toString();
					String pw=password.getText().toString();
			
				    String storedPassword=loginDataBaseAdapter.getSinlgeEntry(un);

					
				   if(pw.equals(storedPassword))
					{
						  Toast.makeText(Login_page.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
						  dialog.dismiss();
						
						  Intent i=new Intent(Login_page.this, Schedule_timing.class);
						  startActivity(i);
						
					}
				   
					else
					{
						Toast.makeText(Login_page.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
					
				    }
				   
				 
				}
			});
			
			dialog.show();
	
	  }

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) 
		{
			spinner.setSelection(position);
			
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}

	
	   
 }