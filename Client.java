package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client extends Utilisateur{

	public Client(String l, String m) {
		super(l, m);
	}
	
	public Client() {}
	
	public boolean verifClient() throws SQLException, ClassNotFoundException {
		String dbName="TPArchi";
		String login="root";
		String mdp="0000";
		String url="jdbc:mysql://127.0.0.1:3306/"+dbName;
	 	Connection connection = null;
	 	PreparedStatement statement = null;
        ResultSet resultSet = null;
        int rowCount = 0;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,login,mdp);
			String query = "SELECT id FROM Client WHERE login=? and password=?";
			statement = connection.prepareStatement(query);
	        statement.setString(1,this.login);
	        statement.setString(2,this.mdp);
	        resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            rowCount++;
	        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return (rowCount>0);
	}

	public String livresCommande() {
		String l=super.login;
		String dbName="TPArchi";
		String login="root";
		String mdp="0000";
		String url="jdbc:mysql://127.0.0.1:3306/"+dbName;
	 	Connection connection = null;
	 	PreparedStatement statement = null;
        ResultSet resultSet = null;
        String columnValue="";
        try {

        	Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,login,mdp);

			String query = "SELECT livres_commandes FROM Client WHERE login=?";
			statement = connection.prepareStatement(query);
	        statement.setString(1, l);
	        resultSet = statement.executeQuery();
            while (resultSet.next()) {
                
                 columnValue = resultSet.getString("livres_commandes");
                
                // Display the data
                
            }
	
        	} catch (ClassNotFoundException e) {
        			e.printStackTrace();
        	} catch (SQLException e) {
        			e.printStackTrace();
        	} finally {
        		// Close resources in the finally block
        	try {
        		if (resultSet != null) {
        			resultSet.close();
        		}
        		if (statement != null) {
        			statement.close();
        		}
        		if (connection != null) {
        			connection.close();
        		}
        	} catch (SQLException e) {
        		e.printStackTrace();
        }
    }
        return columnValue;
        
}
	
	public String commanderLivre(String isbnL) throws ClassNotFoundException {
		String livres=livresCommande()+" "+isbnL;
		String l=super.login;
		String dbName="TPArchi";
		String login="root";
		String mdp="0000";
		String url="jdbc:mysql://127.0.0.1:3306/"+dbName;
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        String output=null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,login,mdp);
			String updateQuery = "UPDATE Client SET livres_commandes = ? WHERE login='"+l+"'";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			statement.setString(1, livres);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
                output=" Commanded successfully.";
            } else {
                output="Command failed.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return output;
		}
	}


