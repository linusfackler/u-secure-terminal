package database;

import java.sql.ResultSet;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import backend.Transaction;
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
			mSQL += "VALUES (" + u.getUserID() + ", '";
			mSQL += u.getName()+ "',";
			mSQL += u.getBalance() + ",'";
			mSQL += u.getFingerPrint() + "');";
			// create MySQL command to insert user into DB
			
			System.out.println(mSQL);

			conn.openDB();				// open DB connection
			ok = conn.changeDB(mSQL);	// send command to DB
		} 
		catch (Exception e) {
			System.out.println(e);
			ok = false;
			// if error, return false
		}
		conn.closeDB();		// close database connection
		return ok;
	}
	
	public boolean updateBalance(User u, double newBalance) {    
		try {		
			mSQL = "UPDATE user SET UserBalance = ";
			mSQL += newBalance + " WHERE UserID = ";
			mSQL += u.getUserID();
			// create MySQL command to update balance of the user in DB

			conn.openDB();				// open DB connection
			ok = conn.changeDB(mSQL);	// send command to DB
		} 
		catch (Exception e) {
			System.out.println(e);
			ok = false;
			// if error, return false
		}
		conn.closeDB();		// close database connection
		return ok;
	}
	
	public boolean updateFingerprint(User u, String f) {
		try {
			mSQL = "UPDATE user SET UserFingerprint = '";
			mSQL += f + "' WHERE UserID = ";
			mSQL += u.getUserID();
			// create MySQL command to update fingerprint of the user in DB

			conn.openDB();				// open DB connection
			ok = conn.changeDB(mSQL);	// send command to DB
		}
		catch (Exception e) {
			System.out.println(e);
			ok = false;
			// if error, return false
		}
		conn.closeDB();		// close database connection
		return ok;
	}
	
	public boolean logTransaction(int uID, String type, double amount, String recipient) {
		try {
			long millis=System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			
			mSQL = "INSERT INTO transactions VALUES (NULL, ";
			mSQL += uID + ", '" + type + "', " + amount + ", '" + recipient + "', '" + date + "')";
			
			conn.openDB();				// open DB connection
			ok = conn.changeDB(mSQL);	// send command to DB
		}
		catch (Exception e) {
			System.out.println(e);
			ok = false;
			// if error, return false
		}
		conn.closeDB();		// close database connection
		return ok;
	}
	
	public int rows(int uID) {
		ResultSet rsM;
		int result = 0;
		mSQL = "SELECT COUNT(*) FROM transactions WHERE UserID = " + uID;
		
		conn.openDB();				// open DB connection
		rsM = conn.readDB(mSQL);	// read DB and return results

		try {
			rsM.next();
			result = rsM.getInt("count(*)");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	public Transaction getTransaction(int uID, int i) {
		ResultSet rsM;
		Transaction t = new Transaction();
		
		mSQL = "SELECT * FROM transactions WHERE UserID = " + uID + " LIMIT " + i + ", 1;";
		conn.openDB();				// open DB connection
		rsM = conn.readDB(mSQL);	// read DB and return results
		
		try {
			rsM.next();
			t.setType(rsM.getString("Type"));
			t.setAmount(rsM.getDouble("Amount"));
			t.setRecipient(rsM.getString("Recipient"));
			t.setDate(rsM.getString("Date"));
			// set transaction data to what was returned from DB
		}
		catch(SQLException err) {
			System.out.println("Problem creating Transaction object");
			//System.out.println("User not found");
			t = null;
			// if error, user not found
		}
		conn.closeDB();			// close DB connection
		return t;				// return found Transaction
	}
	
	public User searchUser(int uID) {
		ResultSet rsM;
		currentUser = new User();
		mSQL = "SELECT * FROM user WHERE UserID = '"+ uID +"';";
		// create MySQL command to insert user into DB
		conn.openDB();				// open DB connection
		rsM = conn.readDB(mSQL);	// read DB and return results

		try {
			rsM.next();
			currentUser.setUserID(rsM.getInt("UserID"));
			currentUser.setName(rsM.getString("UserName"));
			currentUser.setBalance(rsM.getDouble("UserBalance"));
			currentUser.setFingerPrint(rsM.getString("UserFingerprint"));
			// set users data to what was returned from DB
		}
		catch(SQLException err) {
			System.out.println("Problem creating User object");
			//System.out.println("User not found");
			currentUser = null;
			// if error, user not found
		}	
		conn.closeDB();        // close DB connection                               
		return currentUser;		// return found user               
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
			// create MySQL command to insert user into DB
			conn.openDB();			// open DB connection
			conn.changeDB(mSQL);	// send command to DB
			
			ok = true;
		} 
		catch (Exception e) {
			ok = false;
		}
		conn.closeDB();				// close DB connection
		return ok;
	}
	
}
	
	
	
