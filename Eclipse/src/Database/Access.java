package database;

import java.sql.ResultSet;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

import backend.User;

public class Access
{
	private User currentUser; 
	String mSQL;                    
	boolean ok = true;                 
  
	public Access()
	{		
	}
	
	Connector conn = new Connector();    
	
	public boolean createUser(User u) {    
		try {
			mSQL = "INSERT INTO user(UserID, UserName, UserBalance, UserFingerprint) ";
			mSQL += "VALUES (" + u.getUserID() + ",'";
			mSQL += u.getName()+ "','";
			mSQL += u.getBalance() + "',";
			mSQL += u.getFingerPrint() + "',";
			// create MySQL command to insert user into DB

			conn.openDB();                             
			ok = conn.changeDB(mSQL);
			// send command to DB
		} 
		catch (Exception e) {
			System.out.println(e);
			ok = false;		
		}
		conn.closeDB(); 
		return ok;
	}
	
	public User searchUser(String uID) {   
		ResultSet rsM;                                                  
		currentUser = new User();
		mSQL = "SELECT * FROM user WHERE userID = '"+ uID +"';";                    
		conn.openDB();
		rsM = conn.readDB(mSQL);
			
		try {
			rsM.next();
			currentUser.setUserID(rsM.getInt("UserID"));
			currentUser.setName(rsM.getString("UserName"));
			currentUser.setBalance(rsM.getDouble("UserBalance"));
			currentUser.setFingerPrint(rsM.getNString("UserFingerprint"));
		}
		catch(SQLException err) {
			currentUser = null;
		}	
		conn.closeDB();                                       
		return currentUser;                                           
	}
	
	public ArrayList<User>userlist_db() {
		ArrayList<User> userlist = new ArrayList<User>();
		ResultSet rsM;
		conn.openDB();
		String sqlCommand = "SELECT * FROM user";
		
		rsM=conn.readDB(sqlCommand);
		
		try {
			while (rsM.next()) {
				User currentUser = new User();
				currentUser.setUserID(rsM.getInt("UserID"));
				currentUser.setName(rsM.getString("UserName"));
				currentUser.setBalance(rsM.getDouble("UserBalance"));
				currentUser.setFingerPrint(rsM.getNString("UserFingerprint"));
				userlist.add(currentUser);				
			}
		} 
		catch (Exception e) {
			System.out.println("No entries found");
		}		
		return userlist;
	}
	
	
	public boolean deleteUserDB() {
		try {
			mSQL="DELETE FROM user WHERE UserID = '" + currentUser.getUserID() + "';";
			conn.openDB();
			conn.changeDB(mSQL);
			
			ok = true;
		} 
		catch (Exception e) {
			ok = false;
		}
		conn.closeDB();
		return ok;
	}
	
}
	
	
	
