package View;
	
import Controler.AdminControler;
import Controler.LoginControler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	static LoginControler lc = new LoginControler();
	static AdminControler ac = new AdminControler();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			/*
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("View/login.fxml"));
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			scene.setRoot(root);
			//primaryStage.setResizable(false);
			primaryStage.show();
			*/
			
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/adminScene.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
