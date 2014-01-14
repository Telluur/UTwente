package ss.week4.math;

public class MathTest {
    public static void main(String[] args) {
        Function[] functions = new Function[]{new Sum(new Constant(3), new Sum(new LinearProduct(5, new Exponent(3)), new Constant(2)))};
        Polynomial polynomial = new Polynomial(functions);
        System.out.println(polynomial.toString());
        System.out.println(polynomial.apply(1));
    }
}
