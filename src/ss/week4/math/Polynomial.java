package ss.week4.math;

public class Polynomial implements Function{
	Function[] functions;
	
	public Polynomial(Function[] functions){
		this.functions = functions;
	}
	
	
	@Override
	public int apply(int x) {
        int total = 0;
		for(Function function : functions){
            total += function.apply(x);
        }
        return total;
	}

	@Override
	public Function derivative() {
        Function[] derivedFunctions = new Function[functions.length];
        for(int i = 0; i < functions.length; i++){
            derivedFunctions[i] = functions[i].derivative();
        }
		return new Polynomial(derivedFunctions);
	}
	
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		for(Function function:  functions){
			stringBuilder.append(function.toString());
		}
		return "f(x) = " + stringBuilder.toString();
	}
}
