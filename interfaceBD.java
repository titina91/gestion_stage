import java.util.*;

public interface interfaceBD {
	
	public void addData(String in, String attributs, String values );					/* in = table concerné
																						 *
																						 * attributs = ensembles des attributs de la table dont on souhaite
																						 *			   donner une valeur
																						 *
	 																					 * values = ensembles des valeurs a attribuer
	 																					 */
	
	public void readData(String in, String attributs );									/* in = table concerné
	 																					 *
	 																					 * attributs = ensembles des attributs de la table dont on souhaite
	 																					 *			   donner une valeur
	 																					 *
	 																					 * values = ensembles des valeurs a attribuer
	 																					 */
	
	public void update();


}
