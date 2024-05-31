package app.login;

import app.system.PageController;
import app.tools.*;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class AdminLoginViewController extends PageController{


    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogin;


    @FXML
    private Button btnReturn;

    @FXML
    private Label errorInfoLabel;

    @FXML
    private PasswordField passwdInput;

    @FXML
    private TextField userNameInput;
    
    @FXML
    void ClickForget(ActionEvent event) throws Exception {
    	launchApp.showForgetView();
    }

    @FXML
    void ClickLogin(ActionEvent event) throws Exception {
    	String userName = userNameInput.getText();
		String password = passwdInput.getText();
		
		if (Database.checkAdminValid(userName, password)) {
			DialogAlert.showMessage("Successfull Login", "Loading Admin Dashboard", AlertType.INFORMATION);
			launchApp.showAdminMainView();
		}
		else {
			errorInfoLabel.setText("Incorrect username or password");
			userNameInput.clear();
			passwdInput.clear();
			FadeTransition ft = new FadeTransition();
			ft.setDuration(Duration.seconds(0.1));
			ft.setNode(launchApp.getCurrentScene().getRoot());
			ft.setFromValue(0);
			ft.setToValue(1);
			ft.play();
		}
    }

    @FXML
    void ClickRegist(ActionEvent event) throws Exception {
    	try {
    		launchApp.showRegistView();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void ClickHome(ActionEvent event) throws Exception {
    	launchApp.showMainView();
    }
    
    @Override
    @FXML
    public void btnReturnClick(ActionEvent event) throws Exception {
    	launchApp.showMainView();
    }
}




