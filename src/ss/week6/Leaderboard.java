package ss.week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Leaderboard {
	List<Score> scores = new ArrayList<Score>();
	
	public Leaderboard(){
		
	}
	
	/**
	 * Adds a score to the leaderboard
	 * @param score the score to add
	 */
	public void addScore(Score score){
		scores.add(score);
		Collections.sort(scores);
	}
	
	/**
	 * Gets the top n scores
	 * @param n The number of scores to get
	 * @return topScores the list of highest scores
	 */
	public List<Score> getTop(int n){
		List<Score> topScores = new ArrayList<Score>();
		for(int i = 0; i < n; i++){
			topScores.add(scores.get(i));
		}
		return topScores;
	}
	
	/**
	 * Gets all scores with more points than given n
	 * @param n The minimum points a score needs
	 * @return aboveScores All scores above given n
	 */
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
	
	/**
	 * Gets all scores with less points than given n
	 * @param n The max points a score may have
	 * @return belowScores All scores below given n
	 */
	public List<Score> getBelow(int n){
		List<Score> belowScores = new ArrayList<Score>();
		for(Score score: scores){
			if(score.getPoints() < n){
				belowScores.add(score);
			}
		}
		return belowScores;
	}
	
	/**
	 * Gets the average score
	 * @return average The average score
	 */
	public int averageScore(){
		int totalScore = 0;
		for(Score score: scores){
			totalScore += score.getPoints();
		}
		return totalScore / scores.size();
	}
	
	/**
	 * Gets the average score on a certain date
	 * @param date The date to get the average from
	 * @return average The average score
	 */
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
