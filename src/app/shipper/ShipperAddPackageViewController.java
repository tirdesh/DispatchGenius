package app.shipper;

import app.model.Shipper;
import app.system.*;
import app.tools.Database;
import app.tools.DialogAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ShipperAddPackageViewController extends PageController{
	
	@FXML
    private Button btnConfirm;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnReturn;

    @FXML
    private TextField receiverNameInput;

    @FXML
    private TextField trackNumInput;
    
    private Shipper shipper; // Add a field to store the shipper name

    public ShipperAddPackageViewController() {
    }
    
    // Constructor to receive the shipper name
    public ShipperAddPackageViewController(Shipper shipper) {
        this.shipper = shipper;
    }
    
    @FXML
    void btnConfirmClick(ActionEvent event) throws Exception {
    	System.out.println("Handle Shipper Scan Package Action");
    	String receiverName = receiverNameInput.getText();
		String trackNum = trackNumInput.getText();
		String trackNumRegex = "[a-zA-Z]{3}\\d{3}";
	    String receiverNameRegex = "[a-zA-Z]{4,}";
		if (receiverName != null && trackNum != null) {
			if (!trackNum.matches(trackNumRegex)) {
	            DialogAlert.errorDialog("Fail Scanned", "Tracking number must contain 3 alphabets followed by 3 digits");
	            return; // Stop further processing if tracking number is invalid
	        }
	        if (!receiverName.matches(receiverNameRegex)) {
	            DialogAlert.errorDialog("Fail Scanned", "Recipient name must contain at least 4 alphabetic characters");
	            return; // Stop further processing if recipient name is invalid
	        }
			Database.addShipment(trackNum, receiverName, shipper);
			boolean isContinue = DialogAlert.showConfirmation("Successfully Scanned", "Press OK to continue, press Cancel to return");
			if(isContinue) {
				launchApp.showCarrierAddPacView();
			}else {
				launchApp.showCarrierMainView();
			}
		}
		else {
			DialogAlert.errorDialog("Fail Scanned", "Please enter all fields");
		}
    }

    @Override
    @FXML
	public void btnReturnClick(ActionEvent event) throws Exception {
    	launchApp.showCarrierMainView();
    }
    
}
