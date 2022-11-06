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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
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
        JTextField txtAmount = new JTextField();
        
        txtAmount.setText("$ ");
        txtAmount.setFont(new Font("Raleway", Font.BOLD, 22));
        //
        
        
        // DEPOSIT BUTTON
        JButton btnDeposit = new JButton("DEPOSIT");
        btnDeposit.setBackground(new Color(0, 128, 64));
        btnDeposit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnDeposit.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        btnDeposit.setForeground(new Color(255, 255, 255));
        //
        
        
        // BACK BUTTON
        JButton btnBack = new JButton("BACK");
        btnBack.setBackground(new Color(0, 128, 64));
        btnBack.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        btnBack.setForeground(new Color(255, 255, 255));
        //
        
        
        // POSITIONING
        getContentPane().setLayout(null);
        
        l1.setBounds(130,113,465,60);
        getContentPane().add(l1);
        
        l2.setBounds(262,171,213,60);
        getContentPane().add(l2);
        
        txtAmount.setBounds(217,242,300,50);
        getContentPane().add(txtAmount);
        
        t2.setBounds(0,42,736,50);
        getContentPane().add(t2);
        
        btnDeposit.setBounds(217,303,125,50);
        getContentPane().add(btnDeposit);
        
        btnBack.setBounds(392,303,125,50);
        getContentPane().add(btnBack);
        //
        

        
        getContentPane().setBackground(new Color(50, 71, 80));
        
        // LOGO
        ImageIcon imageIcon = new ImageIcon("banklogo.png"); 
        Image image = imageIcon.getImage(); 
        Image newimg = image.getScaledInstance(139, 32,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(newimg));
        lblNewLabel.setBounds(10, 0, 147, 50);
        getContentPane().add(lblNewLabel);
        
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
        

        //
        

        
        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
	}
}
