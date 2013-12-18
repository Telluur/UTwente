package ss.week4.math;

public class Constant implements Function {
	
	private int number;
	
	public Constant(int number){
		this.number = number;
	}

	public int apply() {
		return number;
	}

	public Object derivative() {
		return 0;
	}
	
	public String toString(){
		return "f(x) = c = " + number;
	}
}
