package ss.week6;

import java.util.Scanner;

public class Words {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		new Words().showWords(in);
	}

	void showWords(Scanner in) {
		System.out.println("Line (or 'end'): ");
		String sentence = in.nextLine();
		Scanner delimiter = new Scanner(sentence).useDelimiter("\\s+");
		String firstWord = delimiter.next();
		if (firstWord.equals("end")) {
			in.close();
			delimiter.close();
			System.out.println("End of programme.");
		} else {
			System.out.println("Word 1: " + firstWord);
			int i = 2;
			while (delimiter.hasNext()) {
				System.out.println("Word " + i + ": " + delimiter.next());
				i++;
			}
			delimiter.close();
			showWords(in);
		}
	}

}
