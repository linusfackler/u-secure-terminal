package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class WithdrawUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtWithdrawFunds;
	private JTextField txtAmount;
	private JTextField textField_1;

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
		txtWithdrawFunds.setBounds(0, 44, 736, 50);
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
		
		txtAmount = new JTextField();
		txtAmount.setText("$ ");
		txtAmount.setFont(new Font("Dialog", Font.BOLD, 22));
		txtAmount.setBounds(227, 249, 300, 50);
		contentPane.add(txtAmount);
		
		JButton btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWithdraw.setForeground(Color.WHITE);
		btnWithdraw.setFont(new Font("Dubai Medium", Font.BOLD, 17));
		btnWithdraw.setBackground(new Color(0, 128, 64));
		btnWithdraw.setBounds(227, 310, 125, 50);
		contentPane.add(btnWithdraw);
		
		JButton btnBack = new JButton("BACK");
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

        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
	}
}
