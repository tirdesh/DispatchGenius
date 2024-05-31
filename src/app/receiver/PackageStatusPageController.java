package app.receiver;

import app.model.Shipment;
import app.system.PageController;
import app.tools.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PackageStatusPageController extends PageController{
	
	@FXML
    private Button btnConfirm;

    @FXML
    private Button btnHome;

    @FXML
    private Label btnReplyMessage;

    @FXML
    private TextField trackingNumInput;
    
    @FXML
    private Button btnReturn;
    

    @FXML
    void ClickComfirm(ActionEvent event) {
    	String trackNum = trackingNumInput.getText();
    	Shipment shipment = Database.findDelivery(trackNum);
    	if (shipment == null ) {
    		btnReplyMessage.setText("Oops! Cannot find your package, please check tracking number.");	
    	}
    	else {
    		boolean signed = shipment.isSigned();
    		String status = shipment.getStatus();
    		if (signed) {
    			btnReplyMessage.setText("Your package has bees signed! If you have any problem, please click Confirm & Help.");
    		}
    		else {
    			btnReplyMessage.setText("Your package is on the way! Status is : " + status);	
    		}	
    	}
    }
    
    @Override
    @FXML
	public void btnReturnClick(ActionEvent event) throws Exception {
    	launchApp.showRecipientMainView();
    }
}
