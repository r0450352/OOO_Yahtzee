package model;

import java.util.*;

public class Game implements Subject {
	private List<Observer> observers;
	
	private List<Player> players;
	private Player activePlayer;
	private DiceTray dice;
	
	public Game() {
		observers = new ArrayList<Observer>();
		players = new LinkedList<Player>();
		this.setDiceTray(new DiceTray());
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void setFirstPlayer() {
		this.activePlayer = players.get(0);
	}
	
	public void nextPlayer() {
		int index = players.indexOf(activePlayer);
		
		if (!(index == players.size()-1)) {
			activePlayer = players.get(index+1);
		} else {
			activePlayer = players.get(0);
		}
		this.resetSavedDice();
	}
	
	public boolean categoriesLeft() {
		for(Player player: players) {
			if (player.categoriesLeft()) {
				return true;
			}
		}
		return false;
	}
	
	public Player winner() {
		Player winner = players.get(0);
		for (int i = 1; i < players.size(); i++) {
			if(players.get(i).getTotalScore() > winner.getTotalScore()) {
				winner = players.get(i);
			}
		}
		return winner;
	}
	
	/**
	 * Methods --
	 * 	Dice
	 */
	
	public Die[] getDice() {
		return dice.getDice();
	}
	
	public int[] getDiceValues() {
		return dice.getDiceValues();
	}
 	
	public void rollDice() {
		dice.roll();
	}
	
	public void pickedDie(Die die) {
		if (!die.isSavedDie()) {
			die.setSavedDie(true);
		} else {
			die.setSavedDie(false);
		}
	}
	
	public void resetSavedDice() {
		this.dice.resetSavedDice();
	}
		
	/**
	 * Methods --
	 *  Score
	 */
	
	public void addCategoryScore(Category category, int[] dice, Player player) {
		player.addCategoryScore(category, dice);
		notifyObserver();
	}
	
	public int getCategoryScore(Category category, Player player) {
		return player.getCategoryScore(category);
	}
	
	public int getTotalScore(Player player) {
		return player.getTotalScore();
	}
	
	public int getUpperScore(Player player) {
		return player.getUpperScore();
	}
	
	public int getUpperBonus(Player player) {
		return player.getUpperBonus();
	}
	
	public int getUpperTotal(Player player) {
		return player.getUpperTotal();
	}
	
	public int getLowerScore(Player player) {
		return player.getLowerScore();
	}
	
	/**
	 * Getters
	 * Setters
	 * 
	 */
	
	public void setDiceTray(DiceTray tray) {
		this.dice = tray;
	}
	
	public DiceTray getDiceTray() {
		return dice;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public Player getActivePlayer() {
		return activePlayer;
	}

	/**
	 * Observer
	 * Pattern
	 */
	
	@Override
	public void register(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregister(Observer o) {
		int observerIndex = observers.indexOf(o);
		observers.remove(observerIndex);
	}

	@Override
	public void notifyObserver() {
		for(Observer o: observers) {
			o.update(null, this.activePlayer);
		}
	}
}
