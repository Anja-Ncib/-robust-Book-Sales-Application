package p1;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class swing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing frame = new swing();
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
	public swing() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setBounds(138, 10, 115, 37);
		contentPane.add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(162, 57, 188, 19);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setBounds(138, 132, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("login:");
		lblNewLabel_1.setBounds(54, 60, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("mot de passe :");
		lblNewLabel_2.setBounds(35, 97, 85, 13);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 94, 188, 19);
		contentPane.add(passwordField);
		
		JLabel output = new JLabel("");
		output.setBounds(75, 182, 275, 37);
		contentPane.add(output); 
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				String username = txtLogin.getText();
		        String password = new String(passwordField.getPassword());
		        
		        Administrateur admin=new Administrateur(username,password);
		        Client client=new Client(username,password);
		        
		        if (admin.verifAdmin()) {
		        	output.setText("Login Admin successful!");
		        	new interfaceAdmin();
		        	interfaceAdmin.main(null);
		        } else {
		        	try {
						if (client.verifClient()){
							output.setText("Login client successful!");
							new interfaceClient();
							interfaceClient.main(null);
							
						}else {
							output.setText("Invalid username or password. Please try again.");
		      }
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}

			}

	
		});
		
	}
}
