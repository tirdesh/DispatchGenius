package app.receiver;

import app.system.PageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
	
	public class ReplyPageController extends PageController{

	@FXML
	private CheckBox btnConfirm;

	@FXML
	private Button btnReturn;

	@FXML
	private Button btnSubmit;
	
    @FXML
    private Label myMessage;
    
    @FXML
    private Button btnLoginOut;
    
    @Override
    @FXML
    public void btnReturnClick(ActionEvent event) throws Exception {
    	launchApp.showRecipientMainView();
	}
    
    @FXML
    void btnSubmitClick(ActionEvent event) {
    	myMessage.setText("Thank You !");
	}
    
    @FXML
    void btnLoginOutClick(ActionEvent event) throws Exception {
    	launchApp.showMainView();
	}
}    
    

