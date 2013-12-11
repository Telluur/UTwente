package ss.week1.password;

public class Password {

	public static final String INITIAL = "password";
	private String password;

	public Password() {
		password = INITIAL;
	}

	public boolean acceptable(String suggestion) {
		return (suggestion.length() > 5 && !suggestion.contains(" "));
	}

	public boolean testWord(String test) {
		return (test.equals(password));
	}

	public boolean setWord(String oldpass, String newpass) {
		if (testWord(oldpass) && acceptable(newpass)) {
			password = newpass;
			return true;
		}
		return false;
	}
}
