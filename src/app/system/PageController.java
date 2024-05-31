package app.system;

import app.DeliveryApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public abstract class PageController implements PageControllerInterface{
	
	protected DeliveryApp launchApp;

	public DeliveryApp getLaunchApp() {
		return launchApp;
	}

	public void setLaunchApp(DeliveryApp launchApp) {
		this.launchApp = launchApp;
	}
	
	@Override
	@FXML
	public void btnHomeClick(ActionEvent event) throws Exception {
    	launchApp.showMainView();
    }
	
	@Override
	@FXML
	public abstract void btnReturnClick(ActionEvent event) throws Exception;
}
