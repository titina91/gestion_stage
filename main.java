import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class main{

	public static void main(String[] args) {
		AbstraiteBD bd = new AbstraiteBD();
		ArrayList<String> attributs = new ArrayList<String>();
		attributs.add("nom");
		attributs.add("ville");		
		bd.readDatas("entreprise", attributs);
	}
	
}
