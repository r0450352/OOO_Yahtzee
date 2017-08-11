package model;

import java.util.*;

public class Score {
	private List<ScoreCategory> upperSection;
	private List<ScoreCategory> lowerSection;
	
	public Score() {
		upperSection = new ArrayList<ScoreCategory>(6);
		lowerSection = new ArrayList<ScoreCategory>(7);
		
		addUpperCategories(); addLowerCategories();
	}
	
	public void addCategoryScore(Category category, int[] dice) {
		ScoreCategory scoreCategory = this.getScoreCategory(category);
		if (!scoreCategory.isPicked()) {
			scoreCategory.setScore(category.evaluateSet(dice));			
		}
	}
	
	public int getCategoryScore(Category category) {
		ScoreCategory score = this.getScoreCategory(category);
		return score.getScore();
	}
	
	public int getUpperScore() {
		int score = 0;
		for (int i = 0; i < upperSection.size(); i++) {
			score += this.upperSection.get(i).getScore();
		}
		return score;
	}
	
	public int getUpperBonus() {
		if (this.getUpperScore() >= 63) {
			return 35;
		}
		return 0;
	}	
	
	public int getUpperTotal() {
		return this.getUpperScore() + this.getUpperBonus();
	}
	
	public int getLowerScore() {
		int score = 0;
		for (int i = 0; i < lowerSection.size(); i++) {
			score += this.lowerSection.get(i).getScore();
		}
		return score;		
	}
	
	public int getTotalScore() {
		return this.getUpperScore() 
				+ this.getLowerScore() 
				+ this.getUpperBonus();
	}	
	
	public boolean categoriesLeft() {
		List<ScoreCategory> categories = this.getAllScoreCategories();
		for(ScoreCategory category: categories) {
			if(!category.isPicked()){
				return true;
			}
		}
		return false;
	}
	
	private ScoreCategory getScoreCategory(Category category) {
		for(int i = 0; i < lowerSection.size(); i++) {
			if (lowerSection.get(i).getCategory().getName() == category.getName()) {
				return lowerSection.get(i);
			}
		}
		for(int i = 0; i < upperSection.size(); i++) {
			if (upperSection.get(i).getCategory().getName() == category.getName()) {
				return upperSection.get(i);
			}
		}
		return null;
	}
	
	private List<ScoreCategory> getAllScoreCategories() {
		List<ScoreCategory> categories = new ArrayList<ScoreCategory>();
		for(int i = 0; i < lowerSection.size(); i++) {
			categories.add(lowerSection.get(i));
		}
		for(int i = 0; i < upperSection.size(); i++) {
			categories.add(upperSection.get(i));
		}
		return categories;
	}
	
	private void addUpperCategories() {
		upperSection.add(new ScoreCategory(Category.ACES));
		upperSection.add(new ScoreCategory(Category.TWOS));
		upperSection.add(new ScoreCategory(Category.THREES));
		upperSection.add(new ScoreCategory(Category.FOURS));
		upperSection.add(new ScoreCategory(Category.FIVES));
		upperSection.add(new ScoreCategory(Category.SIXES));		
	}
	
	private void addLowerCategories() {		
		lowerSection.add(new ScoreCategory(Category.THREE_OF_A_KIND));
		lowerSection.add(new ScoreCategory(Category.FOUR_OF_A_KIND));
		lowerSection.add(new ScoreCategory(Category.FULL_HOUSE));
		lowerSection.add(new ScoreCategory(Category.SMALL_STRAIGHT));
		lowerSection.add(new ScoreCategory(Category.LARGE_STRAIGHT));
		lowerSection.add(new ScoreCategory(Category.YAHTZEE));
		lowerSection.add(new ScoreCategory(Category.CHANCE));		
	}
}
