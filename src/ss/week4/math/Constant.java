package ss.week4.math;

public class Constant implements Function {
	
	private int number;
	
	public Constant(int number){
		this.number = number;
	}

    @Override
	public int apply(int x) {
		return number;
	}

    @Override
    public Function derivative() {
		return new Constant(0);
	}

    @Override
    public String toString(){
		return Integer.toString(number);
	}
}
