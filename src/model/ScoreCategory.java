package model;

public class ScoreCategory {
	private Category category;
	private boolean picked;
	private int score;
	
	public ScoreCategory(Category category) {
		this.setCategory(category);
		this.setPicked(false);
		this.score = 0;
	}
	
	private void setCategory(Category category) {
		this.category = category;
	}
	
	private void setPicked(boolean picked) {
		this.picked = picked;
	}
	
	public void setScore(int score) {
		this.setPicked(true);
		this.score = score;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public boolean isPicked() {
		return picked;
	}
	
	public int getScore() {
		return score;
	}
}
