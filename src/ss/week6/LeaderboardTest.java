package ss.week6;

import java.util.Date;

public class LeaderboardTest {
	Leaderboard leaderboard;
	
	public static void main(String[] args){
		new LeaderboardTest().run();
	}

	public LeaderboardTest(){
		leaderboard = new Leaderboard();
	}
	
	public void run(){
		setup();
		testTeamScore();
	}
	
	public void testTop(){
		System.out.println(leaderboard.getTop(5));
	}
	
	public void testAbove(){
		System.out.println(leaderboard.getAbove(3));
	}
	
	public void testBelow(){
		System.out.println(leaderboard.getBelow(5));
	}
	
	public void testAverage(){
		System.out.println(leaderboard.averageScore());
	}
	
	public void testTeamScore(){
		System.out.println(leaderboard.getHighestScore("c"));
	}
	
	private void setup(){
		Score score1 = new Score(new Date(), "1", "a", 1);
		Score score2 = new Score(new Date(), "2", "b", 2);
		Score score3 = new Score(new Date(), "3", "c", 3);
		Score score4 = new Score(new Date(), "4", "c", 4);
		Score score5 = new Score(new Date(), "5", "d", 5);
		Score score6 = new Score(new Date(), "6", "d", 6);
		Score score7 = new Score(new Date(), "7", "e", 7);
		Score score8 = new Score(new Date(), "8", "f", 8);
		
		leaderboard.addScore(score1);		
		leaderboard.addScore(score2);
		leaderboard.addScore(score3);
		leaderboard.addScore(score4);
		leaderboard.addScore(score5);
		leaderboard.addScore(score6);
		leaderboard.addScore(score7);
		leaderboard.addScore(score8);
	}
}
