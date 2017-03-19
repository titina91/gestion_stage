package metier;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class daoEtudiant {
	
	Connection connection;

	public daoEtudiant(){
		connection = (Connection) connexion.connection();
	}
	
}
