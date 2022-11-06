package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
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

public class SelectUserUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtCreate;
	private JTextField txtUserID;
	private JTextField textField_1;
	private JTextField txtName;
	private JTextField txtBalance;
	
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
	public SelectUserUI() {
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
		
		txtCreate = new JTextField();
		txtCreate.setText("     Select or Create User");
		txtCreate.setForeground(Color.WHITE);
		txtCreate.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		txtCreate.setEditable(false);
		txtCreate.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCreate.setBackground(new Color(0, 85, 43));
		txtCreate.setBounds(0, 61, 736, 50);
		contentPane.add(txtCreate);
		
		JLabel l1 = new JLabel("SELECT USER");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Dubai Medium", Font.BOLD, 35));
		l1.setBounds(24, 121, 248, 60);
		contentPane.add(l1);
		
		txtUserID = new JTextField();
		txtUserID.setFont(new Font("Dialog", Font.BOLD, 18));
		txtUserID.setBounds(24, 225, 144, 38);
		contentPane.add(txtUserID);
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select();
			}
		});
		btnSelect.setForeground(Color.WHITE);
		btnSelect.setFont(new Font("Dubai Medium", Font.BOLD, 17));
		btnSelect.setBackground(new Color(0, 128, 64));
		btnSelect.setBounds(24, 294, 125, 50);
		contentPane.add(btnSelect);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Dubai Medium", Font.BOLD, 18));
		btnCreate.setBackground(new Color(0, 128, 64));
		btnCreate.setBounds(456, 359, 125, 50);
		contentPane.add(btnCreate);
		
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
		
		JLabel lblCreateUser = new JLabel("CREATE USER");
		lblCreateUser.setForeground(Color.WHITE);
		lblCreateUser.setFont(new Font("Dubai Medium", Font.BOLD, 35));
		lblCreateUser.setBounds(448, 121, 248, 60);
		contentPane.add(lblCreateUser);
		
		JLabel lblUserid = new JLabel("USERID:");
		lblUserid.setForeground(Color.WHITE);
		lblUserid.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		lblUserid.setBounds(24, 194, 88, 32);
		contentPane.add(lblUserid);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		lblName.setBounds(458, 194, 88, 32);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Dialog", Font.BOLD, 18));
		txtName.setBounds(457, 225, 144, 38);
		contentPane.add(txtName);
		
		JLabel lblBalance = new JLabel("BALANCE:");
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		lblBalance.setBounds(458, 283, 88, 32);
		contentPane.add(lblBalance);
		
		txtBalance = new JTextField();
		txtBalance.setFont(new Font("Dialog", Font.BOLD, 18));
		txtBalance.setBounds(457, 311, 144, 38);
		contentPane.add(txtBalance);

        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
	}

	protected void select() {
		int userid = Integer.parseInt(txtUserID.getText());
		User selectedUser = new User();
		
		try {
			selectedUser = ax.searchUser(userid);
			this.setVisible(false);
			new MenuScreenUI().setVisible(true);
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cannot find user.");			
		}
	}

	// this method closes the current window and opens the menu screen
	protected void back() {

	}
}
