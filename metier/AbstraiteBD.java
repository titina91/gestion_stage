package metier;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class AbstraiteBD implements interfaceBD{

	// ajouter des données dans une table de la base de donnee
	
	String url=  "jdbc:mysql://localhost/gestion offres stage";												// values = {"val1 ,", "val2,", "val3,",...}*
	String login = "root";
	String passwd = "";	
	
	public void addData(String table, String attributs, String values){									// attributs = {"att1 ,", "att2,", "att3,",...}*
		Connection cn = null;
		Statement st = null;
		try{
			// chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// recuperation de la connection
			cn = (Connection)DriverManager.getConnection(url, login, passwd);
			// creation d'un statement
			st = (Statement)cn.createStatement();
			String sql = "INSERT INTO " + table + " (" + attributs + ") VALUES (" + values + ");";
			System.out.println("insertion reussis");
			// execution de la requete
			st.executeUpdate(sql);
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			// liberer ressource de la mémoire
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	// lire des donnees d'une base de donnee
	
	public void readData(String table, String attribut){
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, login, passwd);
			st = (Statement)cn.createStatement();
			String sql = "SELECT " + attribut + " FROM " + table;
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString(attribut));
			}
			
		}catch(SQLException | ClassNotFoundException e){
			System.out.println("la requête a échoué");
			e.printStackTrace();;
			
		}finally{
			try{
				cn.close();
				st.close();
			}catch(SQLException e){
				e.printStackTrace();;
			}
		}
	}
	
	public void readDatas(String table, ArrayList<String> attributs){
		for(String s:attributs){
			System.out.println("/***********************/");
			readData(table, s);
			
		}
	}
	
	public void update(){
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, login, passwd);
			st = (Statement) cn.createStatement();
			String sql = "UPDATE javadb SET prenom = 'm' WHERE personne = Tina" ;
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}




