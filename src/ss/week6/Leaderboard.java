package ss.week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Leaderboard {
	List<Score> scores = new ArrayList<Score>();
	
	public Leaderboard(){
		
	}
	
	public void addScore(Score score){
		scores.add(score);
		Collections.sort(scores);
	}
	
	public List<Score> getTop(int n){
		List<Score> topScores = new ArrayList<Score>();
		for(int i = 0; i < n; i++){
			topScores.add(scores.get(i));
		}
		return topScores;
	}
	
	public List<Score> getAbove(int n){
		List<Score> aboveScores = new ArrayList<Score>();
		for(Score score: scores){
			if(score.getPoints() > n){
				aboveScores.add(score);
			} else {
				break;
			}
		}
		return aboveScores;
	}
	
	public List<Score> getBelow(int n){
		List<Score> belowScores = new ArrayList<Score>();
		for(Score score: scores){
			if(score.getPoints() < n){
				belowScores.add(score);
			}
		}
		return belowScores;
	}
	
	public int averageScore(){
		int totalScore = 0;
		for(Score score: scores){
			totalScore += score.getPoints();
		}
		return totalScore / scores.size();
	}
	
	public int averageScore(Date date){
		int totalScore = 0;
		int addedScores = 0;
		for(Score score: scores){
			if(score.getTime().equals(date)){
				totalScore += score.getPoints();
				addedScores++;
			}
		}
		return totalScore / addedScores;
	}
}
