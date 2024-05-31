package app.login;

import app.system.PageController;
import app.tools.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterViewController extends PageController{
	@FXML
    private TextField emailInput;

    @FXML
    private PasswordField passwdInput;

    @FXML
    private TextField phoneInput;

    @FXML
    private TextField userNameInput;
    
    @FXML
    private Button btnHome;
    
    @FXML
    private Button btnRegistCarrier;

    @FXML
    private Button btnRegistRecipient;

    @FXML
    void btnRegistCarrierClick(ActionEvent event) throws Exception {
    	System.out.println("Handle Shipper Regist Action");
    	String userName = userNameInput.getText();
		String phoneNum = phoneInput.getText();
		String email = emailInput.getText();
		String password = passwdInput.getText();
		String userNameRegex = "[a-zA-Z]{4,}";
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		String phoneRegex = "\\d{10}"; // Matches a 10-digit phone number
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; // Matches a valid email address
		if (userName != null && phoneNum != null && email != null && password != null) {
			if (!userName.matches(userNameRegex)) {
	            DialogAlert.errorDialog("Fail Scanned", "User name must contain at least 4 alphabetic characters");
	            return; // Stop further processing if recipient name is invalid
	        }
			if (!password.matches(passwordRegex)) {
	            DialogAlert.errorDialog("Fail Registed", "Password must have at least one digit, one lowercase letter, one uppercase letter, one special character, no whitespace, and be at least 8 characters long the requirements");
	            return; // Stop further processing if password is invalid
	        }
			if (!phoneNum.matches(phoneRegex)) {
		        DialogAlert.errorDialog("Fail Registed", "Please enter a valid 10 dight phone number");
		        return; // Stop further processing if phone number is invalid
		    }
		    
		    // Validate email using regex
		    if (!email.matches(emailRegex)) {
		        DialogAlert.errorDialog("Fail Registed", "Please enter a valid email address");
		        return; // Stop further processing if email is invalid
		    }
			launchApp.getDatabase().addShipper(userName, phoneNum, email, password);
			boolean isGoToRecipientView = DialogAlert.showConfirmation("Successfully Registered", "Press OK to continue to shipper dashboard, press Cancel to return login view");
			if(isGoToRecipientView) {
				launchApp.showCarrierMainView();;
			}else {
				launchApp.showCarrLoginView();
			}
		}
		else {
			DialogAlert.errorDialog("Fail Registed", "Please enter all fields");
		}
    }

    @FXML
    void btnRegistRecipientClick(ActionEvent event) throws Exception {
    	System.out.println("Handle Receiver Regist Action");
    	String userName = userNameInput.getText();
		String phoneNum = phoneInput.getText();
		String email = emailInput.getText();
		String password = passwdInput.getText();
		String userNameRegex = "[a-zA-Z]{4,}";
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

		String phoneRegex = "\\d{10}"; // Matches a 10-digit phone number
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

		if (userName != null && phoneNum != null && email != null && password != null) {
			if (!userName.matches(userNameRegex)) {
	            DialogAlert.errorDialog("Fail Scanned", "User name must contain at least 4 alphabetic characters");
	            return; // Stop further processing if recipient name is invalid
	        }
			if (!password.matches(passwordRegex)) {
	            DialogAlert.errorDialog("Fail Registed", "Password must have at least one digit, one lowercase letter, one uppercase letter, one special character, no whitespace, and be at least 8 characters long the requirements");
	            return; // Stop further processing if password is invalid
	        }
			if (!phoneNum.matches(phoneRegex)) {
		        DialogAlert.errorDialog("Fail Registed", "Please enter a valid 10 dight phone number");
		        return; // Stop further processing if phone number is invalid
		    }
			
		    
		    // Validate email using regex
		    if (!email.matches(emailRegex)) {
		        DialogAlert.errorDialog("Fail Registed", "Please enter a valid email address");
		        return; // Stop further processing if email is invalid
		    }
			launchApp.getDatabase().addReceiver(userName, phoneNum, email, password);
			boolean isGoToRecipientView = DialogAlert.showConfirmation("Successfully Registered", "Press OK to continue to receiver dashboard, press Cancel to return login view");
			if(isGoToRecipientView) {
				launchApp.showRecipientMainView();
			}else {
				launchApp.showReciLoginView();
			}
		}
		else {
			DialogAlert.errorDialog("Fail Registed", "Please enter all fields");
		}
    }

	@Override
	@FXML
	public void btnReturnClick(ActionEvent event) throws Exception {
		// TODO Auto-generated method stub
		launchApp.showMainView();
	}
	@FXML
    void ClickHome(ActionEvent event) throws Exception {
    	launchApp.showMainView();
    }
}




