package ss.week4.math;

public class Polynomial implements Function{
	Function[] functions;
	
	public Polynomial(Function[] functions){
		this.functions = functions;
	}
	
	
	@Override
	public int apply(int x) {
		return 0;
	}

	@Override
	public Function[] derivative() {
		Function[] derivedFunctions = new Function[functions.length];
		for(int i = 0; i < functions.length; i++){
			derivedFunctions[i] = functions[i].derivative();
		}
		return derivedFunctions;
	}
	
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		for(Function function:  functions){
			stringBuilder.append(function.derivative());
		}
		return "f(x) = ";
	}
}
