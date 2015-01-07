package com.example.sqlite;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnCheckedChangeListener
{
	
	ArrayList<List> contactDetails = new ArrayList<List>();
	ListAdapter adapter;

	Button button,getbutton,picbutton, signIn;
	TextView textview1, textview2,textview3,textview4,textview5, un, pw, cpw;
	EditText fntext, lntext, citytext, mailtext, phntext, untext, pwtext, cpwtext;
	
	RadioButton groupvalue, radio0, radio1;
	RadioGroup group;
	Database db;
	ImageView imageview;
	Bitmap bp;
	LinearLayout screen;
	Spinner spinner;
	LoginDataBaseAdapter loginDataBaseAdapter;
	String value;
	
	boolean isImagefitToScreen;
	
	private int radio_selected;
	//int imageId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db = new Database(this);
		
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
		loginDataBaseAdapter=loginDataBaseAdapter.open();
		
		textview1=(TextView)findViewById(R.id.textView1);
		textview2=(TextView)findViewById(R.id.textView2);
		textview3=(TextView)findViewById(R.id.textView3);
		textview4=(TextView)findViewById(R.id.textView4);
		textview5=(TextView)findViewById(R.id.textView5);
		un=(TextView)findViewById(R.id.textViewun);
		pw=(TextView)findViewById(R.id.textViewPw);
		cpw=(TextView)findViewById(R.id.textViewCw);
		
		fntext=(EditText)findViewById(R.id.fnedit);
		lntext=(EditText)findViewById(R.id.lnedit);
		citytext=(EditText)findViewById(R.id.cityedit);
		mailtext=(EditText)findViewById(R.id.mailedit);
		phntext=(EditText)findViewById(R.id.notext);
		
		untext=(EditText)findViewById(R.id.untext);
		pwtext=(EditText)findViewById(R.id.pwtext);
		cpwtext=(EditText)findViewById(R.id.cpwtext);
		
		
		
		button=(Button)findViewById(R.id.button);
		
		picbutton=(Button)findViewById(R.id.picbutton);
		
		imageview=(ImageView)findViewById(R.id.imageView);
		
		radio0=(RadioButton)findViewById(R.id.radio0);
		radio1=(RadioButton)findViewById(R.id.radio1);
	    group=(RadioGroup)findViewById(R.id.radioGroup);
	    
	    
	   /* group.setOnCheckedChangeListener(new OnCheckedChangeListener() 
	    {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				checkedId=group.getCheckedRadioButtonId();
				groupvalue=(RadioButton)findViewById(checkedId);
				value=groupvalue.getText().toString();
			
			 
			}
		});
		*/
		
	    
	    imageview.setOnClickListener(new OnClickListener() 
	    {
	    
			@Override
			public void onClick(View v)
			{
			/*
				imageview.setScaleType(ScaleType.FIT_XY);
				getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
				getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
				*/
				/*if(isImagefitToScreen)
				{
					isImagefitToScreen=false;
					imageview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,  LinearLayout.LayoutParams.WRAP_CONTENT));
					imageview.setAdjustViewBounds(true);
					
				}else
				{
					isImagefitToScreen=true;
					imageview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,  LinearLayout.LayoutParams.MATCH_PARENT));
					imageview.setScaleType(ImageView.ScaleType.FIT_XY);
				}
				*/
				
				Intent i=new Intent(getApplicationContext(), Image_view_full.class);
				
				startActivity(i);
				
			}
		});
		
		
		button.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				
				String fn=fntext.getText().toString();
				String ln=lntext.getText().toString();
				String city=citytext.getText().toString();
				String mail=mailtext.getText().toString();
				String no=phntext.getText().toString();
				
				String Username=untext.getText().toString();
				String Password=pwtext.getText().toString();
				String Confirmpw=cpwtext.getText().toString();
				
				Bitmap bitmap = ((BitmapDrawable) imageview.getDrawable()).getBitmap();
				// convert bitmap to byte
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
				byte imageInByte[] = stream.toByteArray();
				System.out.println("output before conversion"+imageInByte.toString());
				
				
				
				if(Username.equals("")||Password.equals("")||Confirmpw.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Field Vaccant...", Toast.LENGTH_LONG).show();
					return;
				}
				if(!Password.equals(Confirmpw))
				{
					Toast.makeText(getApplicationContext(), "Password does not match...", Toast.LENGTH_LONG).show();
					return;
				}
				
				else
				{
					
					db.InsertData(new List(fn, ln, city, mail, no, imageInByte));
					loginDataBaseAdapter.insertEntry(Username, Password);
					Toast.makeText(getApplicationContext(), "Account Successfully Created...", Toast.LENGTH_LONG).show();
				}
			
				if(R.id.button==v.getId())
				{
					if(group.getCheckedRadioButtonId()==R.id.radio0)
					{
						Intent i=new Intent(MainActivity.this, Schedule_timing.class);
						startActivity(i);
					}
					else if(group.getCheckedRadioButtonId()==R.id.radio1)
					{
						Intent course=new Intent(MainActivity.this, Course_selection.class);
						startActivity(course);
					}
					
				}
				
				/*Intent i=new Intent(MainActivity.this, Course_selection.class);
				startActivity(i);*/
			}
		});
		
		group.setOnCheckedChangeListener(this);
		
		/*getbutton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent intent=new Intent(getApplicationContext(), ListActivity.class);
				//intent.putStringArrayListExtra("list", name);
				startActivity(intent);
			}
		});
	*/
		
	
		
		picbutton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		        startActivityForResult(intent, 0);
		     
			}
		});
	
 }
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
    {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		Bitmap image=(Bitmap)data.getExtras().get("data");
		imageview.setImageBitmap(image);
	
		ByteArrayOutputStream stream=new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte ByteArr[]=stream.toByteArray();
    
		Intent intent=new Intent(this, ListActivity.class);
		intent.putExtra("Bitmap_image", bp);
	  
	}
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) 
	{
	    // TODO Auto-generated method stub
	    switch(checkedId)
	    {

	    case R.id.radio0:
	        radio_selected = R.id.radio0;
	        Toast.makeText(getApplicationContext(),"Yes",Toast.LENGTH_LONG).show();

	    case R.id.radio1:
	        radio_selected = R.id.radio1;
	        Toast.makeText(getApplicationContext(),"No",Toast.LENGTH_LONG).show();
	    }
	}
	
	
	
	
	
	
	 /*public void search(View v)
	    {
	        TextView firstname;
			if(firstname.getText().toString().equals(""))
	        {
	            Toast.makeText(getApplicationContext(), "Please Provide value", Toast.LENGTH_SHORT).show();
	        }
	        else
	        {
	            Bundle bundle=mysql.searchrecord(firstname.getText().toString());
	            getlastname.setText(bundle.get("last_name"));
	            String gender=bundle.get("gender");
	            String contact=bundle.get("contact");
	            String street=bundle.get("street");
	            String city=bundle.get("city");

	        }
	    }*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
