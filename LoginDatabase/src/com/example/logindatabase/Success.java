package com.example.logindatabase;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Success extends Activity
{TextView show1;
TextView show2;
  @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        show1=(TextView)findViewById(R.id.TV14);
        show2=(TextView)findViewById(R.id.TV16);
        
       
      String Username =  getIntent().getExtras().getString("username1");
      String Password =  getIntent().getExtras().getString("password1");
      show1.setText(Username);
      show2.setText(Password);
	   
   }
}
