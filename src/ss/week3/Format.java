package ss.week3;

import java.util.Locale;

public class Format {
	public static String printLine(String text, double amount) {
		return String.format(Locale.ENGLISH, "%-15s %15.2f", text, amount);
	}
}