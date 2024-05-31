package app.tools;

import java.util.regex.Pattern;

public class UserPasswdCheck {
	
	public static boolean isValidUserName(String userName) {
		String userNamePattern = "^[a-zA-Z]\\w{5,19}$";
		return Pattern.matches(userNamePattern, userName);
	}
	
	public static boolean isValidPassword(String password) {
		String passwordPattern = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^\\w\\s]).{8,30}$";
		return Pattern.matches(passwordPattern, password);
	}
	
	public static boolean isValidMail(String mail) {
		String mailPattern = "^\\w[\\w_-]+@[\\w_-]+(\\.[\\w]+)+$";
		return Pattern.matches(mailPattern, mail);
	}
}
