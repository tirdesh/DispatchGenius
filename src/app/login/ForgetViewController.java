package app.login;

import app.model.*;
import app.system.PageController;
import app.tools.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ForgetViewController extends PageController{
	@FXML
    private Button btnHome;

    @FXML
    private Button btnReturn;

    @FXML
    private Label txtPasswd;

    @FXML
    private TextField userNameInput;
    
    @FXML
    private Button btnFind;
    
    @FXML
    private Button btnReset;

    @Override
    @FXML
    public void btnReturnClick(ActionEvent event) throws Exception {
    	launchApp.showReciLoginView();
    }
    
    @FXML
    void btnFindClick(ActionEvent event) {
    	String userName = userNameInput.getText();
		if(userName == null) {
	        DialogAlert.showMessage("No username input", "Please enter your name", AlertType.WARNING);
		}else {
			Receiver receiver = Database.findRecipient(userName);
			Shipper shipper = Database.findCarrier(userName);
			if(receiver == null && shipper == null) {
	            DialogAlert.showMessage("No this user", "Please enter your name correctly", AlertType.WARNING);
			}else {
				String passwd = (receiver != null)? Database.getRecipientPassword(receiver) : Database.getCarrierPassword(shipper);
				txtPasswd.setText("Your password is " + passwd);
			}			
		}
    }
    
    @FXML
    void btnResetClick(ActionEvent event) {
    	
    }
}




