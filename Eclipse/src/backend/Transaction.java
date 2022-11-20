package backend;

public class Transaction {
	private String type;
	private double amount;
	private String recipient;
	private String date;
	
	public Transaction() {
		
	}
	
	public Transaction(String t, double a, String r, String d) {
		type = t;
		amount = a;
		recipient = r;
		date = d;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double a) {
		amount = a;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public void setRecipient(String r) {
		recipient = r;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String d) {
		date = d;
	}
}
