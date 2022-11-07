package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Connector
{
	Connection conn = null;    
	Statement stmtSQL = null;  

	public void openDB() {
		try
		{
			System.out.println("* Load Driver");
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println(Class.forName("com.mysql.cj.jdbc.Driver"));
			System.out.println(Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
			// load Java MySQL Driver
		} 
		catch (Exception e)
		{
			System.err.println("Unable to load driver.");
			e.printStackTrace();
			// if driver couldn't load
		}

		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/terminal","root","");  
			stmtSQL = conn.createStatement();  
			System.out.println("Connected successfully");
			// create DB connection using the Driver we previously loaded
			// currently only running on localhost, soon AWS
		}
		catch (SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	// this method simply changes DB entry and does not rely on return values and returns a boolean
	public boolean changeDB(String pSQL)
	{ 
		try {
			stmtSQL.executeUpdate(pSQL); 
            return true;
		}
		catch(SQLException err) {
			JOptionPane.showMessageDialog(null, "Error when connecting "+err.toString());
			System.err.println(err);
			return false;
		}		
	}

	// this method sends a command to DB and saves the return in a ResultSet
	public ResultSet readDB(String pSQL) 
	{
		ResultSet rs;                  
		try
		{
			rs = stmtSQL.executeQuery(pSQL);
			System.out.println("Read DB");
			return rs;                 
		}
		catch(SQLException err)
		{
			JOptionPane.showMessageDialog(null, "Error when connecting"+err.toString());
			rs = null;
			return rs;
		}
	}
	
	// this method closes the DB connection
	public void closeDB(){            
		try
		{
			conn.close();
		}
		catch (SQLException err)
		{
			JOptionPane.showMessageDialog(null, "Error when closing "+err.toString());			
		}
	}

}
