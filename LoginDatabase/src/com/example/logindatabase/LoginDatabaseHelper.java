package com.example.logindatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginDatabaseHelper extends SQLiteOpenHelper  
{
	public static final int db_version=4;
	public static final String db_name="Login";
	
	public static final String table_name="Login_Table";
	public static final String sr_no="S_No";
	public static final String username="UserName";
	public static final String password="Password";
	public static final String name="Name";
	public static final String address= "Address";
	public static final String m_no="Mobile_No";
	
   
    
    public LoginDatabaseHelper(Context context, String dbName, CursorFactory factory, int version)
    {
    	super(context, db_name,null, db_version);
    }
    
    
    public static final String create_table =  "Create Table "+ table_name + "(" + sr_no + " INTEGER AUTO_INCREMENT,"  + username + " TEXT PRIMARY KEY,"
            +password  + " TEXT," + name + " TEXT," + address +" TEXT," + m_no + " TEXT" + ");";

    public static final String alter_table_row= "DELETE FROM"+ table_name +"WHERE sr_no=" + sr_no;
   
    public void onCreate(SQLiteDatabase db)
    {
    	db.execSQL(create_table);
    }
    
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
    {
    /*	db.execSQL(alter_table_row);   */
        db.execSQL("DROP TABLE IF EXISTS "+ table_name);
    	onCreate(db);   	
    }		
	
    
	
	

}
