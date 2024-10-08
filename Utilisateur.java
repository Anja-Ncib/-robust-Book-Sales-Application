package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilisateur {
	protected String mdp;
	protected String login;
	
	public Utilisateur() {}
	
	public Utilisateur(String l,String m) {
		mdp=m;
		login=l;
	}
	
	public String consulterLivres() {
			String dbName="TPArchi";
			String login="root";
			String mdp="0000";
			String url="jdbc:mysql://127.0.0.1:3306/"+dbName;
		 	Connection connection = null;
	        Statement statement = null;
	        ResultSet resultSet = null;
	        String output="";
	        try {

	        	Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(url,login,mdp);

	            // Create a SQL statement
	            statement = connection.createStatement();

	            // Execute the query
	            resultSet = statement.executeQuery("SELECT * FROM Livre");

	            // Process the result set
	            while (resultSet.next()) {
	                
	                String column1Value = resultSet.getString("isbn");
	                String column2Value = resultSet.getString("auteur");
	                String column3Value = resultSet.getString("titre");
	                String column4Value = resultSet.getString("annee");
	                String column5Value = resultSet.getString("prix");
	                // Display the data
	                output=output+"\n"+("isbn: " + column1Value + ", auteur: " + column2Value+ ", titre: " + column3Value+ ", annee: " + column4Value+ ", prix: " + column5Value);
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
	        return output;
	    }
	public String consulterLivre(String isbnL) {
		String dbName="TPArchi";
		String login="root";
		String mdp="0000";
		String url="jdbc:mysql://127.0.0.1:3306/"+dbName;
	 	Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String output="";
        try {

        	Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,login,mdp);

            // Create a SQL statement
            statement = connection.createStatement();

            // Execute the query
            resultSet = statement.executeQuery("SELECT * FROM Livre where isbn="+isbnL);
            int x=0;
            // Process the result set
            while (resultSet.next()) {
                x++;
                String column1Value = resultSet.getString("isbn");
                String column2Value = resultSet.getString("auteur");
                String column3Value = resultSet.getString("titre");
                String column4Value = resultSet.getString("annee");
                String column5Value = resultSet.getString("prix");
                // Display the data
                output=output+"\n"+("isbn: " + column1Value + ", auteur: " + column2Value+ ", titre: " + column3Value+ ", annee: " + column4Value+ ", prix: " + column5Value);
            }
            if (x==0) output="Livre introuvable";
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
        return output;
    }
	
}
	

