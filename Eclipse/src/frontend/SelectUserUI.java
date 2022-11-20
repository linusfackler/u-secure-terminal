// This is a temporary screen, in which the user can select
// an account by inputting an account number
// or create a new account.
// After the account is selected or created, the user will advance to the main menu
// If there are any Database errors, the user will receive a pop-up message.
// These errors include wrong input (characters instead of doubles), or the account ID
// exists already.


package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import backend.User;
import database.Access;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class SelectUserUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtCreate;
	private JTextField txtUserID;
	private JTextField textField_1;
	private JTextField txtName;
	
	private Access ax = new Access();
	public static User currentUser;
	public static String encodedImage;

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
		btnSelect.setBounds(23, 305, 145, 50);
		contentPane.add(btnSelect);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Dubai Medium", Font.BOLD, 18));
		btnCreate.setBackground(new Color(0, 128, 64));
		btnCreate.setBounds(458, 305, 125, 50);
		contentPane.add(btnCreate);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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

        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
	}

	protected void scanFinger() {
		
		JFileChooser file_upload = new JFileChooser();	
		int res = file_upload.showSaveDialog(null);
		
		if (res == JFileChooser.APPROVE_OPTION) {
			File file_path = new File(file_upload.getSelectedFile().getAbsolutePath());
			System.out.println(file_path);
			
			try {
				BufferedImage image = ImageIO.read(file_path);
				
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				ImageIO.write(image, "png", outputStream);
				
				encodedImage = Base64.getEncoder().encodeToString(outputStream.toByteArray());
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error scanning finger.");
			}
			
		}
		
		
	}

	protected void select() {
		int userid = Integer.parseInt(txtUserID.getText());
		currentUser = new User();
		
		scanFinger();
		
		try {
			currentUser = ax.searchUser(userid);

			if (currentUser == null) {
				JOptionPane.showMessageDialog(null, "Cannot find user.");
				return;
			}
			
			if (!currentUser.getFingerPrint().equals(encodedImage)) {
				JOptionPane.showMessageDialog(null, "Fingerprints don't match.");
				
				System.out.print("Current:  " + currentUser.getFingerPrint());
				System.out.println("");
				System.out.println("");
				System.out.print("Entered:  " + encodedImage);
				
				
				currentUser = null;
				return;
			}

			this.setVisible(false);
			new MenuScreenUI().setVisible(true);
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error selecting user.");			
		}
	}

	// this method closes the current window and opens the menu screen
	protected void create() {
		currentUser = new User();
		scanFinger();
		
		try {
			int randomNum = ThreadLocalRandom.current().nextInt(300000, 400000);
			// create UserID with random int from 300000 to 400000
			currentUser.setUserID(randomNum);
			currentUser.setName(txtName.getText());
			currentUser.setBalance(0);
			currentUser.setFingerPrint(encodedImage);
			// set user's private variables
			
			boolean ok = ax.createUser(currentUser);
			// create user in DB
			
			if (ok == true) {
				JOptionPane.showMessageDialog(this, "User created");
				this.setVisible(false);
				new MenuScreenUI().setVisible(true);
				// if DB created user, switch to MenuScreenUI
			}
			else {
				currentUser = null;		// if DB couldn't create user, make it null object
				JOptionPane.showMessageDialog(this, "Can't create user");
			}
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please enter correct type of data.");
			// if input data was incorrect
		}
	}
}
