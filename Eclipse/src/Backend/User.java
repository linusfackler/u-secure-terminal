package backend;

public class User {
	private int userID;
	private String userName;
	private double userBalance;
	private String fingerPrint;
	
	public User() {
		
	}
	
	public User(int u, String name, double b, String f) {
		this.userID = u;
		this.userName = name;
		this.userBalance = b;
		this.fingerPrint = f;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int u) {
		this.userID = u;
	}
	
	
	public String getName() {
		return userName;
	}
	
	public void setName(String n) {
		this.userName = n;
	}
	
	
	public double getBalance() {
		return userBalance;
	}
	
	public void setBalance(double b) {
		this.userBalance = b;
	}
	
	
	public String getFingerPrint() {
		return fingerPrint;
	}
	
	public void setFingerPrint(String f) {
		this.fingerPrint = f;
	}
}
