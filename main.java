import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class main{

	public static void main(String[] args) {
		AbstraiteBD bd = new AbstraiteBD();

		/*	test la lecture des valeurs d'attributs en fonction d'une ArrayList d'attributs
		 * 
		 * 		ArrayList<String> attributs = new ArrayList<String>();
		 * 		attributs.add("nom");
		 * 		attributs.add("ville");		
		 * 		bd.readDatas("entreprise", attributs);
		 * 
		 */


		//	test la creation d'une offre de stage à partir de l'entreprise
		  
		  		//Entreprise(int i, String n, String v, String r, int p, String t, String d, String m)
		  		Entreprise entreprise = new Entreprise(4, "nom", "ville", "rue", 91150, "tel", "domaine", "mail");
		  
		  
		  		//Stage(int id, String ne, String inti, String desc, String dom, String deb, int dur, int lvl, int place)
		  		Stage stage = new Stage(12345, "stage de ouf", "intitulté", "description", "domaine", "05/05/2017", 4, 3, 2);
		  		entreprise.deposerOffre(stage);
		  
		  
		 
		
		/*	test la suppression d'une offre de stage à partir d'une idStage
		 * 
		 * 		//Entreprise(int i, String n, String v, String r, int p, String t, String d, String m)
		 * 		Entreprise entreprise = new Entreprise(4, "nom", "ville", "rue", 91150, "tel", "domaine", "mail");
		 * 
		 * 
		 * 		//Stage(int id, String ne, String inti, String desc, String dom, String deb, int dur, int lvl, int place)
		 * 		Stage stage = new Stage(41, "nomE", "intitulté", "description", "domaine", "05/05/2017", 4, 3, 2);
		 * 		entreprise.supprimerOffre(41);
		 * 
		 * 
		 */





	}

}
