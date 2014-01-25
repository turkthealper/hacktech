package com.example.firstapp;
import java.io.ByteArrayOutputStream;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Camera extends Activity {
	static final int REQUEST_IMAGE_CAPTURE = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_camera);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera, menu);
		return true;
	}

	public void dispatchTakePictureIntent(View view) {
	    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
	        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
	    }
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
	        Bundle extras = data.getExtras();
	        Bitmap imageBitmap = (Bitmap) extras.get("data");
	        ImageView im = (ImageView) findViewById(R.id.result);
	        im.setImageBitmap(imageBitmap);
	        String encodedImage = getStringFromBitmap(imageBitmap);
	        JSONObject output;
	        output = new JSONObject();
	        try {
				output.put("userid", 1);
				output.put("lat", 1);
				output.put("lng", 1);
				output.put("recepients", new int[]{2});
				output.put("image", encodedImage);
				output.put("comment", "Beautiful");
				AsyncTask t = new MainActivity.Access();
				t.execute("addDrop", output);
			} 
	        catch (JSONException e) { e.printStackTrace(); }
	    }
	}
	
	private String getStringFromBitmap(Bitmap bitmapPicture) {
		 final int COMPRESSION_QUALITY = 100;
		 String encodedImage;
		 ByteArrayOutputStream byteArrayBitmapStream = new ByteArrayOutputStream();
		 bitmapPicture.compress(Bitmap.CompressFormat.PNG, COMPRESSION_QUALITY,
		 byteArrayBitmapStream);
		 byte[] b = byteArrayBitmapStream.toByteArray();
		 encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
		 return encodedImage;
		 }
	
	
	
	

}
