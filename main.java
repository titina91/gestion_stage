import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class main{

	Connection connection;
	User user = null;
	public static void main(String[] args) {
		AbstraiteBD bd = new AbstraiteBD();

		Stage stage = new Stage(41, "nomE", "intitulté", "description", "domaine", "05/05/2017", 4, 3, 2);
		Entreprise entreprise = new Entreprise(1, "nom", "google", "ville", "rue", 91150, "tel", "domaine", "mail");
		//entreprise.deposerOffre(stage);
		//connect(1,"google");
		//connect(1,"mdp", true);

	}


	// fonction de recherche d'un utilisateur dans la base de donnée

	public User search(int id , String mdp, boolean w){
		User usr = null;

		PreparedStatement statement = null;
		String sql1 = "SELECT * FROM etudiant";
		String sql2 = "SELECT * FROM entreprise";
		System.out.println("avant");
		if(w == true){
			try{
				statement = connection.prepareStatement(sql1);
				ResultSet rs = (ResultSet) statement.executeQuery();
				System.out.println("Load...");
				while(rs.next()){
					if((rs.getInt("id") == id)&&((rs.getString("passwrd").equals(mdp)))){
						System.out.println("Connection en cours");
						System.out.println("Bonjour " + rs.getString("nom"));
						usr = new Etudiant(id, rs.getString("nom"), rs.getString("passwrd"), rs.getString("prenom"), rs.getString("filliaire"), rs.getInt("lvl"));
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else{
			try{
				statement = connection.prepareStatement(sql2);
				ResultSet rs = (ResultSet) statement.executeQuery();
				System.out.println("Load...");
				while(rs.next()){
					if((rs.getInt("id") == id)&&((rs.getString("passwrd").equals(mdp)))){
						System.out.println("Connection en cours");
						System.out.println("Bonjour " + rs.getString("nom"));
						usr = new Entreprise(id, rs.getString("nom"), rs.getString("passwrd"), rs.getString("ville"), rs.getString("rue"), rs.getInt("postal"), rs.getString("tel"), rs.getString("domaine"), rs.getString("mail"));
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return usr;
	}



	// fonction de connection et deconnection d'un utilisateur

	public void connect(int id, String mdp, boolean w){
		user = search(id, mdp, w);
		user.setState();

	}
}
