import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Main {
	public static void main(String args[]) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/terminal", "root", "");
			if (!con.isClosed())
				System.out.println("Successfully connected to MySQL server...");
		}
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		finally {
			try {
				if (con != null)
					con.close();
			}
			catch (SQLException e) {}
		}
	}
}
