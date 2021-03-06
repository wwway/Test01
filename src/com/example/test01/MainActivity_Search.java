package com.example.test01;

import java.util.Locale;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity_Search extends Activity{
	//static final LatLng latLng = new LatLng(25.110480, 121.526229);
    private GoogleMap map;
    TextToSpeech tts;
    
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                  WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
		setContentView(R.layout.activity_search);
		
		
		tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
				
				if(status != TextToSpeech.ERROR){
					tts.setLanguage(Locale.ENGLISH);
				}
			}
		});
		
		ImageButton bt1 = (ImageButton)this.findViewById(R.id.imagebutton1);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v1) {
				finish();
				
			}
		});
		
		bt1.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				tts.speak("Back", TextToSpeech.QUEUE_FLUSH, null);
				return true;
			}
		});
		
		ImageButton bt2 = (ImageButton)this.findViewById(R.id.imagebutton2);
		bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		bt2.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				tts.speak("Search", TextToSpeech.QUEUE_FLUSH, null);
				return true;
			}
		});
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        //Marker marker = map.addMarker(new MarkerOptions().position(latLng).title("家").snippet("中山北路6段290巷7弄5-1號5樓"));
        Marker marker_2 = map.addMarker(new MarkerOptions().position(new LatLng(22.996650,120.216862)).title("搜尋地點").snippet("台南市東區大學路1號"));
        //Circle circle = map.addCircle(new CircleOptions().center(new LatLng(25.110700, 121.526229)).radius(100).strokeColor(Color.RED).fillColor(Color.CYAN));
        // Move the camera instantly to latLng with a zoom of 16.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(22.996650,120.216862), 17));
    
	}
}
