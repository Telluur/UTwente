package ss.week3.pw;

public class BasicChecker implements Checker{
	public static final int MINIMUM_PASSWORD_LENGTH = 6;
	public static final String INITIAL_PASSWORD = "password";
	
	public boolean acceptable(String suggestion) {
		return (suggestion.length() >= MINIMUM_PASSWORD_LENGTH);
	}

	public String generatePassword() {
		return INITIAL_PASSWORD;
	}
}
