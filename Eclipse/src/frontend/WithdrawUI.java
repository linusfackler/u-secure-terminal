package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
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

public class WithdrawUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtWithdrawFunds;
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
					WithdrawUI frame = new WithdrawUI();
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
	public WithdrawUI() {
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
		txtWithdrawFunds.setText("     Withdraw Funds");
		txtWithdrawFunds.setForeground(Color.WHITE);
		txtWithdrawFunds.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		txtWithdrawFunds.setEditable(false);
		txtWithdrawFunds.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtWithdrawFunds.setBackground(new Color(0, 85, 43));
		txtWithdrawFunds.setBounds(0, 61, 736, 50);
		contentPane.add(txtWithdrawFunds);
		
		JLabel l1 = new JLabel("ENTER AMOUNT YOU WANT");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Dubai Medium", Font.BOLD, 35));
		l1.setBounds(127, 121, 465, 60);
		contentPane.add(l1);
		
		JLabel lblToWithdraw = new JLabel("TO WITHDRAW");
		lblToWithdraw.setForeground(Color.WHITE);
		lblToWithdraw.setFont(new Font("Dubai Medium", Font.BOLD, 35));
		lblToWithdraw.setBounds(243, 179, 259, 60);
		contentPane.add(lblToWithdraw);
		
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
		
		JButton btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw();
				lblBalance.setText("$ " + Double.toString(SelectUserUI.currentUser.getBalance()));
			}
		});
		btnWithdraw.setForeground(Color.WHITE);
		btnWithdraw.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		btnWithdraw.setBackground(new Color(0, 128, 64));
		btnWithdraw.setBounds(227, 310, 125, 50);
		contentPane.add(btnWithdraw);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Dubai Medium", Font.BOLD, 18));
		btnBack.setBackground(new Color(0, 128, 64));
		btnBack.setBounds(402, 310, 125, 50);
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
		logoPic.setIcon(new ImageIcon(new ImageIcon("banklogo.png").getImage().getScaledInstance(248, 58, Image.SCALE_DEFAULT)));
		logoPic.setBounds(0, 0, 248, 58);
		contentPane.add(logoPic);
		

        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
        
		lblUserID.setText("Acc Nr: " + Integer.toString(SelectUserUI.currentUser.getUserID()));
		lblName.setText(SelectUserUI.currentUser.getName());
		lblBalance.setText("$ " + Double.toString(SelectUserUI.currentUser.getBalance()));
		
		txtAmount = new JTextField();
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setFont(new Font("Dialog", Font.BOLD, 22));
		txtAmount.setColumns(10);
		txtAmount.setBounds(226, 261, 300, 33);
		contentPane.add(txtAmount);
		
		JLabel lblNewLabel = new JLabel("$");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setBounds(202, 264, 27, 27);
		contentPane.add(lblNewLabel);
	}

	protected void withdraw() {
		double currentBalance = SelectUserUI.currentUser.getBalance();
		try {
			currentBalance -= Double.parseDouble(txtAmount.getText());
			
			if (currentBalance < 0) {
				JOptionPane.showMessageDialog(null, "Cannot withdraw as balance would fall below 0.");
				return;
			}		
			SelectUserUI.currentUser.setBalance(currentBalance);
			
			boolean ok = ax.updateBalance(SelectUserUI.currentUser, currentBalance);
			
			if (ok == true) {
				JOptionPane.showMessageDialog(null, "Amount successfully withdrawn.");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "Could not withdraw amount.");
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
