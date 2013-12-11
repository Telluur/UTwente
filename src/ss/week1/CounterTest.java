package ss.week1;

public class CounterTest {
	public static void main(String[] args) {
		MoneyCounter counter = new MoneyCounter();
		counter.add(255);
		System.out.println("After adding:");
		System.out.println(counter.dollars() + "," + counter.cents());
		counter.remove(150);
		System.out.println("After removing:");
		System.out.println(counter.dollars() + "," + counter.cents());
		counter.remove(300);
		System.out.println("After removing too much:");
		System.out.println(counter.dollars() + "," + counter.cents());
	}
}
