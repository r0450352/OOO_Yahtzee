package model;

public class DiceTray {
	private Die[] dice = new Die[5];
	
	public DiceTray() {
		for (int i = 0; i < 5; i++) {
			dice[i] = new Die();
		}
	}
	
	public void roll() {
		for(Die d: dice) {
			if(!d.isSavedDie()){
				d.roll();
			}
		}
	}
	
	public Die[] getDice() {
		return dice;
	}
	
	public int[] getDiceValues() {
		int[] values = new int[5];
		int index = 0;
		for (Die d: dice) {
			values[index] = d.getValue();
			index++;
		}
		return values;
	}	
	
	public void saveDie(Die die) {
		die.setSavedDie(true);
	}
	
	public void undoSavedDie(Die die) {
		die.setSavedDie(false);
	}
	
	public void resetSavedDice() {
		for(Die d: dice) {
			d.setSavedDie(false);
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		for (Die d: dice) {
			s += d.getValue() +  " - ";
		}
		return s;
	}
}
