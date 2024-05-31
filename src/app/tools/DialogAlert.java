package app.tools;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;

public class DialogAlert {
	
	public static boolean showConfirmation(String header, String content) {
		boolean[] clickedOk = {false};
		Alert alert = new Alert(AlertType.CONFIRMATION);
		setDialogIcon(alert, "confirm.png");
		alert.setTitle("Confirmed");
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait().filter(response -> response == ButtonType.OK)
				.ifPresent(response -> clickedOk[0] = true);
		return clickedOk[0];
	}
	
	public static void showMessage(String header, String content, AlertType alertType) {
		Alert alert = new Alert(alertType);
		setDialogIcon(alert, getIconName(alertType));
		alert.setTitle(alertType.name());
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	

	public static void errorDialog(String header, String content) {
		showMessage(header, content, AlertType.ERROR);
	}
	
	private static void setDialogIcon(Alert alert, String iconName) {
		alert.setGraphic(new ImageView(new Image("file:images/" + iconName)));
	}
	
	private static String getIconName(AlertType alertType) {
		switch (alertType) {
			case INFORMATION:
				return "message.png";
			case WARNING:
				return "warn.png";
			case ERROR:
				return "error.png";
			default:
				return "";
		}
	}	
}
