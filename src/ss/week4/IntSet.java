package ss.week4;

public class IntSet {
	private boolean[] isIn;
	
	public IntSet(int maxElement){
		isIn = new boolean[maxElement + 1];
		int i = 0;
		while (i < isIn.length){
			isIn[i] = true;
			i++;
		}
	}

	public void add(int number){
		if(number < isIn.length && number >= 0){
			isIn[number] = true;
		}
	}
	
	public void remove(int number){
		if(number < isIn.length && number >= 0){
			isIn[number] = false;
		}
	}
	
	public boolean isIn(int number){
		return number < isIn.length && number >= 0 && isIn[number];
	}
	
	public boolean[] union(IntSet intSet){
		boolean[] unionSet = new boolean[isIn.length];
		for(int i = 0; i < isIn.length; i++){
			System.out.println(i + ": " + isIn.length);
			unionSet[i] = isIn[i] || intSet.isIn(i);
		}
		return unionSet;
	}
}
