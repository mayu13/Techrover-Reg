package com.example.sqlite;

import java.util.ArrayList;
import java.util.Locale;

import com.example.sqlite.R.menu;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

public class ListActivity extends Activity
{
   ListView listview;
   Database db;
   ArrayList<String> fn,ln,city,mail,no,image;
   Button callbutton;
   ListAdapter listAdapter;
   EditText searchdata;
   ArrayList<com.example.sqlite.List> aList=new ArrayList<com.example.sqlite.List>();
   
   
  // ArrayList<List> array=new ArrayList<List>();
   
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		listview=(ListView)findViewById(R.id.listView);
		db=new Database(this);
		
			
		 fn=new ArrayList<String>();
		 ln=new ArrayList<String>();
		 city=new ArrayList<String>();
		 mail=new ArrayList<String>();
		 no=new ArrayList<String>();
		 image=new ArrayList<String>();
		
		   searchdata=(EditText)findViewById(R.id.searchtext);
		 
		 
		 ArrayList<com.example.sqlite.List> aList=new ArrayList<com.example.sqlite.List>();
		// Toast.makeText(getApplicationContext(), "fn:"+fn.get(0), Toast.LENGTH_LONG).show();
		aList = db.GetData();
		
		System.out.println("size of array:"+aList.size());
		for(int i=0;i<aList.size();i++)
		{
			fn.add(aList.get(i).getFname().toString());
			//Toast.makeText(getApplicationContext(), "fn:"+fn.get(i), Toast.LENGTH_LONG).show();
			ln.add(aList.get(i).getLname().toString());
			city.add(aList.get(i).getCity().toString());
			mail.add(aList.get(i).getMail().toString());
			no.add(aList.get(i).getNo().toString());
			image.add(aList.get(i).getImage().toString());
			
			
			//Toast.makeText(getApplicationContext(), "fn:"+array.get(i).getFname().toString(), Toast.LENGTH_LONG).show();
			
		}
		
		listAdapter=new ListAdapter(this,R.layout.activity_list,new ArrayList<com.example.sqlite.List>(aList));
		listview.setAdapter(listAdapter);
		listview.setTextFilterEnabled(true);
		
		listview.setOnItemClickListener(new OnItemClickListener() 
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3)
			{
				// TODO Auto-generated method stub
				System.out.println(arg2+" --postion");
			}
			
			
		});
		
		
		searchdata.addTextChangedListener(new TextWatcher()
		{
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) 
			{
				String text=searchdata.getText().toString().toLowerCase(Locale.getDefault());
				listAdapter.filter(text);
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_data, menu);
        return true;
        
        
      /*  SearchManager searchManager=(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView=(SearchView)menu.findItem(R.id.action_search).getActionView();
        
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        
        SearchView.OnQueryTextListener textChangeListener=new SearchView.OnQueryTextListener()
        {
        	 SearchView searchView;
        	
			@Override
			public boolean onQueryTextChange(String newText) 
			{
				// TODO Auto-generated method stub
				
				
				
				listAdapter.getFilter().filter(newText);
				System.out.println("on text change text:" +newText);
				return true;
			}
			
			@Override
			public boolean onQueryTextSubmit(String query) 
			{
				// TODO Auto-generated method stub
				
				listAdapter.getFilter().filter(query);
				System.out.println("on query submitg" +query);
				return false;
			}
			
		};
		searchView.setOnQueryTextListener(textChangeListener);
		return super.onCreateOptionsMenu(menu);
	}*/

}
}
