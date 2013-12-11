package ss.week2.hotel;

import ss.week3.pw.Password;

public class Safe {
	private/* @ spec_public @ */boolean active = false;
	private/* @ spec_public @ */boolean open = false;
	private Password password;

	public Safe(Password password) {
		this.password = password;
	}

	// @ requires active == false;
	// @ ensures active == true;
	public boolean activate(String password) {
		if (!active && this.password.testWord(password)) {
			active = true;
			return true;
		}
		return false;
	}

	// @ requires active == true;
	// @ ensures active == false;
	public boolean deactivate() {
		if (active) {
			active = false;
			return true;
		}
		return false;
	}

	// @ requires active == true;
	// @ requires open == false;
	// @ ensures open == true;
	public boolean open (String password){
		if(active && !open && this.password.testWord(password)){
			open = true;
			return true;
		}
		return false;
	}

	// @ requires active == true;
	// @ requires open == true;
	// @ ensures open == false;
	public boolean close() {
		if(active && open){
			open = false;
			return true;
		}
		return false;
	}

	public boolean isActive() {
		return active;
	}

	public boolean isOpen() {
		return open;
	}

	public Password getPassword() {
		return password;
	}
}
