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
import javax.swing.JButton;

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
		logoPic.setIcon(new ImageIcon(new ImageIcon("src/banklogo.png").getImage().getScaledInstance(300, 80, Image.SCALE_DEFAULT)));
		logoPic.setBounds(10, 11, 346, 80);
		contentPane.add(logoPic);
		
		JLabel serviceText = new JLabel("CHOOSE SERVICE");
		serviceText.setForeground(new Color(255, 255, 255));
		serviceText.setHorizontalAlignment(SwingConstants.CENTER);
		serviceText.setFont(new Font("Dubai Medium", Font.PLAIN, 62));
		serviceText.setBounds(20, 102, 979, 112);
		contentPane.add(serviceText);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(55, 71, 79));
		panel.setBounds(30, 204, 946, 430);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDeposit = new JButton("DEPOSIT");
		btnDeposit.setFont(new Font("Dubai Medium", Font.PLAIN, 33));
		btnDeposit.setBackground(Color.WHITE);
		btnDeposit.setOpaque(true);
		btnDeposit.setForeground(Color.BLACK);
		btnDeposit.setBounds(29, 28, 377, 154);
		panel.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("CASH WITHDRAWAL");
		btnWithdraw.setBackground(Color.WHITE);
		btnWithdraw.setOpaque(true);
		btnWithdraw.setForeground(Color.BLACK);
		btnWithdraw.setFont(new Font("Dubai Medium", Font.PLAIN, 33));
		btnWithdraw.setBounds(539, 28, 377, 154);
		panel.add(btnWithdraw);
		
		JButton btnTransfer = new JButton("TRANSFER");
		btnTransfer.setBackground(Color.WHITE);
		btnTransfer.setOpaque(true);
		btnTransfer.setForeground(Color.BLACK);
		btnTransfer.setFont(new Font("Dubai Medium", Font.PLAIN, 33));
		btnTransfer.setBounds(29, 239, 377, 154);
		panel.add(btnTransfer);
		
		JButton btnRecent = new JButton("RECENT TRANSACTIONS");
		btnRecent.setBackground(Color.WHITE);
		btnRecent.setOpaque(true);
		btnRecent.setForeground(Color.BLACK);
		btnRecent.setFont(new Font("Dubai Medium", Font.PLAIN, 30));
		btnRecent.setBounds(539, 239, 377, 154);
		panel.add(btnRecent);
	}

}
