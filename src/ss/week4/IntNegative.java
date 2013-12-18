package ss.week4;

public class IntNegative {

	public int negatives(int[] array){
		int number = 0;
		for(int i : array){
			if (i < 0){number++;}
		}
		return number;
	}
	
	public void test(){
		int[] set = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
		System.out.println(negatives(set));
	}
	
	public static void main(String[] args){
		new IntNegative().test();
	}
}
