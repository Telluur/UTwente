package ss.week4.math;

public class Exponent implements Function {

	private int exponent;

	public Exponent(int exponent) {
		this.exponent = exponent;
	}

	public int apply(int x) {
		return x ^ exponent;
	}

	public Function[] derivative() {
		return new Function[]{new Constant(exponent), new Exponent(exponent - 1)};
	}
	
	public String toString(){
		return "f(x) = x^" + exponent;
	}
}
