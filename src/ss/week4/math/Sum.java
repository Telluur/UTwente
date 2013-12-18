package ss.week4.math;

public class Sum {
	Function a;
	Function b;	
	
	public Sum(Function a, Function b){
		this.a = a;
		this.b = b;
	}
	
	public int apply(int x){
		return a.apply(x) + b.apply(x);
	}
	
	public Function[] derivative(){
		Function[] aDerivative = a.derivative();
		Function[] bDerivative = b.derivative();
		Function[] derivative = new Function[aDerivative.length + bDerivative.length];
		int x = 0;
		for(Function function : aDerivative){
			derivative[x] = function;
			x++;
		}
		for(Function function : bDerivative){
			derivative[x] = function;
			x++;
		}
		return derivative;
	}
}
