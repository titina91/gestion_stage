package DAOpackage;

import java.sql.Connection;

public abstract class DAO<T> {

	protected Connection connect = null;
	
	public DAO(Connection c){
		this.connect = c;
	}
	
	// méthode abstraite pour créer un élement
	public abstract <O> void create(O o);
	
	// méthode abstraite pour créer un élement
	public abstract <O> void remove(O o);
	
	// méthode abstraite pour mettre à jour un élement
	public abstract <O> void update(O o);
	
	// méthode abstraite pour trouver un élement à partir d'un id
	public abstract <O> O find(int id);

}
