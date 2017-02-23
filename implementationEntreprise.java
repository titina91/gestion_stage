import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class implementationEntreprise implements interfaceEntreprise {

	
	public implementationEntreprise(){
		
	}
	public void deposerOffre(Stage s) {
		String url=  "jdbc:mysql://localhost/gestion offre stage";												// values = {"val1 ,", "val2,", "val3,",...}*
		String login = "root";
		String passwd = "";
		
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// recuperation de la connection
			cn = (Connection)DriverManager.getConnection(url, login, passwd);
			// creation d'un statement
			st = (Statement)cn.createStatement();
		 	String sql = "INSERT INTO `stage` (`idStage`, `intitule`, `descriptif`, `domaine`, `debut`, `duree`, `lvl`, `nomE`, `place`) VALUES (NULL, '" + s.getIntitule() + "', '" + s.getDescriptif() + "', '" + s.getDomaine() +"', '" + s.getDateDebut() + "', '" + s.getDuree() + "', '" + s.getNiveauRequis() + "', '" + s.getNomEntreprise() + "', '" + s.getPlaceDispo() + "');";
			
			// execute la requete
			st.executeUpdate(sql);
		}catch(SQLException | ClassNotFoundException f){
			f.printStackTrace();
		}finally{
			// liberer ressource de la mémoire
			try {
				cn.close();
				st.close();
			} catch (SQLException g) {
				// TODO Auto-generated catch block
				g.printStackTrace();
			}
		}
		
	}

	public void supprimerOffre(Stage s) {
		// TODO Auto-generated method stub
		String url=  "jdbc:mysql://localhost/gestion offre stage";												// values = {"val1 ,", "val2,", "val3,",...}*
		String login = "root";
		String passwd = "";
		
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// recuperation de la connection
			cn = (Connection)DriverManager.getConnection(url, login, passwd);
			// creation d'un statement
			st = (Statement)cn.createStatement();
			String sql = "DELETE FROM `stage` WHERE `idStage`= " + s.getIdStage() + ";";
			// execute la requete
			st.executeUpdate(sql);
		}catch(SQLException | ClassNotFoundException f){
			f.printStackTrace();
		}finally{
			// liberer ressource de la mémoire
			try {
				cn.close();
				st.close();
			} catch (SQLException g) {
				// TODO Auto-generated catch block
				g.printStackTrace();
			}
		}
	}

}
