import java.util.*;

public abstract class User {
	
	private boolean connected = false;
	protected static int id;
	protected static String nom;
	protected static String mdp;
	
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
}
