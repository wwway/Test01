package com.example.test01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                  WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		Button bt1 = (Button)this.findViewById(R.id.button1);
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v1) {
				Intent intent = new Intent(v1.getContext(),MainActivity_Search.class);
				startActivity(intent);
				
			}
		});
		Button bt4 = (Button)this.findViewById(R.id.button4);
		bt4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	}

	
	

}
