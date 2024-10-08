package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class interfaceAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceAdmin frame = new interfaceAdmin();
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
	public interfaceAdmin() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome admin!");
		lblNewLabel.setBounds(156, 10, 182, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("choose action :");
		lblNewLabel_1.setBounds(29, 33, 182, 13);
		contentPane.add(lblNewLabel_1);
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(240, 240, 240));
		textPane.setBounds(10, 139, 416, 301);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("consulter tous le livres");
		btnNewButton.addActionListener(new ActionListener() {
		
		Administrateur a=new Administrateur("Admin","abc123");
		public void actionPerformed(ActionEvent e) {
			textPane.setText(a.consulterLivres());
		}
		});
		btnNewButton.setBounds(123, 33, 171, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("consulter un livre");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new consulterLivre();
				consulterLivre.main(null);
			}
		});
		btnNewButton_1.setBounds(123, 56, 171, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ajouter livre");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AJouterLivre();
				AJouterLivre.main(null);
			}
		});
		btnNewButton_2.setBounds(123, 82, 171, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("supprimer livre");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SupprimerLivre();
				SupprimerLivre.main(null);
			}
		});
		btnNewButton_3.setBounds(123, 108, 171, 21);
		contentPane.add(btnNewButton_3);
		
		
	}
}
