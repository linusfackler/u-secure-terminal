// This is the Transfer UI screen, in which the user can
// transfer money from his account to a recipient's account.
// First, he enters the UserID and checks if the user exists.
// Then, he enters the amount to transfer. The amount will be deducted from his account,
// and added to the recipients account.




package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import backend.User;
import database.Access;

import javax.swing.JButton;

public class TransferUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtWithdrawFunds;
	private JTextField textField_1;
	private JTextField txtAmount;
	
	private Access ax = new Access();
	private JTextField txtRecipient;
	
	public User recipient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferUI frame = new TransferUI();
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
	public TransferUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 71, 80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logo = new JLabel(new ImageIcon("banklogo.png"));
		logo.setBounds(0, 44, 384, -44);
		contentPane.add(logo);
		
		txtWithdrawFunds = new JTextField();
		txtWithdrawFunds.setText("     Transfer Funds");
		txtWithdrawFunds.setForeground(Color.WHITE);
		txtWithdrawFunds.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		txtWithdrawFunds.setEditable(false);
		txtWithdrawFunds.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtWithdrawFunds.setBackground(new Color(0, 85, 43));
		txtWithdrawFunds.setBounds(0, 61, 736, 50);
		contentPane.add(txtWithdrawFunds);
		
		JLabel l1 = new JLabel("Recipient AccountID:");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Dubai Medium", Font.BOLD, 30));
		l1.setBounds(41, 128, 300, 60);
		contentPane.add(l1);
		
		JLabel lblUserID = new JLabel("Acc Nr: 0");
		lblUserID.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserID.setForeground(Color.WHITE);
		lblUserID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserID.setBounds(280, 25, 189, 25);
		contentPane.add(lblUserID);
		
		JLabel lblName = new JLabel((String) null);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(378, 25, 200, 25);
		contentPane.add(lblName);
		
		JLabel lblBalance = new JLabel("$ 0.0");
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBalance.setBounds(537, 25, 189, 25);
		contentPane.add(lblBalance);
		
		JButton btnTransfer = new JButton("TRANSFER");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transfer();
				DecimalFormat df = new DecimalFormat("#0.###");
				lblBalance.setText("$ " + df.format(SelectUserUI.currentUser.getBalance()));
				txtAmount.setText("");
			}
		});
		btnTransfer.setForeground(Color.WHITE);
		btnTransfer.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		btnTransfer.setBackground(new Color(0, 128, 64));
		btnTransfer.setBounds(194, 374, 125, 50);
		contentPane.add(btnTransfer);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Dubai Medium", Font.BOLD, 18));
		btnBack.setBackground(new Color(0, 128, 64));
		btnBack.setBounds(435, 374, 125, 50);
		contentPane.add(btnBack);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setForeground(Color.WHITE);
		btnHelp.setFont(new Font("Dubai Medium", Font.BOLD, 18));
		btnHelp.setBackground(new Color(0, 128, 64));
		btnHelp.setBounds(10, 458, 81, 32);
		contentPane.add(btnHelp);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		textField_1.setEditable(false);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_1.setBackground(new Color(0, 85, 43));
		textField_1.setBounds(0, 448, 736, 50);
		contentPane.add(textField_1);
		
        // LOGO
		JLabel logoPic = new JLabel("");
		logoPic.setHorizontalAlignment(SwingConstants.CENTER);
		logoPic.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("banklogo.png")).getImage().getScaledInstance(248, 58, Image.SCALE_DEFAULT)));
		logoPic.setBounds(0, 0, 248, 58);
		contentPane.add(logoPic);
		

        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
        
		lblUserID.setText("Acc Nr: " + Integer.toString(SelectUserUI.currentUser.getUserID()));
		lblName.setText(SelectUserUI.currentUser.getName());
		DecimalFormat df = new DecimalFormat("#0.###");
		lblBalance.setText("$ " + df.format(SelectUserUI.currentUser.getBalance()));
		
		txtAmount = new JTextField();
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setFont(new Font("Dialog", Font.BOLD, 22));
		txtAmount.setColumns(10);
		txtAmount.setBounds(351, 279, 300, 33);
		contentPane.add(txtAmount);
		
		JLabel lblNewLabel = new JLabel("$");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setBounds(331, 282, 27, 27);
		contentPane.add(lblNewLabel);
		
		txtRecipient = new JTextField();
		txtRecipient.setHorizontalAlignment(SwingConstants.CENTER);
		txtRecipient.setFont(new Font("Dialog", Font.BOLD, 22));
		txtRecipient.setColumns(10);
		txtRecipient.setBounds(351, 139, 300, 33);
		contentPane.add(txtRecipient);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Dubai Medium", Font.BOLD, 30));
		lblAmount.setBounds(43, 269, 300, 60);
		contentPane.add(lblAmount);
		
		JLabel lblRecipient = new JLabel("");
		lblRecipient.setBackground(new Color(224, 224, 224));
		lblRecipient.setForeground(new Color(242, 242, 242));
		lblRecipient.setFont(new Font("Dubai Medium", Font.PLAIN, 26));
		lblRecipient.setBounds(94, 188, 300, 43);
		contentPane.add(lblRecipient);
		
		JButton btnFindUser = new JButton("FIND USER");
		btnFindUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findUser();
				if (recipient != null)
					lblRecipient.setText(recipient.getName());
			}
		});
		
		btnFindUser.setForeground(Color.WHITE);
		btnFindUser.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		btnFindUser.setBackground(new Color(0, 128, 64));
		btnFindUser.setBounds(526, 182, 125, 50);
		contentPane.add(btnFindUser);

	}

	protected void findUser() {
		try {
			recipient = new User();
			int userid = Integer.parseInt(txtRecipient.getText());
			
			if (userid == SelectUserUI.currentUser.getUserID()) {
				JOptionPane.showMessageDialog(null, "Recipient cannot be yourself.");
				return;
			}
			
			recipient = ax.searchUser(userid);
			
			if (recipient == null) {
				JOptionPane.showMessageDialog(null, "Cannot find recipient.");
				return;
			}

		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error selecting recipient.");			
		}
	}

	// this method transfers funds from the current user to the recipient
	protected void transfer() {		
			double currentBalance = SelectUserUI.currentUser.getBalance();
			double recipientBalance = recipient.getBalance();
			try {
				currentBalance -= Double.parseDouble(txtAmount.getText());
				recipientBalance += Double.parseDouble(txtAmount.getText());
				// create new balance
				
				if (currentBalance < 0) {
					JOptionPane.showMessageDialog(null, "Cannot transfer as balance would fall below 0.");
					return;
					// if balance would fall below 0, return with error
				}		
				SelectUserUI.currentUser.setBalance(currentBalance);
				recipient.setBalance(recipientBalance);
				// set private variable with new balance
				
				boolean ok = ax.updateBalance(SelectUserUI.currentUser, currentBalance);
				boolean okR = ax.updateBalance(recipient, recipientBalance);
				// update balance in DB
				
				if (ok == true && okR == true) {
					JOptionPane.showMessageDialog(null, "Amount successfully transferred.");
					
					boolean log = ax.logTransaction(SelectUserUI.currentUser.getUserID(), "Transfer", Double.parseDouble(txtAmount.getText()), recipient.getName());
					
					if (log == true) {
						System.out.println("Saved in log");
					}
					else {
						System.out.println("Couldn't save in log");
					}
					
					return;
				}
				else {
					JOptionPane.showMessageDialog(this, "Could not transfer amount.");
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
