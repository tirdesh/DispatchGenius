package app.admin;

import java.util.HashMap;
import java.util.Map;

import app.model.Shipment;
import app.system.PageController;
import app.tools.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class AdminMainViewController extends PageController {

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Button btnReturn;

	@FXML
	private Button btnHome;

	@FXML
	private ChoiceBox<String> carrierChoiceBox;

	@FXML
	private ListView<Shipment> shipmentListView;

	@FXML
	private Label statisticsLabel;

	@FXML
	private ToggleGroup statusToggleGroup;

	private ObservableList<Shipment> shipments;
    private Map<String, Integer> statusCounts;

	@FXML
	private PieChart pieChart;

	@FXML
	void initialize() {
	    // Initialize choice box with carrier names
	    ObservableList<String> carrierNames = FXCollections.observableArrayList(Database.getShippers().keySet());
	    // Add "All" as the default value
	    carrierNames.add(0, "All");
	    carrierChoiceBox.setItems(carrierNames);
	    //carrierChoiceBox.setValue("All");

	    
	    // Initialize shipment list view
	    shipments = FXCollections.observableArrayList(Database.getShipments().values());
	    shipmentListView.setItems(shipments);
	    statusCounts = new HashMap<>();

	    // Update statistics
	    updateStatistics();
	    updatePieChart();
	}

	@FXML
	void btnStatusClick(ActionEvent event) {
	    // Handle button click to refresh shipment list based on carrier
	    refreshShipments();
	}

	private void refreshShipments() {
	    String selectedCarrier = carrierChoiceBox.getValue();
	    if ("All".equals(selectedCarrier)) {
	        // Show all shipments if "All" selected
	        shipments.setAll(Database.getShipments().values());
	    } else if (selectedCarrier != null && !selectedCarrier.isEmpty()) {
	        // Filter shipments by selected carrier
	        shipments.setAll(Database.getShipments().values().stream()
	                .filter(shipment -> shipment.getShipper().getName().equals(selectedCarrier)).toList());
	    }

	    // Update statistics
	    updateStatistics();
	    updatePieChart();
	}


	private void updateStatistics() {
		// Calculate and display statistics
		int totalShipments = shipments.size();

		// Create a map to store counts of each status
		// Map<String, Integer> statusCounts = new HashMap<>();
		for (Shipment shipment : shipments) {
			String status = shipment.getStatus();
			statusCounts.put(status, statusCounts.getOrDefault(status, 0) + 1);
		}

		// Generate statistics text
		StringBuilder statisticsTextBuilder = new StringBuilder();
		statisticsTextBuilder.append("Total Shipments: ").append(totalShipments).append("\n");
		for (Map.Entry<String, Integer> entry : statusCounts.entrySet()) {
			String status = entry.getKey();
			int count = entry.getValue();
			statisticsTextBuilder.append(status).append(": ").append(count).append("\n");
		}

		statisticsLabel.setText(statisticsTextBuilder.toString());

	}
	
    private void updatePieChart() {
    	// Clear previous data
        pieChart.getData().clear();
        // Clear statusCounts map
        statusCounts.clear();

        // Update status counts based on filtered shipments
        for (Shipment shipment : shipments) {
            String status = shipment.getStatus();
            statusCounts.put(status, statusCounts.getOrDefault(status, 0) + 1);
        }

        // Update Pie Chart data
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : statusCounts.entrySet()) {
            String status = entry.getKey();
            int count = entry.getValue();
            PieChart.Data slice = new PieChart.Data(status, count);
            slice.setName(status + ": " + count); // Set label for the slice
            pieChartData.add(slice);
        }
        pieChart.setData(pieChartData);
        pieChart.setTitle("Shipment Statistics");

    }

	@Override
	public void btnReturnClick(ActionEvent event) throws Exception {
		launchApp.showAdminLoginView();
	}

}
