package app.receiver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.Shipment;
import app.model.Shipper;
import app.system.PageController;
import app.tools.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import app.receiver.StarRatingControl;


public class RatePageController extends PageController {
    @FXML
    private Button btnLoginOut;

    @FXML
    private Button btnReturn;

    @FXML
    private Button btnSubmit;
    
    @FXML
    private Label btnMessage;
    
    @FXML
    private StarRatingControl starRatingControl;
    
    @FXML
    private ComboBox<String> shipperComboBox;
    
    @FXML
	protected void btnLoginOutClick(ActionEvent event) throws Exception {
    	launchApp.showMainView();
    }
    
    @Override
    @FXML
    public void btnReturnClick(ActionEvent event) throws Exception {
    	launchApp.showRecipientMainView();
	}
    
//    @FXML
//    void btnSubmitClick(ActionEvent event) {
//    	btnMessage.setText("Thank You !");
//	}

    @FXML
    void btnSubmitClick(ActionEvent event) {
    	
    	String selectedShipperName = shipperComboBox.getValue();
    	if (selectedShipperName != null) {
        int rating = starRatingControl.getSelectedRating();
        Shipper shipper = Database.findCarrier(selectedShipperName); // Replace with the actual shipper
        Database.storeRating(shipper, rating);
        btnMessage.setText("Thank You!");
        System.out.println("now\n");
        System.out.print(shipper+"-"+rating);
    	 } else {
    	        btnMessage.setText("Please select a shipper.");
    	    }
    }
//    public void lookupCarriersAndDeliveries() {
//        HashMap<String, Shipper> shippers = Database.getShippers();
//        for (Map.Entry<String, Shipper> entry : shippers.entrySet()) {
//            Shipper shipper = entry.getValue();
//            //System.out.println("Shipper: " + shipper.getName());
//            //System.out.println("Deliveries:");
//            lookupCarrierDeliveries(shipper);
//            //System.out.println();
//        }
//    }
    public void populateShipperComboBox() {
        // Get the list of shipper names from the database or wherever they are stored
        // For demonstration purposes, let's assume you have a method in Database class to get shipper names
        // Replace this with your actual method to retrieve shipper names
    	List<String> shipperNames = new ArrayList<>();
    	HashMap<String, Shipper> shippers = Database.getShippers();
        for (Map.Entry<String, Shipper> entry : shippers.entrySet()) {
            Shipper shipper = entry.getValue();
            System.out.println(shipper);
            shipperNames.add(shipper.getName());
//            System.out.println(shipper.getName());
        }
        // Clear the existing items in the ComboBox
        shipperComboBox.getItems().clear();

        // Add the shipper names to the ComboBox
        shipperComboBox.getItems().addAll(shipperNames);
    }
}
