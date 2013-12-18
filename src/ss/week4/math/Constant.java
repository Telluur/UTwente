package ss.week4.math;

public class Constant implements Function {
	
	private int number;
	
	public Constant(int number){
		this.number = number;
	}

	public int apply(int x) {
		return number * x;
	}

	public Function[] derivative() {
		return new Function[]{new Constant(0)};
	}
	
	public String toString(){
		return "f(x) = c = " + number;
	}
}
