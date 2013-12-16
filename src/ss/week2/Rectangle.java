package ss.week2;

public class Rectangle {
	
	//@ requires width > 1;
	//@ requires length > 1;
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	private int length;
	private int width;


	public int getLength() {
		return length;
	}

	
	public int getWidth() {
		return width;
	}

	//@ ensures \result > 1;
	public int area() {
		return length * width;
	}

	//@ ensures \result > 1;
	public int perimeter() {
		return 2 * length + 2 * width;
	}
}
