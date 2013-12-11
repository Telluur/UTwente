package ss.week2;

public class Rectangle {
	
	//@ requires width > 1;
	//@ requires lenght > 1;
	Rectangle(int lenght, int width) {
		this.lenght = lenght;
		this.width = width;
	}
	
	private int lenght;
	private int width;


	int lenght() {
		return lenght;
	}

	
	int width() {
		return width;
	}

	//@ ensures \result > 1;
	int area() {
		return lenght * width;
	}

	//@ ensures \result > 1;
	int perimeter() {
		int perimeter = 2 * lenght + 2 * width;
		return perimeter;
	}
}
