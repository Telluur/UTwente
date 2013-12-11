package ss.week4.excercises;

import java.util.Arrays;

public class ArrayReverse {

	public int[] reverse(int[] array) {
		for (int index = 0; index < array.length / 2; index++) {
			int temp = array[index];
			array[index] = array[array.length - (index + 1)];
			array[array.length - (index + 1)] = temp;
		}
		return array;
	}

	public void test() {
		int[] set = { 1, 3, 7, 9, 4 };
		printArray(set);
		printArray(reverse(set));
	}

	public void printArray(int[] i) {
		System.out.println(Arrays.toString(i));
	}

	public static void main(String[] args) {
		new ArrayReverse().test();
	}

}
