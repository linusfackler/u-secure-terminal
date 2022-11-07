// This is the Main Screen that starts the program.
// The user scans his fingerprint and enters the main menu
// The user is also able to change the language
// The language change and the finger print scan is not implemented yet,
// as we need to figure out a way to do so.
// Currently, by clicking the main menu button, the user enters a temporary screen,
// in which he can select an account or create a new one.
// This is just for demonstration purposes



package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.Panel;
import javax.swing.JDesktopPane;

public class MainScreenUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreenUI frame = new MainScreenUI();
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
	public MainScreenUI() {
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
		
		JLabel scanText = new JLabel("PLEASE SCAN FINGERPRINT");
		scanText.setForeground(new Color(255, 255, 255));
		scanText.setHorizontalAlignment(SwingConstants.CENTER);
		scanText.setFont(new Font("Dubai Medium", Font.PLAIN, 50));
		scanText.setBounds(-16, 49, 770, 87);
		contentPane.add(scanText);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(55, 71, 79));
		panel.setBounds(137, 133, 459, 383);
		contentPane.add(panel);
		
		JButton btnMenu = new JButton("Main Menu");
		btnMenu.setBounds(137, 46, 192, 67);
		btnMenu.setFont(new Font("Dubai Medium", Font.PLAIN, 28));
		btnMenu.setBackground(Color.WHITE);
		btnMenu.setOpaque(true);
		btnMenu.setForeground(Color.BLACK);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMenu();
			}
		});
		panel.setLayout(null);
		panel.add(btnMenu);
		
		JButton btnEnglish = new JButton("English");
		btnEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnglish.setForeground(Color.BLACK);
		btnEnglish.setFont(new Font("Dubai Medium", Font.PLAIN, 28));
		btnEnglish.setBackground(Color.WHITE);
		btnEnglish.setOpaque(true);
		btnEnglish.setBounds(10, 147, 192, 67);
		panel.add(btnEnglish);
		
		JButton btnFrench = new JButton("Fran\u00E7ais");
		btnFrench.setForeground(Color.BLACK);
		btnFrench.setFont(new Font("Dubai Medium", Font.PLAIN, 28));
		btnFrench.setBackground(Color.WHITE);
		btnFrench.setOpaque(true);
		btnFrench.setBounds(257, 147, 192, 67);
		panel.add(btnFrench);
		
		JButton btnGerman = new JButton("Deutsch");
		btnGerman.setForeground(Color.BLACK);
		btnGerman.setFont(new Font("Dubai Medium", Font.PLAIN, 28));
		btnGerman.setBackground(Color.WHITE);
		btnGerman.setOpaque(true);
		btnGerman.setBounds(10, 267, 192, 67);
		panel.add(btnGerman);
		
		JButton btnMandarin = new JButton("\u4E2D\u56FD\u4EBA");
		btnMandarin.setForeground(Color.BLACK);
		btnMandarin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btnMandarin.setBackground(Color.WHITE);
		btnMandarin.setOpaque(true);
		btnMandarin.setBounds(257, 267, 192, 67);
		panel.add(btnMandarin);
		
		JLabel fingerPrintPic = new JLabel("");
		fingerPrintPic.setHorizontalAlignment(SwingConstants.CENTER);
		fingerPrintPic.setIcon(new ImageIcon(new ImageIcon("fingerprint.png").getImage().getScaledInstance(63, 73, Image.SCALE_DEFAULT)));
		fingerPrintPic.setBounds(652, 293, 63, 73);
		contentPane.add(fingerPrintPic);
		
		JLabel fingerPrintPic_1 = new JLabel("");
		fingerPrintPic_1.setIcon(new ImageIcon(new ImageIcon("arrow.png").getImage().getScaledInstance(104, 112, Image.SCALE_DEFAULT)));
		fingerPrintPic_1.setHorizontalAlignment(SwingConstants.CENTER);
		fingerPrintPic_1.setBounds(632, 376, 104, 112);
		contentPane.add(fingerPrintPic_1);
		
        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
	}

	protected void openMenu() {
		this.setVisible(false);
		new SelectUserUI().setVisible(true);
		// switch to SelectUserUI window
	}
}
