import java.util.*;

public class Etudiant {
	private int idEtudiant;
	private String nom;
	private String prenom;
	private String filiaire;
	private int niveauEtude;
	
	public Etudiant(int i, String n, String p, String f, int lvl){
		this.idEtudiant = i;
		this.nom = n;
		this.prenom = p;
		this.filiaire = f;
		this.niveauEtude = lvl;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFiliaire() {
		return filiaire;
	}

	public void setFiliaire(String filiaire) {
		this.filiaire = filiaire;
	}

	public int getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(int niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
}
