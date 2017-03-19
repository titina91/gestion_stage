package metier;

public class File {
	
	String id;				// id du fichier
	String name;			// nom de fichier
	String path;			// chemin d'accée au fichier
	boolean bool;			// true == simple 					false == CV
	String contain;			// contenu du fichier
	
	public File(String i, String n, String p, boolean b){
		this.id = i;
		this.name = n;
		this.path = p;
		this.bool = b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return name;
	}

	public void setNom(String nom) {
		this.name = nom;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
