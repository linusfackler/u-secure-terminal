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

public class WithdrawUI extends JFrame {
	
	private JPanel contentPane;

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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("$   ");
		formattedTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		formattedTextField.setBounds(59, 98, 311, 57);
		contentPane.add(formattedTextField);
		
		JLabel lblNewLabel = new JLabel("How much would you like to withdraw?");
		lblNewLabel.setForeground(new Color(254, 255, 255));
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 39, 413, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter on keypad");
		lblNewLabel_1.setForeground(new Color(254, 255, 255));
		lblNewLabel_1.setBounds(160, 179, 145, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Press \"Enter\" when done");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(new Color(254, 255, 255));
		lblNewLabel_2.setBounds(139, 228, 275, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel logo = new JLabel(new ImageIcon("banklogo.png"));
		logo.setBounds(0, 44, 384, -44);
		contentPane.add(logo);

        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
	}
}
