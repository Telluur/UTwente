package ss.week5;

import java.util.Date;

public class Score implements Compare, Comparable<Score> {
	private int points;
	
	private Date time;
	private String player;
	private String team;
	
	public Score(Date time, String player, String team, int points) {
		this.time = time;
		this.player = player;
		this.team = team;
		this.points = points;
	}
	
	public String getPlayer() {
		return player;
	}
	
	public String getTeam() {
		return team;
	}
	
	public Date getTime() {
		return time;
	}
	
	public int getPoints() {
		return points;
	}

	@Override
	public int compareTo(Score score) {
		return score.getPoints() - this.points;
	}
	
	public String toString(){
		return "Player: " + player + " Team: " + team + " Points: " + points;
	}
}
