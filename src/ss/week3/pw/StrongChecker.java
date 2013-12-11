package ss.week3.pw;

public class StrongChecker extends BasicChecker {
	public static final String INITIAL_PASSWORD = "password123";

	public boolean acceptable(String suggestion) {
		int passwordlenght = suggestion.length();
		return (passwordlenght >= MINIMUM_PASSWORD_LENGTH
				&& Character.isLetter(suggestion.charAt(0)) && Character
					.isDigit(suggestion.charAt(passwordlenght - 1)));
	}

	public String generatePassword() {
		return INITIAL_PASSWORD;
	}
}
