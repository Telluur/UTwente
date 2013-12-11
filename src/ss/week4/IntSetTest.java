package ss.week4;

import java.util.Arrays;

public class IntSetTest {

	public static void main(String[] args){
		new IntSetTest().test();
	}
	
	public void test(){
		IntSet a = new IntSet(10);
		IntSet b = new IntSet(8);
		a.remove(4);
		a.remove(6);
		b.remove(4);
		
		boolean[] union = a.union(b);
		System.out.println(Arrays.toString(union));
	}
}
