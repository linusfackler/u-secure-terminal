// This is the Deposit UI screen, in which the user can
// deposit money to his account, by inputting a double variable
// It will automatically update his DB entry.
// If there are errors, the user will see a pop-up message.



package frontend;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.User;
import database.Access;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DepositGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtAmount;
	
	private Access ax = new Access();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositGUI frame = new DepositGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DepositGUI() {

        JTextField t2 = new JTextField();
        t2.setBorder(new LineBorder(new Color(0, 0, 0)));
        t2.setForeground(new Color(255, 255, 255));
        t2.setBackground(new Color(0, 85, 43));
        
        t2.setText("     Deposit Funds");
        t2.setFont(new Font("Dubai Medium", Font.BOLD, 22));  
        t2.setEditable(false);
        
        /////
        
        JLabel l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setForeground(new Color(255, 255, 255));
        l1.setFont(new Font("Dubai Medium", Font.BOLD, 35));
        
        JLabel l2 = new JLabel("TO DEPOSIT");
        l2.setForeground(new Color(255, 255, 255));
        l2.setFont(new Font("Dubai Medium", Font.BOLD, 35));
        
        // TEXT INPUT
		txtAmount = new JTextField();
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setFont(new Font("Raleway", Font.BOLD, 22));
		txtAmount.setBounds(217, 250, 300, 33);
		getContentPane().add(txtAmount);
		txtAmount.setColumns(10);
        
        JLabel lblBalance = new JLabel("$ 222");
        lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
        lblBalance.setForeground(Color.WHITE);
        lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblBalance.setBounds(537, 18, 189, 25);
        getContentPane().add(lblBalance);
        
        // DEPOSIT BUTTON
        JButton btnDeposit = new JButton("DEPOSIT");
        btnDeposit.setBackground(new Color(0, 128, 64));
        btnDeposit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deposit();
        		DecimalFormat df = new DecimalFormat("#0.###");
        		lblBalance.setText("$ " + df.format(SelectUserUI.currentUser.getBalance()));
        		txtAmount.setText("");
        	}
        });
        btnDeposit.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        btnDeposit.setForeground(new Color(255, 255, 255));
        //
        
        
        // BACK BUTTON
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		back();
        	}
        });
        btnBack.setBackground(new Color(0, 128, 64));
        btnBack.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        btnBack.setForeground(new Color(255, 255, 255));

        // POSITIONING
        getContentPane().setLayout(null);
        
        l1.setBounds(130,113,465,60);
        getContentPane().add(l1);
        
        l2.setBounds(262,171,213,60);
        getContentPane().add(l2);
        
        t2.setBounds(0,53,736,50);
        getContentPane().add(t2);
        
        btnDeposit.setBounds(217,303,125,50);
        getContentPane().add(btnDeposit);
        
        btnBack.setBounds(392,303,125,50);
        getContentPane().add(btnBack);
        //
        

        
        getContentPane().setBackground(new Color(50, 71, 80));
        
        // LOGO        
		JLabel logoPic = new JLabel("");
		logoPic.setHorizontalAlignment(SwingConstants.CENTER);
		logoPic.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("banklogo.png")).getImage().getScaledInstance(248, 58, Image.SCALE_DEFAULT)));
		logoPic.setBounds(0, 0, 248, 58);
		getContentPane().add(logoPic);
        
        JButton btnHelp = new JButton("Help");
        btnHelp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnHelp.setForeground(Color.WHITE);
        btnHelp.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        btnHelp.setBackground(new Color(0, 128, 64));
        btnHelp.setBounds(10, 456, 81, 32);
        getContentPane().add(btnHelp);
        
        
        JTextField t3 = new JTextField();
        t3.setBorder(new LineBorder(new Color(0, 0, 0)));
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(0, 85, 43));
        
        t3.setFont(new Font("Dubai Medium", Font.BOLD, 22));
        t3.setEditable(false);        
        
        t3.setBounds(0, 446, 736, 50);
        getContentPane().add(t3);
        
        JLabel lblUserID = new JLabel("356254");
        lblUserID.setHorizontalAlignment(SwingConstants.LEFT);
        lblUserID.setForeground(Color.WHITE);
        lblUserID.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUserID.setBounds(280, 18, 189, 25);
        getContentPane().add(lblUserID);
        
        JLabel lblName = new JLabel("Name");
        lblName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(378, 18, 200, 25);
        getContentPane().add(lblName);
        

        
        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
        
		JLabel lblNewLabel = new JLabel("$");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(193, 253, 27, 27);
		getContentPane().add(lblNewLabel);
		
		lblUserID.setText("Acc Nr: " + Integer.toString(SelectUserUI.currentUser.getUserID()));
		lblName.setText(SelectUserUI.currentUser.getName());
		DecimalFormat df = new DecimalFormat("#0.###");
		lblBalance.setText("$ " + df.format(SelectUserUI.currentUser.getBalance()));
	}

	protected void deposit() {
		double currentBalance = SelectUserUI.currentUser.getBalance();
		try {
			currentBalance += Double.parseDouble(txtAmount.getText());
			// create new balance
			
			SelectUserUI.currentUser.setBalance(currentBalance);
			// set private variable with new balance
			
			boolean ok = ax.updateBalance(SelectUserUI.currentUser, currentBalance);
			// update balance in DB
			
			if (ok == true) {
				JOptionPane.showMessageDialog(null, "Amount successfully desposited.");
				
				boolean log = ax.logTransaction(SelectUserUI.currentUser.getUserID(), "Deposit", Double.parseDouble(txtAmount.getText()), " -");
				
				if (log == true) {
					System.out.println("Saved in log");
				}
				else {
					System.out.println("Couldn't save in log");
				}
				
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "Could not deposit amount.");
			}
		}		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please enter only numbers");			
		}		
	}

	// this method closes the current window and opens the menu screen
	protected void back() {
		this.setVisible(false);
		new MenuScreenUI().setVisible(true);
	}
}
