package app.shipper;

import app.model.*;
import app.system.PageController;
import app.tools.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ShipperChangeStatusViewController extends PageController{
	
	ObservableList<String> choices = FXCollections.observableArrayList("Scan and scen to storage", "Ready to Shipment", "On the way", "Arrived"); 

	@FXML
    private Button btnHome;

    @FXML
    private Button btnReturn;
    
    @FXML
    private Button btnConfirm;

    @FXML
    private ChoiceBox<String> choiceStatus;

    @FXML
    private TextField trackNumInput;
    
    @FXML
    private Label statusInfo;
    
    
    @FXML
    public void initialize() {
    	choiceStatus.setItems(choices);
    }
    
    @Override
    @FXML
    public void btnReturnClick(ActionEvent event) throws Exception {
    	launchApp.showCarrierMainView();
    }
    
    @FXML
    void btnConfirmClick(ActionEvent event) {
    	String trscNum = trackNumInput.getText();
    	Shipment shipment = Database.findDelivery(trscNum);
    	if (shipment == null) {
    		statusInfo.setText("Wrong track number!");
    	}
    	else {
    		String choose = choiceStatus.getSelectionModel().getSelectedItem(); 
    		if (choose != null) {
            	statusInfo.setText("Your choice is " + choose);
    		}
        	shipment.setStatus(choose);
    	}	
    }       
}




