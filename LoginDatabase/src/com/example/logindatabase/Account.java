package com.example.logindatabase;

import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Account extends Activity 
{
    
	
 public String username,password,name,address,m_n0;	
	
 public LoginDatabaseOpreation ldo;	
  
  private EditText edit6;
  private EditText edit7;	
  private EditText edit3;
  private EditText edit4;
  private EditText edit5;
  
  private Button btn3;
  
  public final Pattern USERNAME_ADDRESS_PATTERN = Pattern.compile(
	   		 "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@+[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		
  public final Pattern PASSWORD_ADDRESS_PATTERN = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
           
  
 
  public void onCreate(Bundle savedInstanceState)
  {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.account);
	  
	  edit3= (EditText)findViewById(R.id.ET3);
	  edit4= (EditText)findViewById(R.id.ET4);
	  edit5= (EditText)findViewById(R.id.ET5);
	  edit6= (EditText)findViewById(R.id.ET6);
	  edit7= (EditText)findViewById(R.id.ET7);
     
	  btn3=(Button)findViewById(R.id.Btn3);
	  
	  
	  btn3.setOnClickListener(new OnClickListener() 
      {
    
      	@Override
			public void onClick(View v) {
				
				String username= edit3.getEditableText().toString();
	          	String password= edit4.getEditableText().toString();
	            String name =    edit5.getEditableText().toString();
	            String address=  edit6.getEditableText().toString();
	            String m_no=     edit7.getEditableText().toString();
	          		                             
	            if(username.equals("")||password.equals("")||name.equals("")||address.equals("")||m_no.equals(""))
	        	{
	        		 Toast.makeText(Account.this,"Field are blank", Toast.LENGTH_SHORT).show();
	        	}
	        	else
	        	{
	        	
	        	 
	        	if(checkUsername(username))
	        	{	
	        	  Toast.makeText(Account.this,"valid Username", Toast.LENGTH_SHORT).show();
	        	 
	        	 if(checkPassword(password))
	        	 {
	        		 Toast.makeText(Account.this,"valid Password", Toast.LENGTH_SHORT).show();  	  
	        	  	        	  	        	  
	        	  if(m_no.length()<10||m_no.length()> 11)
		            {
		            	Toast.makeText(Account.this,"Mobile No Is Invalid",Toast.LENGTH_SHORT).show();
	                    Intent intent= new Intent().setClass(getApplicationContext(),LoginActivity.class );  	            
		            }
	        	  else
	        	  {
	        	  Intent intent = new Intent().setClass(getApplicationContext(), Join.class);
	              startActivity(intent);
	        	  ldo= new LoginDatabaseOpreation(Account.this);
      	          ldo.createWriteModeDatabase();
	          	  ldo.insertRow(username,password,name,address,m_no);
	        	  ldo.close();
	        	  }
	        	 }
	        	  else
	        	  {
	        		  Toast.makeText(Account.this,"Invalid password", Toast.LENGTH_SHORT).show();  
	        	  
	        	  }
	        	      	 
	        	 } 
	        	 
	        	
	        	else
	        	{
	        		
	        	Toast.makeText(Account.this,"inValid Username Or Password", Toast.LENGTH_SHORT).show();
	        	}
	        	
	        	}
	        	}
      	
			
        });

    }
	  
  private  boolean checkUsername(String username)
  {
	    return USERNAME_ADDRESS_PATTERN.matcher(username).matches();
	    }
	
  private boolean checkPassword( String password)
  {
	return PASSWORD_ADDRESS_PATTERN.matcher(password).matches();  
	
  }				  
	  
	  
	  
	  
  
}
