package com.example.administrator.njcx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class Home_activity extends Activity{
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.home);
	        Handler handler = new Handler(); 

	        Runnable updateThread = new Runnable(){  
	                	public void run(){  
	                		Intent intent = new Intent(); 
	                        intent.setClass(Home_activity.this,MainActivity.class);
	                        
	                        Home_activity.this.startActivity(intent);
	                        finish();

	                        }    
	            
	                	};
	        handler.postDelayed(updateThread, 800);
	        
	     
	    }

}
