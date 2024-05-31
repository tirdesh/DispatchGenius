package app.receiver;


import app.system.PageController;
import app.tools.Database;
import app.tools.DialogAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.HashMap;

import app.model.Appointment;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PreferencePageController extends PageController {

	@FXML
    private TextField containsInput;
	
	@FXML
    private TextField addressInput;
	
	@FXML
    private TextField scheduled_time;
	
	@FXML
    private TextField destinationaddressInput;
	
	@FXML
    private Button btnReturn;
	
	@FXML
    private Button btnHome;
	
	
	
    
    @FXML
    public void handleAppointmentBooking() {
        String containsInputValue = containsInput.getText();
        String addressInputValue = addressInput.getText();
        String scheduled_timeValue = scheduled_time.getText();
        String destinationaddressInputValue = destinationaddressInput.getText();

        String containsRegex = "^[a-zA-Z0-9\\s]+$"; // Allows letters, numbers, and spaces
        String addressRegex = "^[a-zA-Z0-9\\s,.#-]+$"; // Allows letters, numbers, spaces, and common address characters
        String timeRegex = "^\\d{2}:\\d{2}$"; // Matches time in HH:MM format
        String destinationRegex = "^[a-zA-Z0-9\\s,.#-]+$"; // Allows letters, numbers, spaces, and common address characters
        
        if (!containsInputValue.matches(containsRegex)) {
            DialogAlert.errorDialog("Invalid Input", "Contains field should only contain letters, numbers, and spaces");
            return;
        }

        if (!addressInputValue.matches(addressRegex)) {
            DialogAlert.errorDialog("Invalid Input", "Address field should only contain letters, numbers, spaces, commas, periods, dashes, and hash symbols");
            return;
        }

        if (!scheduled_timeValue.matches(timeRegex)) {
            DialogAlert.errorDialog("Invalid Input", "Scheduled time should be in HH:MM format");
            return;
        }

        if (!destinationaddressInputValue.matches(destinationRegex)) {
            DialogAlert.errorDialog("Invalid Input", "Destination address field should only contain letters, numbers, spaces, commas, periods, dashes, and hash symbols");
            return;
        }
        Appointment appointment = new Appointment(containsInputValue, addressInputValue, scheduled_timeValue, destinationaddressInputValue);
        Database.addAppointment(appointment);

        // Clear the input fields
        containsInput.clear();
        addressInput.clear();
        scheduled_time.clear();
        destinationaddressInput.clear();

        // Notify the shipper about the new appointment
        notifyShipper(appointment);
    }

    private void notifyShipper(Appointment appointment) {
        // Implement the logic to notify the shipper about the new appointment
        System.out.println("New appointment booked by receiver: " + appointment);
    }


	@Override
	public void btnReturnClick(ActionEvent event) throws Exception {
		// TODO Auto-generated method stub
		launchApp.showRecipientMainView();
		
	}


    
    

}
