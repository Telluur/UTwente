package ss.week4.math;

public class Product implements Function {
    Function a;
    Function b;

    public Product(Function a, Function b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int apply(int x) {
        return a.apply(x) * b.apply(x);
    }

    @Override
    public Function derivative() {
        return null;
    }

    @Override
    public String toString(){
        return a.toString() + " * " + b.toString();
    }
}
