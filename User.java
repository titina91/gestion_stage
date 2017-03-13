import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public abstract class User {

	private boolean connected = false;
	protected static int id;
	protected static String nom;
	protected static String mdp;
	
	static Connection connection = null;

	public User(int i, String n, String m){
		this.id = i;
		this.nom = n;
		this.mdp = m;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id; 
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public boolean getState(){
		return connected;
	}
	public void setState(){
		connected = !connected;
	}
	public void creatStudent( String name, String mdp, String fname, String f, int lvl, String passwrd){

		int nulle = (Integer) null;
		Etudiant etu = new Etudiant(nulle, name, mdp, passwrd, f, lvl);
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;

		String sql1 = "INSERT INTO `User`(`Id`, `Name`) VALUES ( null ," + name + "])";
		String sql2 = "INSERT INTO `etudiant`(`id`, `nom`, `prenom`, `fill`, `lvl`, `passwrd`) VALUES (" + "null" + "," + name + "," + fname + "," + f + "," + lvl + "," + lvl + ", " + passwrd + ")";

		try{
			statement1 = connection.prepareStatement(sql1);
			statement2 = connection.prepareStatement(sql2);
			ResultSet rs1 = (ResultSet) statement1.executeQuery();
			ResultSet rs2 = (ResultSet) statement2.executeQuery();
			System.out.println("creation...");

		}catch(SQLException e){
			e.printStackTrace();
		}
		//return etu;
	}
}
