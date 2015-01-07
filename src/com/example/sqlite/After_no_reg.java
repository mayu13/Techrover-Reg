package com.example.sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class After_no_reg  extends Activity
{
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.after_no_reg);
		TextView text=(TextView)findViewById(R.id.textViewNoreg);
	}
}
