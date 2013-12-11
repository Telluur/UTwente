package ss.week1;

public class Lamp {
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	private int lampSetting = OFF;

	public Lamp() {
		
	}

	public void addLampSetting() {
		lampSetting = (lampSetting + 1) % 4;
	}

	public void setLampSetting(int setting) {
		lampSetting = setting;
	}

	public int getLampSetting() {
		return lampSetting;
	}
}
