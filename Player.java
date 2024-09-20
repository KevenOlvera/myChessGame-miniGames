package byteblitz;

public class Player {
	private String name;
	private int score;
	
	public Player (String n) {
		name = n;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int s) {
		score = s;
	}

	public void addPoints (int points) {
		score += points;
	}
	
	public String toString() {
		return name + "    " + score + " points";
	}
}
