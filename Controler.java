import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controler {
	
	Connection connection = null;
	
	
	
	
	

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
		User user = search(id, mdp, w);
		user.setState();
	}
}
