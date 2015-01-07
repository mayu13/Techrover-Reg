package com.example.sqlite;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListAdapter extends ArrayAdapter<com.example.sqlite.List>
{

	Activity activity;
	Context context;
	int layoutResourceId;
	/*ArrayList<String> Firstname;
	ArrayList<String> Lastname;
	ArrayList<String> City;
	ArrayList<String> Email;
	ArrayList<String> No;*/
	java.util.List<List> data=null;
	
	ArrayList<com.example.sqlite.List> details = new ArrayList<com.example.sqlite.List>();
	TextView ftext;
	
	public ListAdapter(Context context, int layoutResourceId, ArrayList<com.example.sqlite.List> details)
	{
		 super(context, layoutResourceId, details);
		this.context=context;
		this.layoutResourceId = layoutResourceId;
		/*this.Firstname=fn;
		this.Lastname=ln;
		this.City=city;
		this.Email=mail;
		this.No=no;*/
		this.details = details;
		
		this.data=new ArrayList<List>();
		this.data.addAll(details);
		
	
	}
	/*@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return Firstname.size();
	}

	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		System.out.println("getItem position" +position);
		return position;
	}

	@Override
	public long getItemId(int position)
	{
		// TODO Auto-generated method stub
		System.out.println("getItemId position" +position);
		return position;
	}
*/
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) 
	{
		Data data=new Data();
		
		if(convertView==null)
		{
			LayoutInflater inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView=inflater.inflate(R.layout.adpter, null);
			data.image=(ImageView)convertView.findViewById(R.id.imageView);
			data.fText=(TextView)convertView.findViewById(R.id.textView1);
			data.lText=(TextView)convertView.findViewById(R.id.textView2);
			data.cityText=(TextView)convertView.findViewById(R.id.textView3);
			data.mailText=(TextView)convertView.findViewById(R.id.textView4);
			data.notext=(TextView)convertView.findViewById(R.id.textView5);
            data.callbutton=(ImageButton)convertView.findViewById(R.id.callButton);
            data.mailbutton=(ImageButton)convertView.findViewById(R.id.mailButton);
			
			convertView.setTag(data);
		}
		else
		{
			data=(Data)convertView.getTag();
		}
		
		final List pic = details.get(position);
		data.fText.setText(pic.FirstName);
		data.lText.setText(pic.LastName);
		data.cityText.setText(pic.City);
		data.mailText.setText(pic.Email);
		data.notext.setText(pic.No);
		
		byte[] outImage = pic.image;
		ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
		Bitmap theImage = BitmapFactory.decodeStream(imageStream);
		data.image.setImageBitmap(theImage);
		
		
		
		
	convertView.setOnClickListener(new OnClickListener()
	{
		
		@Override
		public void onClick(View arg0) 
		{
			Intent intent=new Intent(context, Single_item_view.class);
			
			intent.putExtra("firstname", (details.get(position).getFname()));
			intent.putExtra("lastname", (details.get(position).getLname()));
			intent.putExtra("cities", (details.get(position).getCity()));
			intent.putExtra("email", (details.get(position).getMail()));
			intent.putExtra("phn", (details.get(position).getNo()));
			context.startActivity(intent);
		}
	});
		

		
		data.callbutton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) 
			{
				try
				{
					String uri= "tel:" +pic.No;
					Intent callintent= new Intent(Intent.ACTION_CALL, Uri.parse(uri));
					
					context.startActivity(callintent);
				}
				catch(Exception e)
				{
					Toast.makeText(context.getApplicationContext(), "Your call has failed....", Toast.LENGTH_LONG).show();
				    e.printStackTrace();
				}
				
			}
		});
		
		
		data.mailbutton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) 
			{
				try
				{
					
				 // String TO = "mail:" +pic.Email;
				  //Intent emailIntent = new Intent(Intent.ACTION_SEND);
	     Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", pic.Email, null));
			     // emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
	     emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject");
			      
			     
			      context.startActivity(Intent.createChooser(emailIntent, "Send email..."));
				}
				catch (Exception e)
				{
					Toast.makeText(context.getApplicationContext(), "Your sending failed....", Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
				
			}
				
		});
	
		
		
		/*data.fText.setText(Firstname.get(position));
		data.lText.setText(Lastname.get(position));
		data.cityText.setText(City.get(position));
		data.mailText.setText(Email.get(position));
		data.notext.setText(No.get(position));*/
		
		return convertView;
	
		
	}

		public static class Data
		{
			ImageView image;
			TextView fText;
			TextView lText;
			TextView cityText;
			TextView mailText;
			TextView notext;
			ImageButton callbutton;
			ImageButton mailbutton;
			
		}
		
		public void filter(String charText)
		{
			charText=charText.toLowerCase(Locale.getDefault());
			details.clear();
			if(charText.length()==0)
			{
				details.addAll(data);
			}
			else
			{
				for(List lt : data)
				{
					if(lt.getFname().toLowerCase(Locale.getDefault()).contains(charText))
					{
						details.add(lt);
					}
				}
			}
			notifyDataSetChanged();
		}
		
		
		
}
