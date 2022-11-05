import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAmount;

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
		
		txtAmount = new JTextField();
		txtAmount.setBounds(268, 65, 96, 19);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnCreate.setBounds(83, 136, 174, 51);
		contentPane.add(btnCreate);
	}

	protected void create() {
		String userName = txtName.getText();
		double userAmount = Double.valueOf(txtAmount.getText());
		System.out.println("User " + userName + " is created with amount " + userAmount);
	}
}
