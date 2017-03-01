

public class Etudiant extends User {
	private String prenom;
	private String filiaire;
	private int niveauEtude;
	
	
	public Etudiant(int id,String nom, String mdp, String p, String f, int lvl){
		super(id, nom, mdp);
		this.prenom = p;
		this.filiaire = f;
		this.niveauEtude = lvl;
	}

	public String getNom() {
		return nom;
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
