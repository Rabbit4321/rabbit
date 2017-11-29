package view;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Game;

public class HomePageController {
	
/////////////Buttons///////////////////////////////Fields////////////

/*@FXML
private Button newGame_btn;

@FXML
private Button pscores_btn;
@FXML
private Button gameRoles_btn;
@FXML
private Button admin_btn;*/


///////////HandleButtons//////////////Functions/////////////////////

@FXML
public void hundleBtnNewGame(ActionEvent event) throws IOException{

  Parent home_page_parent = FXMLLoader.load(getClass().getResource("BoardGame1.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    
    Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
    app_stage.hide();
    app_stage.setScene(home_page_scene);
    app_stage.setTitle("Monopoly game by Rabbit team");
    app_stage.show();


}

public void initialize(URL url, ResourceBundle rb) {

	
}
}
