package ss.week1;

public class LampTest {
	public static void main(String[] args){
		Lamp lamp = new Lamp();
		System.out.println(lamp.getLampSetting());
		lamp.setLampSetting(3);
		System.out.println(lamp.getLampSetting());
		lamp.addLampSetting();
		System.out.println(lamp.getLampSetting());
	}
}
