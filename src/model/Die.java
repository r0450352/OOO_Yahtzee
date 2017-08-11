package model;

public class Die {
	private int value;
	private boolean savedDie;
	
	public Die() {
		this.setSavedDie(false);
		roll();
	}
	
	public void roll() {
		this.setSavedDie(false);
		this.value = (int)(Math.random() * 6 + 1);
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isSavedDie() {
		return savedDie;
	}
	
	public void setSavedDie(boolean savedDie) {
		this.savedDie = savedDie;
	}
	
	@Override
	public String toString() {
		return value + "";
	}
}
