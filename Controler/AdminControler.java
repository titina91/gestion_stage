package Controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import metier.Etudiant;

public class AdminControler {
	
	String loadStudent = "SELECT * FROM `etudiant`";

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
	TableView<Etudiant> studentTableView = new TableView<Etudiant>();
	@FXML
	TableColumn idColumn = new TableColumn();
	
	Connection connection = null;
	
	public void showStudent(){
		showUserBtn.setOnAction(new EventHandler<ActionEvent>(){

			public void handle(ActionEvent event) {

				PreparedStatement st = null;
				
				try{
					st = connection.prepareStatement(loadStudent);
					ResultSet rs = st.executeQuery(loadStudent);
					while(rs.next()){
						
					}
				}catch(SQLException e){
					
				}
			}
			
		});
	}
	
}
