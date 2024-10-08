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

public class CommanderLivre extends JFrame {

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
					CommanderLivre frame = new CommanderLivre();
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
	public CommanderLivre() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Commander Livre");
		lblNewLabel.setBounds(127, 10, 191, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Donner l'ISBN du livre a ajoutée:");
		lblNewLabel_1.setBounds(10, 47, 240, 19);
		contentPane.add(lblNewLabel_1);
		
		Client a=new Client();
		
		textField = new JTextField();
		textField.setBounds(220, 47, 138, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel output = new JLabel("");
		output.setBounds(36, 131, 348, 27);
		contentPane.add(output);
		
		JButton btnNewButton = new JButton("Commander");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = textField.getText();
				try {
					output.setText(a.commanderLivre(isbn));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(140, 76, 153, 21);
		contentPane.add(btnNewButton);
		
		
	}

}
