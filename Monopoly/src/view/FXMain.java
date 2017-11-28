package view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMain extends Application{

    @Override
    public void start(Stage primaryStage) {
        
        Parent home_page_parent = null;
        try {
          home_page_parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        Scene home_page_scene = new Scene(home_page_parent);
        primaryStage.setScene(home_page_scene);
        primaryStage.setTitle("Home Page");
        primaryStage.show();
        
    }
	

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
 }



