package ss.week4.math;

public class LinearProduct extends Product {
    public LinearProduct(int constant, Function b) {
        super(new Constant(constant), b);
    }

    @Override
    public Function derivative(){
        return new LinearProduct(a.apply(0), b.derivative());
    }
}
