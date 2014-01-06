package ss.week6;

import java.util.Scanner;

public class Hallo {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		new Hallo().run(in);
	}

	void run(Scanner scanner) {
		System.out.println("Enter your name:");
		String name = scanner.next();
		if(!(name == null)){
			System.out.println("Hallo " + name);
			run(scanner);
		}
	}
}
