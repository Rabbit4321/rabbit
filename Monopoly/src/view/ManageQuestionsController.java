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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ManageQuestionsController implements Initializable{
	
	@FXML
    private ComboBox subjects ;
	@FXML
	private ComboBox level ;
	@FXML
	private CheckBox IsMultipleChoice;
	@FXML
	private Pane AnsPane;
	
	/**
	 * get answers if multiple
	 * */
	
	public void hundleMultiple(ActionEvent event) throws IOException{
		if(IsMultipleChoice.isSelected())
			AnsPane.setVisible(true);
		else
			AnsPane.setVisible(false);
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	//	subjects.getItems().removeAll(subjects.getItems());
		subjects.getItems().addAll(AdminControl.getSubjects());
	//	level.getItems().removeAll(level.getItems());
		level.getItems().addAll("1", "2", "3");
		AnsPane.setVisible(false);
	}

}
