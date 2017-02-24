
public class Entreprise extends daoEntreprise{
	private int id;
	private String nom;
	private String ville;
	private String rue;
	private int postale;
	private String tel;
	private String domaine;
	private String mail;
	
	public Entreprise(int i, String n, String v, String r, int p, String t, String d, String m){
		this.id = i;
		this.nom = n;
		this.ville = v;
		this.rue = r;
		this.postale = p;
		this.tel = t;
		this.domaine = d;
		this.mail = m;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getPostale() {
		return postale;
	}

	public void setPostale(int postale) {
		this.postale = postale;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
