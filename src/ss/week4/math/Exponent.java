package ss.week4.math;

public class Exponent implements Function {

	private int exponent;

	public Exponent(int exponent) {
		this.exponent = exponent;
	}

    @Override
    public int apply(int x) {
		return (int) Math.pow(x, exponent);
	}

    @Override
    public Function derivative() {
		return new LinearProduct(exponent, new Exponent(exponent - 1));
	}

    @Override
    public String toString(){
		return "x^" + exponent;
	}
}
