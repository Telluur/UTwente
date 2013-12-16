package ss.week2;

public class Lamp {
	//TODO JML
	
	// @ public invariant lampState != null;
	
	LampState lampState;
	
	public Lamp(LampState lampState) {
		this.lampState = lampState;
	}

	// @ requires lampState != null;
	// @ ensures \old(getLampState() == LampState.HIGH) ==> getLampState() == LampState.OFF;
	// @ ensures \old(getLampState() == LampState.MEDIUM) ==> getLampState() == LampState.HIGH;
	// @ ensures \old(getLampState() == LampState.HIGH) ==> getLampState() == LampState.OFF;
	// @ ensures \old(getLampState() == LampState.HIGH) ==> getLampState() == LampState.OFF;
	public void addlampState() {
		switch(lampState){
		case HIGH:
			lampState = LampState.OFF;
			break;
		case MEDIUM:
			lampState = LampState.HIGH;
			break;
		case LOW:
			lampState = LampState.MEDIUM;
			break;
		case OFF:
			lampState = LampState.LOW;
			break;
		default:
			break;
		}
	}
	
	public void setlampState(LampState lampState) {
		this.lampState = lampState;
	}

	public LampState getlampState() {
		return lampState;
	}
}
