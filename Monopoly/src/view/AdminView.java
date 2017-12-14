package view;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminView implements Initializable{

	
	
	@FXML
	public void hundleAdd(ActionEvent event) throws IOException{
		
	  Parent home_page_parent = FXMLLoader.load(getClass().getResource("ManageQuestions.fxml"));
	    Scene home_page_scene = new Scene(home_page_parent);
	    
	    Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
	    app_stage.hide();
	    app_stage.setScene(home_page_scene);
	    app_stage.setTitle("Monopoly game by Rabbit team");
	    app_stage.show();


	}
	
	@FXML
	public void hundleUpdate(ActionEvent event) throws IOException{
		
	  Parent home_page_parent = FXMLLoader.load(getClass().getResource("editquestion.fxml"));
	    Scene home_page_scene = new Scene(home_page_parent);
	    
	    Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
	    app_stage.hide();
	    app_stage.setScene(home_page_scene);
	    app_stage.setTitle("Monopoly game by Rabbit team");
	    app_stage.show();


	}
	
	@FXML
	public void hundleRemove(ActionEvent event) throws IOException{
		
	  Parent home_page_parent = FXMLLoader.load(getClass().getResource("removequestion.fxml"));
	    Scene home_page_scene = new Scene(home_page_parent);
	    
	    Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
	    app_stage.hide();
	    app_stage.setScene(home_page_scene);
	    app_stage.setTitle("Monopoly game by Rabbit team");
	    app_stage.show();


	}
	
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
