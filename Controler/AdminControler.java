package Controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import metier.Etudiant;
import metier.connexion;

public class AdminControler {

	
	// Déclaration des objets utilisés
	
	@FXML
	Button createUserBtn = new Button();
	@FXML
	Button showUserBtn = new Button();
	@FXML
	Button showStudentBtn = new Button();
	@FXML
	Button showCompanyBtn = new Button();
	@FXML
	Button showOfferBtn = new Button();
	@FXML
	Button showDemandBtn = new Button();
	@FXML
	TableColumn idColumn = new TableColumn();
	@FXML
	private TableView<Etudiant> studentTableView = new TableView<Etudiant>();
	
	private final ObservableList<Etudiant> studentData =
			FXCollections.observableArrayList();

	Connection connection;
	ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
	
	// vérifie si les données ont déjà été chargé dans les tables

	boolean studentLoad = false;
	boolean userLoad = false;
	boolean companyLoad = false;
	
	
	// Comportements provoqués par les boutons
	
	public void showStudent(){
		showStudentBtn.setOnAction(new EventHandler<ActionEvent>(){

			public void handle(ActionEvent event) {
				System.out.println("test");
				PreparedStatement st = null;
				connection = (Connection) connexion.connection();

				String loadStudent = "SELECT * FROM `etudiant`";
				
				try{
					st = connection.prepareStatement(loadStudent);
					ResultSet rs = st.executeQuery();
					studentTableView.setItems(studentData);
					while(rs.next()){
						//Etudiant(int id,String nom, String mdp, String tel, String mail, String p, String f, int lvl)
						studentData.add(new Etudiant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
						System.out.println(rs.getInt(1));
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
				studentTableView.getItems().addAll(etudiants);
				 
			}

		});
	}

}
