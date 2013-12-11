package ss.week1;

public class Student {
	int score;
	public static final int MINIMAL_SCORE = 70;

	public Student(int score) {
		this.score = score;
	}

	public boolean passed() {
		return score >= MINIMAL_SCORE;
	}
}
