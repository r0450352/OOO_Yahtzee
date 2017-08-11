package model;

public class Player {
	private String name;
	private Score score;
	
	public Player(String name) {
		this.setName(name);
		this.setScore(new Score());
	}
	
	public void setName(String name) throws IllegalArgumentException {
		if (name.isEmpty() || name == null) {
			throw new IllegalArgumentException("Name should not be empty.");
		}
		this.name = name;
	}
	
	public void setScore(Score score) {
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public Score getScore() {
		return score;
	}
	
	public boolean categoriesLeft() {
		return this.getScore().categoriesLeft();
	}
	
	public void addCategoryScore(Category category, int[] dice) {
		this.getScore().addCategoryScore(category, dice);
	}
	
	public int getCategoryScore(Category category) {
		return this.getScore().getCategoryScore(category);
	}
	
	public int getTotalScore(){
		return this.getScore().getTotalScore();
	}
	
	public int getUpperScore() {
		return this.getScore().getUpperScore();
	}
	
	public int getUpperBonus() {
		return this.getScore().getUpperBonus();
	}
	
	public int getUpperTotal() {
		return this.getScore().getUpperTotal();
	}
	
	public int getLowerScore() {
		return this.getScore().getLowerScore();
	}
}
