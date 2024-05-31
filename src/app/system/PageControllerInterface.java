package app.system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public interface PageControllerInterface {
	
	@FXML
	void btnReturnClick(ActionEvent event) throws Exception;

	@FXML
	void btnHomeClick(ActionEvent event) throws Exception;

}
