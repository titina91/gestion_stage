package metier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class User {

	private boolean connected = false;
	private int id;
	private String nom;
	private String mdp;
	private String tel;
	private String mail;
	
	Connection connection = null;

	public User(int i, String n, String m, String t, String ml){
		this.id = i;
		this.nom = n;
		this.mdp = m;
		this.tel = t;
		this.mail = ml;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
	
}
