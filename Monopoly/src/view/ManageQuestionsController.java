package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import control.AdminControl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ManageQuestionsController implements Initializable{
	
	@FXML
    private ComboBox subjects ;
	
	/**
	 * get all subjects for questions
	 * */
	public void hundleSubjects(ActionEvent event) throws IOException{
	ObservableList obList = FXCollections.observableArrayList(AdminControl.getSubjects());
	subjects.getItems().clear();
	subjects.setItems(obList);
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
