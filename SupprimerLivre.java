package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupprimerLivre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerLivre frame = new SupprimerLivre();
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
	public SupprimerLivre() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supprimer Livre");
		lblNewLabel.setBounds(145, 23, 130, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN du livre à supprimer:");
		lblNewLabel_1.setBounds(30, 62, 130, 13);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(179, 59, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel output = new JLabel("");
		output.setBounds(30, 156, 378, 34);
		contentPane.add(output);
		Administrateur a=new Administrateur("Admin","abc123");

		JButton btnNewButton = new JButton("supprimer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn=textField.getText();
				output.setText(a.supprimerLivre(isbn));
			}
		});
		btnNewButton.setBounds(134, 100, 112, 21);
		contentPane.add(btnNewButton);
	}

}
