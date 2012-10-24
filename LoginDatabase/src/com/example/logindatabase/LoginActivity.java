package com.example.logindatabase;





import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity 
{
	public LoginDatabaseOpreation ldo;
    private EditText edit1;
    private EditText edit2;
    private Button btn1;
    private Button btn2;
	private Cursor result; 
   
	
	
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        edit1= (EditText)findViewById(R.id.ET1);
        edit2= (EditText)findViewById(R.id.ET2);
        btn1=(Button)findViewById(R.id.Btn1);
        btn2= (Button)findViewById(R.id.Btn2);  
       
        
        btn2.setOnClickListener(new OnClickListener() 
        {
      
        	@Override
  			public void onClick(View v)
        	{
        		
        		ldo= new LoginDatabaseOpreation(LoginActivity.this);
        	    ldo.createWriteModeDatabase();
                Intent intent = new Intent().setClass(getApplicationContext(), Account.class);
        	    startActivity(intent);
        	    ldo.close();
        	    	
        	}
        	
        });
    
       btn1.setOnClickListener( new OnClickListener()
              {
    		     	      
    	   @Override
			public void onClick (View v) 
    		{
    		  
    		  String username = edit1.getEditableText().toString();
    		  String password= edit2.getEditableText().toString();
    		   ldo= new LoginDatabaseOpreation(LoginActivity.this);
      	       ldo.createWriteModeDatabase();
    		  
    		  Cursor result =ldo.fetchLine(username, password);
    		  
    	//	   String username1 = result.getString(result.getColumnIndex("UserName"));
    	//	  String password1 = result.getString(result.getColumnIndex("Password"));
    		  
    		  if( result.getCount()>0)
    		 {
    		      Intent intent= new Intent().setClass(getApplicationContext(), Success.class);
    		      intent.putExtra("username1", username);
    		      intent.putExtra("password1",password);
    			  startActivity(intent);
    		 }
    		  else
    		  {
    			  Toast.makeText(LoginActivity.this,"Invalid Entries" , Toast.LENGTH_SHORT).show(); 	 
    		  }
    		  
    		
    		  result.close();
    		 ldo.close();
    		
    		//  cr.getString(cr.getColumnIndex("email"))
 		
         		}
	      	      	 
    	   }
    		   
    		);
              
         
          edit1.getKeyListener();
             
        edit1.setOnKeyListener(new OnKeyListener() {
		public boolean onKey(View v, int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_ENTER:
		case KeyEvent.KEYCODE_TAB:
		edit2.requestFocus();
		return true;
		default:
		return false;
		}
		}
		});
    	    
           
        	
    }
	
}
	
	
    



     
    


		


