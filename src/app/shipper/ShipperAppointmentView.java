package app.shipper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.model.Appointment;
import app.system.PageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import app.tools.Database;

public class ShipperAppointmentView extends PageController{
	
		@FXML
		private Button btnReturn;		
		@FXML
		private Button btnHome;
	    @FXML
	    private TableView<Appointment> appointmentTable;
	    @FXML
	    private TableColumn<Appointment, String> containsColumn;
	    @FXML
	    private TableColumn<Appointment, String> addressColumn;
	    @FXML
	    private TableColumn<Appointment, String> scheduledTimeColumn;
	    @FXML
	    private TableColumn<Appointment, String> destinationAddressColumn;

	    public void initialize() {
	        // Set up the table columns
	    	
	        containsColumn.setCellValueFactory(new PropertyValueFactory<>("contains"));
	        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
	        scheduledTimeColumn.setCellValueFactory(new PropertyValueFactory<>("scheduled"));
	        destinationAddressColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));

	        
//	        for (Map.Entry<String, Shipment> shipment : Database.getShipments().entrySet()) {
//				rs.add(shipment.getValue());
//			}
//			
//			shipmentTable.getItems().setAll(rs);
	        // Add the appointments to the table
	        List<Appointment> ap = new ArrayList<Appointment>();
	        for (Map.Entry<String, Appointment> appointment : Database.getAppointments().entrySet()) {
				ap.add(appointment.getValue());
			}
	        
	        appointmentTable.getItems().setAll(ap);

	            System.out.print(appointmentTable.getItems());
	        
	}

		@Override
		public void btnReturnClick(ActionEvent event) throws Exception {
			// TODO Auto-generated method stub
			launchApp.showCarrierMainView();
		}

		
	


}
