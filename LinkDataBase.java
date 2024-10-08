package p1;
import java.sql.*;
import java.sql.DriverManager;
public class LinkDataBase {
	public static Connection getLink() throws ClassNotFoundException {
		String dbName="TPArchi";
		String login="root";
		String mdp="0000";
		String url="jdbc:mysql://127.0.0.1:3306/"+dbName;
		Connection c=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection(url,login,mdp);
		}
		catch (ClassNotFoundException e) {
        // Handle the case where the JDBC driver is not found
        System.err.println("MySQL JDBC driver not found.");
        e.printStackTrace();
		}
		catch (SQLException e){
			System.out.println("Probleme de connexion a la base"+dbName);
			e.printStackTrace();
		}
		if (c!=null) System.out.println("connection etablie");
		return c;
		
	}
}
