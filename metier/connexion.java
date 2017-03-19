package metier;
import java.sql.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class connexion {
	
	static Connection con;
	
	public static Connection connection(){
		if(con == null){
			MysqlDataSource data = new MysqlDataSource();
			data.setDatabaseName("gestion offres stage");
			data.setUser("root");
			data.setPassword("");
			try{
				con = data.getConnection();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return con;
		
	}
}
