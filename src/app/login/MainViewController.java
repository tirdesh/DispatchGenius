package app.login;

import app.system.PageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainViewController extends PageController{

    @FXML
    private Button btnCarrierLogin;

    @FXML
    private Button btnRecipientLogin;
    
    @FXML
    private Button btnAdminLogin;
	
    @FXML
    void btnCarrierLoginClick(ActionEvent event) throws Exception {
    	launchApp.showCarrLoginView();
    }

    @FXML
    void btnRecipientLoginClick(ActionEvent event) throws Exception {
    	launchApp.showReciLoginView();
    }
    @FXML
    void btnAdminLoginClick(ActionEvent event) throws Exception {
    	launchApp.showAdminLoginView();
    }

	@Override
	@FXML
	public void btnReturnClick(ActionEvent event) throws Exception {
		// TODO Auto-generated method stub	
	}
}

