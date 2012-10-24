package com.example.logindatabase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class LoginDatabaseOpreation 
{
	private SQLiteDatabase ldb;	
	private Context lcontext;	
	private	LoginDatabaseHelper ldh;

	public LoginDatabaseOpreation(Context context)
	{
	   	this.lcontext= context;
	}
	    
	 public void createWriteModeDatabase() throws SQLException
	 {
		ldh = new LoginDatabaseHelper(lcontext,LoginDatabaseHelper.db_name, null, 1);
		
		ldb = ldh.getWritableDatabase();
	 }

	 public void close() throws SQLException
	 {
		 ldh.close();
	 }
		

		public void insertRow(String username, String password, String name,String address, String m_no) throws SQLException
		{
			ContentValues values = new ContentValues();
		
			values.put(LoginDatabaseHelper.name, name);
			values.put(LoginDatabaseHelper.m_no, m_no);
			values.put(LoginDatabaseHelper.username, username);
			values.put(LoginDatabaseHelper.password, password);
			values.put(LoginDatabaseHelper.address, address);			
			
			ldb.insert(LoginDatabaseHelper.table_name, null, values);
		}   
			
		public void updateRow(String name,String address, int m_no) throws SQLException
		{
			ContentValues values = new ContentValues();
			values.put(LoginDatabaseHelper.name, name);
			values.put(LoginDatabaseHelper.m_no, m_no);
			values.put(LoginDatabaseHelper.address, address);			
			ldb.insert(LoginDatabaseHelper.table_name, null, values);
		}   
	  
	    public  Cursor fetchLine(String username, String password) throws SQLException
	    {
	    	String q= "SELECT "+ LoginDatabaseHelper.username + "," + LoginDatabaseHelper.password + " FROM " + LoginDatabaseHelper.table_name 
	                   + "  WHERE " + LoginDatabaseHelper.username + " = '" + username  +"'"+  " AND "+ LoginDatabaseHelper.password + "= '" + password +"'";
			
	    	return ldb.rawQuery(q, null);
                  	
	    }
	   	
			
	}

	


