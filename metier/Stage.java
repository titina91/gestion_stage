package metier;
import java.util.*;

public class Stage {
	private int idStage;
	private String nomEntreprise;
	private String intitule;
	private String descriptif;
	private String domaine;
	private String dateDebut;
	private int duree;
	private int niveauRequis;
	private int placeDispo;
	
	public Stage(int id, String ne, String inti, String desc, String dom, String deb, int dur, int lvl, int place){
		this.idStage = id;
		this.nomEntreprise = ne;
		this.intitule = inti;
		this.descriptif = desc;
		this.domaine = dom;
		this.dateDebut = deb;
		this.duree = dur;
		this.niveauRequis = lvl;
		this.placeDispo = place;
	}

	public int getIdStage() {
		return idStage;
	}

	public void setIdStage(int idStage) {
		this.idStage = idStage;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getNiveauRequis() {
		return niveauRequis;
	}

	public void setNiveauRequis(int niveauRequis) {
		this.niveauRequis = niveauRequis;
	}

	public int getPlaceDispo() {
		return placeDispo;
	}

	public void setPlaceDispo(int placeDispo) {
		this.placeDispo = placeDispo;
	}
	
}
