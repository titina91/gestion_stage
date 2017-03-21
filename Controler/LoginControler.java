package Controler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import metier.Entreprise;
import metier.Etudiant;
import metier.User;
import metier.connexion;

public class LoginControler implements interfaceControler{

	@FXML
	Button loginButton = new Button();
	@FXML
	TextField idField = new TextField();
	@FXML
	PasswordField passwrdField = new PasswordField();
	
	ObservableList<String> options = 
		    FXCollections.observableArrayList(
		        "Option 1",
		        "Option 2",
		        "Option 3"
		    );
	@FXML
	final ComboBox stateBox = new ComboBox();
	
	
	Connection connection;
	int nulle = 0 ;
	boolean okNom = false;
	boolean okMail = false;
	boolean okMdp = false;
	User u = null;
	
	final String insertUser = "INSERT INTO `user` (`id`, `name`, `passwrd`, `tel`, `mail`) VALUES (?,?,?,?,?) ";
	final String lastElement = "SELECT id FROM `user` lIMIT 1 ";
	//final String insertStudent = "INSERT INTO `etudiant` (`id`, `name`, `passwrd`, `tel`, `mail`, `firstName`, `fill`, `lvl`) VALUES (" + "null" + ",?,?,?,?,?,?,?) ";
	
	public LoginControler(){
		connection = (Connection) connexion.connection();
		
		stateBox.setItems(options);
	}
	
	
	
	
	
	
	public void login(){
		loginButton.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String idText = idField.getText();
				String passwrdText = passwrdField.getText();
				
				PreparedStatement st = null;
				
				try {
					String search = "SELECT * FROM `etudiant` WHERE `id` = " + idText ;
					//String getUser = 
					st = connection.prepareStatement(search);
					//st.executeQuery();
					ResultSet rs = st.executeQuery();
					while(rs.next()){
						System.out.println(rs.getInt("id"));
						System.out.println(rs.getString("name"));
						System.out.println(rs.getInt("lvl"));
						
											}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				System.out.println(idText);
				System.out.println(passwrdText);
			}
			
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int createUser(String nom, String mdp, String t, String m){
		//User u = null;
		int lastId = 0;
		PreparedStatement st1 = null;
		PreparedStatement sta = null;

		try{
			
			try{
				sta = connection.prepareStatement(lastElement);
				ResultSet rs = (ResultSet)sta.executeQuery();
				while(rs.next()){
					lastId++;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}finally{
			System.out.println("lastId: " + lastId);
						
			try{
				st1 = connection.prepareStatement(insertUser);
				st1.setInt(1, lastId);
				st1.setString(2, nom);
				st1.setString(3, mdp);
				st1.setString(4, t);
				st1.setString(5, m);
				st1.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return lastId;
		}
		
		
	}
	

	public void createStudent(String nom, String mdp, String t, String m, String p, String f, int lvl){

		System.out.println("avant verification");
		try{
			Pattern patternNom = Pattern.compile("[a-zA-Z]");																					// vérifie que le nom de l'utilisateur ne comporte que des lettres uniquement
			Pattern patternMail = Pattern.compile("[a-zA-Z_0-9].@ (gmail.|hotmail.|yahoo.|outlook.|wanadoo.|laposte.|univ-evry.) fr|com");		// vérifie que l'adresse mail soit bien valide
			Pattern patternMdp = Pattern.compile("([a-zA-Z]" + "(" + nom + "|" + p + ")" + "[a-zA-Z])*");										// vérifie que le mot de passe ne contienne pas le nom ou prenom de l'utilisateur
			Matcher matcherNom = patternNom.matcher(nom);
			Matcher matcherMail = patternMail.matcher(m);
			Matcher matcherMdp = patternMdp.matcher(mdp);
			okNom = matcherNom.matches();
			okMail = matcherMail.matches();
			okMdp = matcherMdp.matches();
			
			//System.out.println(matcherNom.group());
		}catch(PatternSyntaxException pse){
			System.out.println("erreur au niveau du mail");
			pse.printStackTrace();
		}
		System.out.println("apres verification");
		System.out.println("okNom: " + okNom);
		System.out.println("okMail: " + okMail);
		System.out.println("okMdp: " + okMdp);

		//if((okNom)&&(okMail)&&(okMdp)&&(!t.equals(""))&&(!f.equals(""))&&(!p.equals(""))&&(lvl>0)){
		if(true){
			/*
			System.out.println(u.getId());
			System.out.println(u.getNom());
			System.out.println(u.getMdp());
			System.out.println(u.getTel());

			 */
			PreparedStatement st1, st2 = null;
			try{
				
				int id = createUser(nom, mdp, t, m);
				System.out.println("Creation utilisateur reussi");
				
				final String insertStudent = "INSERT INTO `etudiant` (`id`, `name`, `passwrd`, `tel`, `mail`, `firstName`, `fill`, `lvl`) VALUES (" + id + ",?,?,?,?,?,?,?) ";

				
				st2 = connection.prepareStatement(insertStudent);
				//st2.setInt(1, u.getId());
				st2.setString(1, nom);
				st2.setString(2, mdp);
				st2.setString(3, t);
				st2.setString(4, m);
				st2.setString(5, p);
				st2.setString(6, f);
				st2.setInt(7, lvl);
				st2.executeUpdate();
				System.out.println("Creation utilisateur etudiant reussi");
				//ouverture d'une scene de confirmation
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		}
	}


	/*public User search(int id , String mdp, boolean w){
		User usr = null;

		PreparedStatement statement = null;
		String sql1 = "SELECT * FROM etudiant";
		String sql2 = "SELECT * FROM entreprise";
		System.out.println("avant");
		if(w == true){
			try{
				statement = connection.prepareStatement(sql1);
				ResultSet rs = (ResultSet) statement.executeQuery();
				System.out.println("Load...");
				while(rs.next()){
					if((rs.getInt("id") == id)&&((rs.getString("passwrd").equals(mdp)))){
						System.out.println("Connection en cours");
						System.out.println("Bonjour " + rs.getString("nom"));
						usr = new Etudiant(id, rs.getString("nom"), rs.getString("passwrd"),rs.getString("tel"), rs.getString("mail"), rs.getString("prenom"), rs.getString("filliaire"), rs.getInt("lvl"));
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else{
			try{
				statement = connection.prepareStatement(sql2);
				ResultSet rs = (ResultSet) statement.executeQuery();
				System.out.println("Load...");
				while(rs.next()){
					if((rs.getInt("id") == id)&&((rs.getString("passwrd").equals(mdp)))){
						System.out.println("Connection en cours");
						System.out.println("Bonjour " + rs.getString("nom"));
						usr = new Entreprise(id, rs.getString("nom"), rs.getString("passwrd"), rs.getString("ville"), rs.getString("rue"), rs.getInt("postal"), rs.getString("tel"), rs.getString("domaine"), rs.getString("mail"));
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return usr;
	}
	
	*/



	// fonction de connection et deconnection d'un utilisateur

	/*public void connect(int id, String mdp, boolean w){
		User user = search(id, mdp, w);
		user.setState();
	}
	*/



	@Override
	public void createCompany(String nom, String mdp, String v, String r, int p, String t, String d, String m) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeAllUsers(List<User> users) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addOffer() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeOffer() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void connect(int id, String mdp) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void search(int id) {
		// TODO Auto-generated method stub
		
	}


	//@Override
	/*public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	*/
}
