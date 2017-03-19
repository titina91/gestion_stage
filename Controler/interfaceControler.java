package Controler;

import java.util.List;
import metier.User;

public interface interfaceControler {
	
	public void createStudent(String nom, String mdp, String t, String m, String p, String f, int lvl);
	public void createCompany( String nom, String mdp, String v, String r, int p, String t, String d, String m);
	public void deleteUser(int id);
	public void removeAllUsers(List<User> users);
	public void addOffer();
	public void removeOffer();
	public void connect(int id, String mdp);
	public void search(int id);
}
