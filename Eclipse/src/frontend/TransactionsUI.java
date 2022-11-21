// This is the Transaction UI screen. Here, the user can see all his previous transactions.




package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;
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

import backend.Transaction;
import backend.User;
import database.Access;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TransactionsUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtWithdrawFunds;
	private JTextField textField_1;
	
	private Access ax = new Access();
	
	public User recipient;
	private JTable transactionTbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionsUI frame = new TransactionsUI();
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
	public TransactionsUI() {
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
		txtWithdrawFunds.setText("     Transaction log:");
		txtWithdrawFunds.setForeground(Color.WHITE);
		txtWithdrawFunds.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		txtWithdrawFunds.setEditable(false);
		txtWithdrawFunds.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtWithdrawFunds.setBackground(new Color(0, 85, 43));
		txtWithdrawFunds.setBounds(0, 61, 736, 50);
		contentPane.add(txtWithdrawFunds);
		
		JLabel lblUserID = new JLabel("Acc Nr: 0");
		lblUserID.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserID.setForeground(Color.WHITE);
		lblUserID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserID.setBounds(280, 25, 189, 25);
		contentPane.add(lblUserID);
		
		JLabel lblName = new JLabel((String) null);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(378, 25, 200, 25);
		contentPane.add(lblName);
		
		JLabel lblBalance = new JLabel("$ 0.0");
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBalance.setBounds(537, 25, 189, 25);
		contentPane.add(lblBalance);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Dubai Medium", Font.BOLD, 18));
		btnBack.setBackground(new Color(0, 128, 64));
		btnBack.setBounds(310, 370, 125, 50);
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
		
        // LOGO
		JLabel logoPic = new JLabel("");
		logoPic.setHorizontalAlignment(SwingConstants.CENTER);
		logoPic.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("banklogo.png")).getImage().getScaledInstance(248, 58, Image.SCALE_DEFAULT)));
		logoPic.setBounds(0, 0, 248, 58);
		contentPane.add(logoPic);
		

        setSize(750,535);
        setLocation(400,100);
        setVisible(true);
        
		lblUserID.setText("Acc Nr: " + Integer.toString(SelectUserUI.currentUser.getUserID()));
		lblName.setText(SelectUserUI.currentUser.getName());
		DecimalFormat df = new DecimalFormat("#0.###");
		lblBalance.setText("$ " + df.format(SelectUserUI.currentUser.getBalance()));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 124, 606, 233);
		contentPane.add(scrollPane);
		
		transactionTbl = new JTable();
		scrollPane.setViewportView(transactionTbl);
		transactionTbl.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Transaction Type", "Amount", "Recipient", "Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		transactionTbl.getColumnModel().getColumn(0).setPreferredWidth(150);
		transactionTbl.getColumnModel().getColumn(1).setPreferredWidth(150);
		transactionTbl.getColumnModel().getColumn(2).setPreferredWidth(150);
		transactionTbl.getColumnModel().getColumn(3).setPreferredWidth(150);
		
		DefaultTableModel model = (DefaultTableModel) transactionTbl.getModel();
		//model.addRow(new Object[] {"Test", "Test", "ada", "hfes"});

		setLog(model);
		
	}

	private void setLog(DefaultTableModel m) {
		int count = ax.rows(SelectUserUI.currentUser.getUserID());
		Transaction transaction;
		
		try {
			transaction = new Transaction();
			for (int i = 0; i < count; i++) {
				transaction = ax.getTransaction(SelectUserUI.currentUser.getUserID(), i);
				m.addRow(new Object[] {transaction.getType(), transaction.getAmount(), transaction.getRecipient(), transaction.getDate()});
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error selecting transactions.");			
		}
		
	}

	// this method closes the current window and opens the menu screen
	protected void back() {
		this.setVisible(false);
		new MenuScreenUI().setVisible(true);
	}
}
