package ss.week2;

public class Lamp {
	LampState lampState;
	
	public Lamp(LampState lampState) {
		this.lampState = lampState;
	}

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
