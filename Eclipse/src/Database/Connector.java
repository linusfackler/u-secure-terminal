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
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println(Class.forName("com.mysql.jdbc.Driver"));
			System.out.println(Class.forName("com.mysql.jdbc.Driver").newInstance());
		} 
		catch (Exception e)
		{
			System.err.println("Unable to load driver.");
			e.printStackTrace();
		}

		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_fahrzeug","root","");  
			stmtSQL = conn.createStatement();  
			System.out.println("Connected successfully");
		}
		catch (SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

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
