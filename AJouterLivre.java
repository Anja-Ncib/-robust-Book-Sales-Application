package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AJouterLivre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textisbn;
	private JTextField textauteur;
	private JTextField texttitre;
	private JTextField textannee;
	private JTextField textprix;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AJouterLivre frame = new AJouterLivre();
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
	public AJouterLivre() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textisbn = new JTextField();
		textisbn.setBounds(137, 39, 96, 19);
		contentPane.add(textisbn);
		textisbn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ajouter un nouveau livre");
		lblNewLabel.setBounds(127, 10, 140, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN:");
		lblNewLabel_1.setBounds(38, 42, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Auteur:");
		lblNewLabel_2.setBounds(38, 65, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Titre :");
		lblNewLabel_3.setBounds(38, 88, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Année :");
		lblNewLabel_4.setBounds(38, 111, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Prix :");
		lblNewLabel_5.setBounds(38, 134, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		textauteur = new JTextField();
		textauteur.setBounds(137, 62, 96, 19);
		contentPane.add(textauteur);
		textauteur.setColumns(10);
		
		texttitre = new JTextField();
		texttitre.setBounds(137, 85, 96, 19);
		contentPane.add(texttitre);
		texttitre.setColumns(10);
		
		textannee = new JTextField();
		textannee.setBounds(137, 108, 96, 19);
		contentPane.add(textannee);
		textannee.setColumns(10);
		
		JLabel output = new JLabel("");
		output.setBounds(43, 200, 359, 30);
		contentPane.add(output);
		Administrateur a=new Administrateur("Admin","abc123");

		
		textprix = new JTextField();
		textprix.setBounds(137, 131, 96, 19);
		contentPane.add(textprix);
		textprix.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn=textisbn.getText();
				String auteur=textauteur.getText();
				String titre=texttitre.getText();
				String annee=textannee.getText();
				String prix=textprix.getText();
				Livre l=new Livre(isbn,auteur,titre,Integer.parseInt(annee),Float.parseFloat(prix));
				output.setText(a.ajouterLivre(l));
			}
		});
		btnNewButton.setBounds(292, 84, 85, 21);
		contentPane.add(btnNewButton);
		
		
	}
}
