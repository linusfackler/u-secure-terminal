package paketGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import paketDatenbank.Fahrzeug_DBZugriff;
import paketFachklasse.Fahrzeug;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;

public class Hauptfenster extends JFrame
{

	private JPanel contentPane;
	private JTextField tfFahrzeugnr;
	private JTextField tfModell;
	private JTextField tfBaujahr;
	private JTextField tfLeistung;
	private JTextField tfKraftstoff;
	private JTextField tfMietpreis;

	private Fahrzeug aktuellesFahrzeug;
	private Fahrzeug_DBZugriff aktuellerZugriff = new Fahrzeug_DBZugriff();
	private ArrayList<Fahrzeug> fahrzeugliste;
	private JTextArea txtrAlleFahrzeuge;
	private JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Hauptfenster frame = new Hauptfenster();
					frame.setVisible(true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hauptfenster()
	{
		setTitle("Mietwagen Baaber GmbH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUeberschrift = new JLabel(
				"Fahrzeugverwaltung - Mietwagen Baaber");
		lblUeberschrift.setBackground(Color.WHITE);
		lblUeberschrift.setHorizontalAlignment(SwingConstants.CENTER);
		lblUeberschrift.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUeberschrift.setBounds(172, 5, 351, 27);
		contentPane.add(lblUeberschrift);

		JLabel lblFahrzeugnr = new JLabel("Fahrzeugnummer:");
		lblFahrzeugnr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFahrzeugnr.setBounds(10, 50, 114, 14);
		contentPane.add(lblFahrzeugnr);

		JLabel lblModell = new JLabel("Modell:");
		lblModell.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModell.setBounds(10, 78, 114, 14);
		contentPane.add(lblModell);

		JLabel lblBaujahr = new JLabel("Baujahr:");
		lblBaujahr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBaujahr.setBounds(10, 108, 114, 14);
		contentPane.add(lblBaujahr);

		JLabel lblLeistungps = new JLabel("Leistung (PS):");
		lblLeistungps.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLeistungps.setBounds(347, 50, 114, 14);
		contentPane.add(lblLeistungps);

		JLabel lblKraftstoff = new JLabel("Kraftstoff:");
		lblKraftstoff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKraftstoff.setBounds(347, 80, 114, 14);
		contentPane.add(lblKraftstoff);

		JLabel lblMietpreistagIn = new JLabel("Mietpreis (Tag in \u20AC):");
		lblMietpreistagIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMietpreistagIn.setBounds(347, 108, 114, 14);
		contentPane.add(lblMietpreistagIn);

		tfFahrzeugnr = new JTextField();
		tfFahrzeugnr.setText("tfFahrzeugnr");
		tfFahrzeugnr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfFahrzeugnr.setBounds(132, 50, 153, 20);
		contentPane.add(tfFahrzeugnr);
		tfFahrzeugnr.setColumns(10);

		tfModell = new JTextField();
		tfModell.setText("tfModell");
		tfModell.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfModell.setColumns(10);
		tfModell.setBounds(132, 78, 153, 20);
		contentPane.add(tfModell);

		tfBaujahr = new JTextField();
		tfBaujahr.setText("tfBaujahr");
		tfBaujahr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfBaujahr.setColumns(10);
		tfBaujahr.setBounds(132, 108, 153, 20);
		contentPane.add(tfBaujahr);

		tfLeistung = new JTextField();
		tfLeistung.setText("tfLeistung");
		tfLeistung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfLeistung.setColumns(10);
		tfLeistung.setBounds(469, 50, 153, 20);
		contentPane.add(tfLeistung);

		tfKraftstoff = new JTextField();
		tfKraftstoff.setText("tfKraftstoff");
		tfKraftstoff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfKraftstoff.setColumns(10);
		tfKraftstoff.setBounds(469, 80, 153, 20);
		contentPane.add(tfKraftstoff);

		tfMietpreis = new JTextField();
		tfMietpreis.setText("tfMietpreis");
		tfMietpreis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tfMietpreis.setColumns(10);
		tfMietpreis.setBounds(469, 108, 153, 20);
		contentPane.add(tfMietpreis);

		JButton btnFahrzeugErfassen = new JButton("erfassen");
		btnFahrzeugErfassen.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFahrzeugErfassen.setBounds(10, 195, 100, 25);
		contentPane.add(btnFahrzeugErfassen);

		JButton btnFahrzeugLoeschen = new JButton("loeschen");
		btnFahrzeugLoeschen.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFahrzeugLoeschen.setBounds(252, 195, 100, 25);
		contentPane.add(btnFahrzeugLoeschen);

		JButton btnFahrzeugSuchen = new JButton(" suchen");
		btnFahrzeugSuchen.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFahrzeugSuchen.setBounds(132, 195, 100, 25);
		contentPane.add(btnFahrzeugSuchen);

		JButton btnAlleFahrzeugeAuflisten = new JButton(
				"Alle Fahrzeuge auflisten");
		btnAlleFahrzeugeAuflisten.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlleFahrzeugeAuflisten.setBounds(10, 260, 190, 25);
		contentPane.add(btnAlleFahrzeugeAuflisten);

		JButton btnFelderLeeren = new JButton("Alle Felder leeren");
		btnFelderLeeren.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFelderLeeren.setBounds(480, 195, 190, 25);
		contentPane.add(btnFelderLeeren);

		JButton btnFensterSchliessen = new JButton("Ende");
		btnFensterSchliessen.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFensterSchliessen.setBounds(584, 397, 86, 36);
		contentPane.add(btnFensterSchliessen);

		JLabel lblFahrzeug = new JLabel("Fahrzeug:");
		lblFahrzeug.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFahrzeug.setBounds(10, 177, 114, 14);
		contentPane.add(lblFahrzeug);

		scrollPane.setBounds(10, 296, 555, 137);
		contentPane.add(scrollPane);

		txtrAlleFahrzeuge = new JTextArea();
		txtrAlleFahrzeuge.setText("txtrAlleFahrzeuge");
		scrollPane.setViewportView(txtrAlleFahrzeuge);

		btnFahrzeugErfassen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				fahrzeugErfassen();
			}
		});

		btnFelderLeeren.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				leeren();
			}
		});

		btnFahrzeugSuchen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				fahrzeugSuchen();
			}
		});

		btnAlleFahrzeugeAuflisten.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				txtrAlleFahrzeuge.setVisible(true);
				scrollPane.setVisible(true);

				alleFahrzeugeAnzeigen();
			}
		});

		btnFensterSchliessen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});

		btnFahrzeugLoeschen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				loeschenFahrzeuge();
			}
		});

	}

	private void fahrzeugErfassen()
	{
		Fahrzeug neuesFahrzeug = new Fahrzeug();
		try
		{
			neuesFahrzeug
					.setFahrzeugnr(Integer.parseInt(tfFahrzeugnr.getText()));
			neuesFahrzeug.setModell(tfModell.getText());
			neuesFahrzeug.setBaujahr(tfBaujahr.getText());
			neuesFahrzeug.setPs(Integer.parseInt(tfLeistung.getText()));
			neuesFahrzeug.setKraftstoff(tfKraftstoff.getText());
			neuesFahrzeug
					.setMietpreis(Double.parseDouble(tfMietpreis.getText()));

			boolean ok = aktuellerZugriff.erfasseFahrzeug(neuesFahrzeug);

			if(ok == true)
			{
				JOptionPane.showMessageDialog(this, "Fahrzeug erfasst");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Fahrzeug nicht erfasst");
			}

		}
		catch(Exception e)
		{
			JOptionPane
					.showMessageDialog(
							null,
							"Bitte geben Sie einen vollstaendigen und korrekten(Text/Zahlen) Datensatz ein!");
		}
	}

	public void leeren()
	{
		tfFahrzeugnr.setText("");
		tfModell.setText("");
		tfBaujahr.setText("");
		tfLeistung.setText("");
		tfKraftstoff.setText("");
		tfMietpreis.setText("");
		tfFahrzeugnr.requestFocus();
		txtrAlleFahrzeuge.setVisible(false);
		scrollPane.setVisible(false);
		txtrAlleFahrzeuge.setText("");
	}

	private void anzeigenFahrzeugdaten()
	{
		leeren();
		tfFahrzeugnr
				.setText(Integer.toString(aktuellesFahrzeug.getFahrzeugnr()));
		tfModell.setText(aktuellesFahrzeug.getModell());
		tfBaujahr.setText(aktuellesFahrzeug.getBaujahr());
		tfLeistung.setText(Integer.toString(aktuellesFahrzeug.getPs()));
		tfKraftstoff.setText(aktuellesFahrzeug.getKraftstoff());
		tfMietpreis.setText(Double.toString(aktuellesFahrzeug.getMietpreis()));
	}

	private void fahrzeugSuchen()
	{
		// Aufgabe 3.3
		// Vervollstaendigen Sie diese Methode
		
		
	}

	private void alleFahrzeugeAnzeigen()
	{
		txtrAlleFahrzeuge.setText("");
		fahrzeugliste = aktuellerZugriff.fahrzeugliste_db();
		String tab = "\t";
		String nz = "\n";

		txtrAlleFahrzeuge.append("FahrzgNr" + tab + "Modell" + tab + "Baujahr"
				+ tab + "PS" + tab + "Kraftstoff" + tab 
				+ "Mietpreis in \u20AC" + nz);
		txtrAlleFahrzeuge
				.append("------------------------------------------------------------------------"
						+ "-------------------------------------------------------------------------------------------------"
						+ nz);
		for (int i = 0; i < fahrzeugliste.size(); i = i + 1)
		{
			txtrAlleFahrzeuge.append(fahrzeugliste.get(i)
					.anzeigenFahrzeugdaten() + nz);
		}

		// Aufgabe 3.4
		// Ergaenzen Sie diesen Methodenabschnitt
		


	}

	private void loeschenFahrzeuge()
	{
		int mJN = JOptionPane.showConfirmDialog(null,
				"Datensatz wirklich loeschen?");

		if(mJN == 0)
		{
			boolean ok = aktuellerZugriff.loescheFahrzeugDB();

			if(ok)
			{
				JOptionPane
						.showMessageDialog(null, "Fahrzeug wurde geloescht!");
				leeren();
			}
			else
			{
				JOptionPane.showMessageDialog(null,
						"Fahrzeug wurde nicht geloescht!");
			}
		}
	}

}
