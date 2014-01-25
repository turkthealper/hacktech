package com.example.firstapp;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.CursorJoiner.Result;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	 
	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
	
	public void goLogin(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, Login.class);

		startActivity(intent);
	}
	
	public void gps(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, Gps.class);

		startActivity(intent);
	}
	
	public void newsfeed(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, NewsFeed.class);
		startActivity(intent);
	}
	
	public static class Access extends AsyncTask {
		@Override
		protected Object doInBackground(Object... urls) {
			String site = "http://warm-ridge-1785.herokuapp.com/";
			HttpClient httpclient = new DefaultHttpClient();  
			HttpGet request = new HttpGet( site + (String) urls[0]);
			ResponseHandler<String> handler = new BasicResponseHandler();
			String result = "";
			try {
				result = httpclient.execute(request, handler);
			Log.d("yay", result);
			ArrayList<String> vals = (ArrayList<String>) urls[1];
			vals.add("AAA");
			vals.add("BBB");
			vals.add("CCC");
			vals.add("DDD");}
			 catch (Exception e) {
					Log.d("error5", e.toString());
					return null;
				} 
			httpclient.getConnectionManager().shutdown();
			return null;
		}
		
	}
	public void sendserver(View view){
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		new Access().execute(message);
				//JSONObject obj = new JSONObject();
				//try {
				//	obj.put("info", message);
		//} catch (JSONException e1) {
		//	Log.d("1" , "error1");
		//	return;
		//}
        //StringEntity s;
		//try {
			//s = new StringEntity(obj.toString());
			//s.setContentEncoding("UTF-8");
	        //s.setContentType("application/json");
		//} catch (UnsupportedEncodingException e1) {
		//	Log.d("2" , "error2");
		//	return;
		//}
        //request.setEntity(s);
        //JSONObject jsonObj;

            
            //jsonObj = new JSONObject(result);
	}
}