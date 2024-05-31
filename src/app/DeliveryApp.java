package app;

import app.admin.*;
import app.login.*;
import app.receiver.*;
import app.shipper.*;
import app.tools.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class DeliveryApp extends Application {
	
	private Stage primaryStage;
	private Scene currentScene;
	private Database database;

	@Override
	public void start(Stage primaryStage) throws Exception{
		this.primaryStage = primaryStage;
		database = new Database();
		showMainView();
		primaryStage.show();		
	}
	
	public Database getDatabase() {
		return database;
	}
	
	public Scene getCurrentScene() {
		return currentScene;
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public void showMainView() throws Exception {
		primaryStage.setTitle("Dispatch Genius - Your Shipment App");
		primaryStage.getIcons().clear();
		MainViewController mainController = (MainViewController)replaceSceneContent("login/MainView.fxml");
		mainController.setLaunchApp(this);
	}
	
	public void showCarrLoginView() throws Exception {
		primaryStage.setTitle("Shipper Login");
		primaryStage.getIcons().clear();
		ShipperLoginViewController shiplgController = (ShipperLoginViewController)replaceSceneContent("login/ShipperLoginView.fxml");
		shiplgController.setLaunchApp(this);
	}
	
	public void showReciLoginView() throws Exception {
		primaryStage.setTitle("Receiver Login");
		primaryStage.getIcons().clear();
		ReceiverLoginViewController recilgController = (ReceiverLoginViewController)replaceSceneContent("login/ReceiverLoginView.fxml");
		recilgController.setLaunchApp(this);
	}
	
	public void showAdminLoginView() throws Exception {
		primaryStage.setTitle("Admin Login");
		primaryStage.getIcons().clear();
		AdminLoginViewController adminlgController = (AdminLoginViewController)replaceSceneContent("login/AdminLoginView.fxml");
		adminlgController.setLaunchApp(this);
	}
	
	public void showForgetView() throws Exception {
		primaryStage.setTitle("Forget Password");
		ForgetViewController fgController = (ForgetViewController)replaceSceneContent("login/ForgetView.fxml");
		fgController.setLaunchApp(this);
	}
	
	public void showRegistView() throws Exception {
		primaryStage.setTitle("Register");
		primaryStage.getIcons().clear();
		RegisterViewController regController = (RegisterViewController)replaceSceneContent("login/RegisterView.fxml");
		regController.setLaunchApp(this);
	}
	
	public void showCarrierMainView() throws Exception {
		primaryStage.setTitle("Shipper Main View");
		ShipperMainViewController shipperController = (ShipperMainViewController)replaceSceneContent("shipper/ShipperMainView.fxml");
		shipperController.setLaunchApp(this);
	}
	
	public void showRecipientMainView() throws Exception {
		primaryStage.setTitle("Receiver Main View");
		ReceiverMainViewController receiverController = (ReceiverMainViewController)replaceSceneContent("receiver/ReceiverMainView.fxml");
		receiverController.setLaunchApp(this);
	}
	

	public void showPackageStatus() throws Exception {
		primaryStage.setTitle("Package Status Check");
		PackageStatusPageController pacStatusController = (PackageStatusPageController) replaceSceneContent("receiver/PackageStatusView.fxml");
		pacStatusController.setLaunchApp(this);
	}
	
	public void showPreference() throws Exception {
		primaryStage.setTitle("Book Your Genie");
		PreferencePageController preController =  (PreferencePageController) replaceSceneContent("receiver/NotificationPreferenceView.fxml");
		preController.setLaunchApp(this);
	}
	
	public void showRate() throws Exception {
		primaryStage.setTitle("Rate Us");
		RatePageController ratePageController =  (RatePageController) replaceSceneContent("receiver/RateView.fxml");
		ratePageController.setLaunchApp(this);
	}

	public void showReply() throws Exception {
		primaryStage.setTitle("Confirm Reciept & Help");
		ReplyPageController replyPageController =  (ReplyPageController) replaceSceneContent("receiver/ReplyView.fxml");
		replyPageController.setLaunchApp(this);		
	}
	
	public void showCarrierAddPacView() throws Exception {
		primaryStage.setTitle("Shipper Scan Package");
		ShipperAddPackageViewController addPacController = (ShipperAddPackageViewController) replaceSceneContent("shipper/ShipperAddPackageView.fxml");
		addPacController.setLaunchApp(this);
	}
	
	public void showAdminMainView() throws Exception {
		primaryStage.setTitle("Admin View");
		AdminMainViewController adminViewController = (AdminMainViewController) replaceSceneContent("admin/AdminMainView.fxml");
		adminViewController.setLaunchApp(this);
	}

	public void showCarrierChangeStatusView() throws Exception {
		primaryStage.setTitle("Shipper Change Status");
		ShipperChangeStatusViewController changeStatusController = (ShipperChangeStatusViewController) replaceSceneContent("shipper/ShipperChangeStatusView.fxml");
		changeStatusController.setLaunchApp(this);				
	}
	
	public void showCarrierArrivedView() throws Exception {
		primaryStage.setTitle("Shipper Arrived View");
		ShipperArrivedViewController arrivedController = (ShipperArrivedViewController) replaceSceneContent("shipper/ShipperArrivedView.fxml");
		arrivedController.setLaunchApp(this);	
	}
	public void showCarrierRequestedAppointmentView() throws Exception {
		primaryStage.setTitle("Requested Appointment View");
		ShipperAppointmentView arrivedController = (ShipperAppointmentView) replaceSceneContent("shipper/shipper_appointment_view.fxml");
		arrivedController.setLaunchApp(this);	
	}
	
	private Object replaceSceneContent(String fxmlFile) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(fxmlFile));
		AnchorPane ap = (AnchorPane)loader.load();

		currentScene = new Scene(ap);
		primaryStage.setScene(currentScene);
		primaryStage.setResizable(false);
		
		return loader.getController();
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}


}
