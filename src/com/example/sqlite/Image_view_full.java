package com.example.sqlite;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class Image_view_full extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_view_full);
		
		
	/*	ImageView fullImage=(ImageView)findViewById(R.id.imageViewfull);
		BitmapFactory.Options option=new BitmapFactory.Options();
		option.inTempStorage=new byte[3*1024];
		Bitmap ops= BitmapFactory.decodeFile(path, option);
		fullImage.setImageBitmap(ops);
		*/
		
		
	}
}
