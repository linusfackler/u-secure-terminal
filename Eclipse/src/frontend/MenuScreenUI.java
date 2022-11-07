// This is the menu screen which lets the user choose 4 options, including
// Deposit, Withdraw, Transfer, and Transactions
// So far, only Deposit and Withdraw are implemented
// In the top right, the users information will show



package frontend;

import java.awt.EventQueue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backend.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuScreenUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuScreenUI frame = new MenuScreenUI();
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
	public MenuScreenUI() {		
		setBackground(new Color(55, 71, 79));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1023, 701);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(55, 71, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logoPic = new JLabel("");
		logoPic.setHorizontalAlignment(SwingConstants.CENTER);
		logoPic.setIcon(new ImageIcon(new ImageIcon("banklogo.png").getImage().getScaledInstance(248, 58, Image.SCALE_DEFAULT)));
		logoPic.setBounds(0, 0, 248, 58);
		contentPane.add(logoPic);
		
		JLabel serviceText = new JLabel("CHOOSE SERVICE");
		serviceText.setForeground(new Color(255, 255, 255));
		serviceText.setHorizontalAlignment(SwingConstants.CENTER);
		serviceText.setFont(new Font("Dubai Medium", Font.PLAIN, 62));
		serviceText.setBounds(20, 102, 706, 112);
		contentPane.add(serviceText);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(55, 71, 79));
		panel.setBounds(30, 204, 684, 284);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDeposit = new JButton("DEPOSIT");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDeposit();		// when button pressed, Deposit screen opened
			}
		});
		btnDeposit.setFont(new Font("Dubai Medium", Font.PLAIN, 33));
		btnDeposit.setBackground(Color.WHITE);
		btnDeposit.setOpaque(true);
		btnDeposit.setForeground(Color.BLACK);
		btnDeposit.setBounds(29, 28, 269, 110);
		panel.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("WITHDRAWAL");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWithdraw();		// when button pressed, Withdraw screen opened
			}
		});
		btnWithdraw.setBackground(Color.WHITE);
		btnWithdraw.setOpaque(true);
		btnWithdraw.setForeground(Color.BLACK);
		btnWithdraw.setFont(new Font("Dubai Medium", Font.PLAIN, 33));
		btnWithdraw.setBounds(385, 27, 272, 113);
		panel.add(btnWithdraw);
		
		JButton btnTransfer = new JButton("TRANSFER");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openTransfer();
			}
		});
		btnTransfer.setBackground(Color.WHITE);
		btnTransfer.setOpaque(true);
		btnTransfer.setForeground(Color.BLACK);
		btnTransfer.setFont(new Font("Dubai Medium", Font.PLAIN, 33));
		btnTransfer.setBounds(29, 164, 269, 110);
		panel.add(btnTransfer);
		
		JButton btnRecent = new JButton("TRANSACTIONS");
		btnRecent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openTransactions();
			}
		});
		btnRecent.setBackground(Color.WHITE);
		btnRecent.setOpaque(true);
		btnRecent.setForeground(Color.BLACK);
		btnRecent.setFont(new Font("Dubai Medium", Font.PLAIN, 30));
		btnRecent.setBounds(385, 164, 272, 110);
		panel.add(btnRecent);
		
		JLabel lblName = new JLabel("Firstname Lastname");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(519, 42, 200, 25);
		contentPane.add(lblName);
		
		JLabel lblUserID = new JLabel("AccountID");
		lblUserID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserID.setForeground(Color.WHITE);
		lblUserID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserID.setBounds(525, 10, 189, 25);
		contentPane.add(lblUserID);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBalance.setBounds(525, 73, 189, 25);
		contentPane.add(lblBalance);
		
        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
        
		User curr = new User();
		curr = SelectUserUI.currentUser;
		lblUserID.setText("Acc Nr: " + Integer.toString(curr.getUserID()));
		lblName.setText(curr.getName());
		lblBalance.setText("$ " + Double.toString(curr.getBalance()));
	}

	protected void openTransactions() {
		// to be added soon
	}

	protected void openTransfer() {
		// to be added soon
	}

	protected void openWithdraw() {
		this.setVisible(false);
		new WithdrawUI().setVisible(true);
		// switch to Withdraw UI
	}

	protected void openDeposit() {
		this.setVisible(false);
		new DepositGUI().setVisible(true);
		// switch to Deposit UI
	}

}
