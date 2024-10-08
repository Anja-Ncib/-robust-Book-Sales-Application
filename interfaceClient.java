package p1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfaceClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceClient frame = new interfaceClient();
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
	public interfaceClient() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME CLIENT !");
		lblNewLabel.setBounds(149, 10, 135, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("choose action :");
		lblNewLabel_1.setBounds(34, 50, 112, 13);
		contentPane.add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(240, 240, 240));
		textPane.setBounds(34, 161, 408, 207);
		contentPane.add(textPane);
		
		Client a = new Client();
		
		JButton btnNewButton = new JButton("consulter tous les livres");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(a.consulterLivres());

			}
		});
		btnNewButton.setBounds(164, 46, 171, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("consulter livre");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new consulterLivre();
				consulterLivre.main(null);
			}
		});
		btnNewButton_1.setBounds(163, 77, 172, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("commander livre");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CommanderLivre();
				CommanderLivre.main(null);
			}
		});
		btnNewButton_2.setBounds(164, 108, 171, 21);
		contentPane.add(btnNewButton_2);
		
		
	}

}
