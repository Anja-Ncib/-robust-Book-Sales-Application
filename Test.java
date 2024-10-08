package p1;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		LinkDataBase l= new LinkDataBase();
		l.getLink();
		System.out.println("------------------------------------------------------------------");
		Utilisateur u=new Utilisateur("admin","abc123");
		u.consulterLivres();
		System.out.println("------------------------------------------------------------------");
		u.consulterLivre("9780141030951");
		System.out.println("------------------------------------------------------------------");
		Livre l1=new Livre("9090111038751","anja ncib","escape the ordinary",2024,20);
		Administrateur admin=new Administrateur("anja","1234");
		//admin.ajouterLivre(l1);
		System.out.println("------------------------------------------------------------------");
		u.consulterLivres();
		System.out.println("------------------------------------------------------------------");
		//admin.supprimerLivre("9780141030951");
		System.out.println("------------------------------------------------------------------");
		u.consulterLivres();
		System.out.println("------------------------------------------------------------------");
		Client c=new Client("Client1","c254mn");
		System.out.println(c.livresCommande());
		System.out.println("------------------------------------------------------------------");
		c.commanderLivre("9782221116110");
		System.out.println("------------------------------------------------------------------");
		System.out.println(c.livresCommande());
	}

}
