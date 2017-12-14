package view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



import control.AdminControl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	@FXML
	private Pane OneAnswer;
	@FXML
	private RadioButton ans1;
	@FXML
	private RadioButton ans2;
	@FXML
	private RadioButton ans3;
	@FXML
	private RadioButton ans4;
	@FXML
	private ToggleGroup group;
	@FXML
	private ListView<String> ListSubjects;
	@FXML
	private TextField ID;
	@FXML
	private TextField Question;
	@FXML
	private TextField a1;
	@FXML
	private TextField a2;
	@FXML
	private TextField a3;
	@FXML
	private TextField a4;
	@FXML
	private TextField OneAns;
	
	/**
	 * get answers if multiple
	 * */
	@FXML
	public void hundleMultiple(ActionEvent event) throws IOException{
		if(IsMultipleChoice.isSelected()) {
			AnsPane.setVisible(true);
			OneAnswer.setVisible(false);
			ans1.setVisible(true);
			ans2.setVisible(true);
			ans3.setVisible(true);
			ans4.setVisible(true);
		}
		else {
			AnsPane.setVisible(false);
			OneAnswer.setVisible(true);
			ans1.setVisible(false);
			ans2.setVisible(false);
			ans3.setVisible(false);
			ans4.setVisible(false);
		}
	}
	
	/**
	 * fill list of subjects
	 * */
	@FXML
	public void hundleSubjects(ActionEvent event) throws IOException{
		ObservableList<String> sub = ListSubjects.getItems();
		if(!sub.contains(subjects.getValue().toString())){
		sub.add(subjects.getValue().toString());
		ListSubjects.setItems(sub);
		}
	}
	/**
	 * 
	 * fields validation and insert
	 * */
	@FXML
	public void hundleAdd(ActionEvent event) throws IOException{
		int id = Integer.parseInt(ID.getText());
		String q = Question.getText();
		int diff = Integer.parseInt(level.getValue().toString());
		boolean isMulti = IsMultipleChoice.isSelected();
		ListSubjects.getItems();
		List<String> su = ListSubjects.getItems();
	    ArrayList<String> showing = new ArrayList<String>();
	    for(String s: ListSubjects.getItems() ) {
	    	showing.add(s);
	    }
		if(isMulti) {
		
			if(AdminControl.addQuestion(id, null, q, diff, isMulti, AdminControl.CreateAns(a1.getText(),ans1.isSelected()),
					AdminControl.CreateAns(a2.getText(),ans2.isSelected()),
					AdminControl.CreateAns(a3.getText(),ans3.isSelected()),
					AdminControl.CreateAns(a4.getText(),ans4.isSelected()), showing)) 
				AlertSuccess();
			else 
				AlertFailure();
		}
		else {
			if(AdminControl.addQuestion(id, null, q, diff, isMulti, AdminControl.CreateAns(OneAns.getText(),true),
					null,
					null,
					null, showing)) 
				AlertSuccess();
			else
				AlertFailure();
		}
	}
	@FXML
	public void AlertSuccess() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Question Added Successfully!");

		alert.showAndWait();
		
	}
	@FXML
	public void AlertFailure() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Can't Add Question!");

		alert.showAndWait();
	}
	
	/**
	 * 
	 * field validation
	 * */
	@FXML
	public void Validate(ActionEvent event) throws IOException{
		ID.textProperty().addListener(new ChangeListener<String>() {
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        if (!newValue.matches("\\d*")) {
		            ID.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		subjects.getItems().addAll(AdminControl.getSubjects());
		level.getItems().addAll("1", "2", "3");
		AnsPane.setVisible(false);
		OneAnswer.setVisible(true);
		 group=new ToggleGroup();
		 ans1.setToggleGroup(group);
		 ans2.setToggleGroup(group);
		 ans3.setToggleGroup(group);
		 ans4.setToggleGroup(group);
		 ID.textProperty().addListener(new ChangeListener<String>() {
			    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			        if (!newValue.matches("\\d*")) {
			            ID.setText(newValue.replaceAll("[^\\d]", ""));
			        }
			    }
			});
	}

}
