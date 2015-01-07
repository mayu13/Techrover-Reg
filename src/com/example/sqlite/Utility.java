package com.example.sqlite;



import java.io.ByteArrayOutputStream;
import java.sql.Blob;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;

public class Utility
{
	/*getBytes() Convert bitmap image to byte array and retrun byte[]
	  getPhoto() convert byte[] to bitmap and retrun bitmap image*/
	
	 public static byte[] getBytes(Blob bitmap)
	 {
		 // ByteArrayOutputStream stream = new ByteArrayOutputStream();
		 // bitmap.compress(CompressFormat.PNG, 0, stream);
		//  return stream.toByteArray();
		  Bitmap bitmap1 = BitmapFactory.decodeFile("/path/images/image.jpg");
		  ByteArrayOutputStream baos = new ByteArrayOutputStream();  
		  bitmap1.compress(CompressFormat.PNG,0, baos); 
		  return baos.toByteArray();
		 /* byte[] photo = baos.toByteArray(); 
		  return photo;*/
	 }

		  // convert from byte array to bitmap
		 public static Bitmap getPhoto(byte[] image) 
		 {
		  return BitmapFactory.decodeByteArray(image, 0, image.length);
		 }
}
