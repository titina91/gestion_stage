package metier;
import java.util.ArrayList;

public class Entreprise  extends User implements implementsEntreprise{
	
	private String ville;
	private String rue;
	private int postale;
	private String tel;
	private String domaine;
	private String mail;
	daoEntreprise dao = new daoEntreprise();

	public Entreprise( int id, String nom, String mdp, String v, String r, int p, String t, String d, String m){
		super(id, nom, mdp, t, m);
		this.ville = v;
		this.rue = r;
		this.postale = p;
		this.tel = t;
		this.domaine = d;
		this.mail = m;
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

	public void deposerOffre(Stage s) {
		dao.deposerOffre(s);
	}

	public void supprimerOffre(int id) {
		dao.supprimerOffre(id);
	}

	public void search(ArrayList<String> list) {
		dao.search(list);
	}

	public void connect(int i, String passwrd) {
		dao.connect(i, passwrd);
		setState();
	}

	
}
