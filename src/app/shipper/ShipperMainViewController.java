package app.shipper;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import app.model.Shipment;
import app.model.Shipper;
import app.system.PageController;
import app.tools.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.*;
public class ShipperMainViewController extends PageController implements Initializable{

    @FXML
    private Button btnHome;

    @FXML
    private Button btnPackageArrived;

    @FXML
    private Button btnPackageStatus;

    @FXML
    private Button btnReturn;

    @FXML
    private Button btnScanPackage;

    @FXML
    private Button btnRequestedAppointment;
    
    @FXML
    private TableView<Shipment> shipmentTable;
    
    @FXML
    private TableColumn<Shipment, String> trackingNumber;
    
    @FXML
    private TableColumn<Shipment, String> customerName;
    
    @FXML
    private TableColumn<Shipment, String> packageStatus;

    @FXML
    private Label lblAverageRating;
    
    @FXML
    void btnNotifyReciClick(ActionEvent event) {

    }

    @FXML
    void btnPackageArrivedClick(ActionEvent event) throws Exception {
    	launchApp.showCarrierArrivedView();
    }

    @FXML
    void btnPackageStatusClick(ActionEvent event) throws Exception {
    	launchApp.showCarrierChangeStatusView();
    }

    @Override
    @FXML
    public void btnReturnClick(ActionEvent event) throws Exception {
    	launchApp.showCarrLoginView();
    }

    @FXML
    void btnScanPackageClick(ActionEvent event) throws Exception {
    	launchApp.showCarrierAddPacView();
    }
    
    @FXML
    void btnRequestedAppointmentClick(ActionEvent event) throws Exception {
    	launchApp.showCarrierRequestedAppointmentView();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		trackingNumber.setCellValueFactory(new PropertyValueFactory<Shipment, String>("trackingNumber"));
		customerName.setCellValueFactory(new PropertyValueFactory<Shipment, String>("recipientName"));
		packageStatus.setCellValueFactory(new PropertyValueFactory<Shipment, String>("status"));

		List<Shipment> rs = new ArrayList<Shipment>();
		
		for (Map.Entry<String, Shipment> shipment : Database.getShipments().entrySet()) {
			rs.add(shipment.getValue());
		}
		
		shipmentTable.getItems().setAll(rs);
		Shipper currentShipper = Database.findCarrier(Database.getCurrentuser()); // Implement this method to get the current shipper
        double averageRating = Database.getShipperRatingAverage(currentShipper);
        lblAverageRating.setText("Average Rating: " + averageRating);
	}

}





