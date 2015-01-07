package com.example.sqlite;

import java.sql.Blob;

import android.graphics.Bitmap;

public class List 
{
    int _id;
    String FirstName, LastName, City, Email, No, un, pw;
    byte[] image;
    
   /* public List(int id, String FirstName, String LastName)
    {
    	this._id=id;
    	this.FirstName=FirstName;
    	this.LastName=LastName;
    }
    
    public List(String FirstName, String LastName)
    {
    	this.FirstName=FirstName;
    	this.LastName=LastName;

    }*/
    
    //String username,String password,
    //this.un=username;
	//this.pw=password;
    public List(){
    	
    }
    public List(String FirstName,String LastName,String City,String Email,String No,byte[] image)
    {
    	this.FirstName = FirstName;
    	this.LastName = LastName;
    	this.City = City;
    	this.Email = Email;
    	this.No = No;
    	/*this.un=username;
    	this.pw=password;*/
    	this.image =image;
    }
    public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setID(int id)
    {
    	this._id=id;
    }
    
    public int getID()
    {
    	return this._id;
    }
    
    public String getFname()
    {
    	return this.FirstName;
    }
    public void setFname(String FirstName)
    {
    	this.FirstName=FirstName;
    }
    
    public String getLname()
    {
    	return this.LastName;
    }
    public void setLname(String LastName)
    {
    	this.LastName=LastName;
    }
    
    public String getCity()
    {
    	return this.City;
    }
    public void setCity(String City)
    {
    	this.City=City;
    }
    
    public String getMail()
    {
    	return this.Email;
    }
    public void setMail(String Mail)
    {
    	this.Email=Mail;
    }
    
    public String getNo()
    {
    	return this.No;
    }
    public void setNo(String No)
    {
    	this.No=No;
    }
    
    /*public String getun()
    {
    	return this.un;
    }
    public void setun(String un)
    {
    	this.un=un;
    }
    
    public String getpw()
    {
    	return this.pw;
    }
    public void setpw(String pw)
    {
    	this.pw=pw;
    }*/
    
   
}
