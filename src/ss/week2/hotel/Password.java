package ss.week2.hotel;

public class Password {
	public static final String INITIAL = "initialpassword";
	private String password;
	
	public Password(){
		password = INITIAL;
	}
	
	public boolean acceptable(String suggestion){
		return (suggestion.length() > 6 && !suggestion.contains(" "));
	}
	
	public boolean setWord(String oldPass, String newPass){
		if(oldPass.equals(password) && acceptable(newPass)){
			password = newPass;
			return true;
		}
		return false;
	}
	
	public boolean testWord(String test){
		return (password.equals(test));
	}
}
