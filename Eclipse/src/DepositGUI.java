import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.EventQueue;

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
        JTextField t1 = new JTextField();
        
        t1.setText("$ ");
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        //
        
        
        // DEPOSIT BUTTON
        JButton b1 = new JButton("DEPOSIT");
        b1.setBackground(new Color(0, 128, 64));
        b1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        b1.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        b1.setForeground(new Color(255, 255, 255));
        //
        
        
        // BACK BUTTON
        JButton b2 = new JButton("BACK");
        b2.setBackground(new Color(0, 128, 64));
        b2.setFont(new Font("Dubai Medium", Font.BOLD, 18));
        b2.setForeground(new Color(255, 255, 255));
        //
        
        
        // POSITIONING
        getContentPane().setLayout(null);
        
        l1.setBounds(130,113,465,60);
        getContentPane().add(l1);
        
        l2.setBounds(262,171,198,60);
        getContentPane().add(l2);
        
        t1.setBounds(217,242,300,50);
        getContentPane().add(t1);
        
        t2.setBounds(-11,41,755,50);
        getContentPane().add(t2);
        
        b1.setBounds(217,303,125,50);
        getContentPane().add(b1);
        
        b2.setBounds(392,303,125,50);
        getContentPane().add(b2);
        //
        

        
        getContentPane().setBackground(new Color(50, 71, 80));
        
        // LOGO
        ImageIcon imageIcon = new ImageIcon("C:\\\\Users\\\\Inne\\\\Downloads\\\\banklogo.png"); 
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
        
        t3.setBounds(-11, 446, 755, 50);
        getContentPane().add(t3);
        

        //
        

        
        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
	}
}
