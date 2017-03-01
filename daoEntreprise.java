import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class daoEntreprise implements implementsEntreprise{

	Connection connection;
	final String insert = " INSERT INTO stage (idStage, intitule, descriptif, domaine, debut, duree, lvl, nomE, place) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	final String update = " UPDATE stage set idStage=? , intitule=?, descriptif=?, domaine=?, debut=?, duree=?, lvl=?, nomE=?, place=?;";
	final String delete = " DELETE FROM stage WHERE idStage=?;";
	final String select = " SELECT * FROM stage;";


	public daoEntreprise(){
		connection = (Connection) connexion.connection();
	}


	public void deposerOffre(Stage s) {

		PreparedStatement statement = null;
		try{
			statement = connection.prepareStatement(insert);
			statement.setInt(1, s.getIdStage());
			statement.setString(2, s.getIntitule());
			statement.setString(3, s.getDescriptif());
			statement.setString(4, s.getDomaine());
			statement.setString(5, s.getDateDebut());
			statement.setInt(6, s.getDuree());
			statement.setInt(7, s.getNiveauRequis());
			statement.setString(8, s.getNomEntreprise());
			statement.setInt(9, s.getPlaceDispo());
			statement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}


	public void supprimerOffre(int id) {

		PreparedStatement statement = null;
		try{
			statement = connection.prepareStatement(delete);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}


	public void search(ArrayList<String> list) {

	}

	public void connect(int id, String passwrd){
		PreparedStatement statement = null;
		String sql = "SELECT * FROM entreprise";
		System.out.println("avant");
		
		try{
			statement = connection.prepareStatement(sql);
			ResultSet rs = (ResultSet) statement.executeQuery();
			System.out.println("Load...");
			while(rs.next()){
				if((rs.getInt("idEntreprise") == id)&&(rs.getString("passwrd")).equals(passwrd)){
					System.out.println("Connection en cours");
					System.out.println("Bonjour " + rs.getString("nom"));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}














/*
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
				g.printStackTrace();
			}
		}

	}

	public void supprimerOffre(Stage s) {
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
				g.printStackTrace();
			}
		}
	}

	@Override
	public void search(ArrayList<String> list) {

	}
 */

}
