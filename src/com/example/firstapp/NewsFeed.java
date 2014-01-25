package com.example.firstapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class NewsFeed extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_feed);
		List<Map<String, String>> commentList = new ArrayList<Map<String,String>>();
        commentList.add(createComment("k", "AAA"));
        commentList.add(createComment("k", "BBB"));
        commentList.add(createComment("k", "CCC"));
        commentList.add(createComment("k", "DDD"));
        ListView lv = (ListView) findViewById(R.id.list1);
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, commentList, android.R.layout.simple_list_item_1, 
        new String[] {"k"}, new int[] {android.R.id.text1});
        lv.setAdapter(simpleAdpt);
	}
	
	private HashMap<String, String> createComment(String key, String name) {
		    HashMap<String, String> comment = new HashMap<String, String>();
		    comment.put(key, name);
		    return comment;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news_feed, menu);
		return true;
	}

}
