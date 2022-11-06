package frontend;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.User;
import database.Access;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtBalance;
	
	private User currentUser;
	private Access ax = new Access();
	private ArrayList<User> userlist;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(72, 65, 96, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtBalance = new JTextField();
		txtBalance.setBounds(225, 65, 96, 19);
		contentPane.add(txtBalance);
		txtBalance.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUser();
			}
		});
		
		
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnCreate.setBounds(83, 136, 174, 51);
		contentPane.add(btnCreate);
	}

	// method to create user from entered data
	protected void createUser() {
		User newUser = new User();
		
		try {
			//newUser.setUserID(Integer.parseInt(txtName.getText()));
			newUser.setName(txtName.getText());
			newUser.setBalance(Double.parseDouble(txtBalance.getText()));
			newUser.setFingerPrint("10111010");
			
			boolean ok = ax.createUser(newUser);
			
			if (ok == true) {
				JOptionPane.showMessageDialog(this, "User created");
			}
			else {
				JOptionPane.showMessageDialog(this, "Can't create user");
			}
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please enter correct type of data.");			
		}
	}
}















