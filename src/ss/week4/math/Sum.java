package ss.week4.math;

public class Sum implements Function{
	Function a;
	Function b;	
	
	public Sum(Function a, Function b){
		this.a = a;
		this.b = b;
	}

    @Override
    public int apply(int x){
		return a.apply(x) + b.apply(x);
	}

    @Override
    public Function derivative(){
        return new Sum(a.derivative(), b.derivative());
	}

    @Override
    public String toString(){
        return a.toString() + " + " + b.toString();
    }
}
