package controller;

import java.awt.event.*;

import javax.swing.JOptionPane;

import model.*;
import view.*;

public class Controller {
	private Game game;
	private YahtzeeView view;	
	private Player player;
	
	public Controller(Game game, YahtzeeView view, Player player) {
		setGame(game); 
		setView(view);
		setPlayer(player);
		
		this.setFirstPlayer();
		
		this.getView().setController(this);		
		this.getView().setFrameTitle(this.getPlayerName());
		
		this.addRollDiceListener();
		this.addDicePickListeners();
		this.addScoreListeners();
	}

	public void startView() {
		this.getView().start();
	}
	
	private void setGame(Game game) {
		this.game = game;
	}
	
	private void setView(YahtzeeView view) {
		this.view = view;
	}
	
	private void setPlayer(Player player) {
		this.player = player;
	}
	
	public Game getGame() {
		return game;
	}
	
	public YahtzeeView getView() {
		return view;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public String getPlayerName() {
		return player.getName();
	}
	
	public Player getActivePlayer() {
		return this.getGame().getActivePlayer();
	}
	
	public void setFirstPlayer() {
		getGame().setFirstPlayer();	
		JOptionPane.showMessageDialog(null, getActivePlayer().getName() + "'s turn.");
	}
	
	public void nextPlayer() {
		getGame().nextPlayer();
		JOptionPane.showMessageDialog(null, getActivePlayer().getName() + "'s turn.");
	}

	private class RollDiceListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			getGame().rollDice();
			getView().getDicePanel().setDiceValues(game.getDice());
			
			getView().getScorePanel().setUpperCategoryScore(Category.ACES, game.getCategoryScore(Category.ACES, player));
			getView().getScorePanel().setUpperCategoryButtons(Category.ACES, Category.ACES.evaluateSet(game.getDiceValues()));
			getView().getScorePanel().setUpperCategoryScore(Category.TWOS, game.getCategoryScore(Category.TWOS, player));
			getView().getScorePanel().setUpperCategoryButtons(Category.TWOS, Category.TWOS.evaluateSet(game.getDiceValues()));
			getView().getScorePanel().setUpperCategoryScore(Category.THREES, game.getCategoryScore(Category.THREES, player));
			getView().getScorePanel().setUpperCategoryButtons(Category.THREES, Category.THREES.evaluateSet(game.getDiceValues()));
			getView().getScorePanel().setUpperCategoryScore(Category.FOURS, game.getCategoryScore(Category.FOURS, player));
			getView().getScorePanel().setUpperCategoryButtons(Category.FOURS, Category.FOURS.evaluateSet(game.getDiceValues()));
			getView().getScorePanel().setUpperCategoryScore(Category.FIVES, game.getCategoryScore(Category.FIVES, player));
			getView().getScorePanel().setUpperCategoryButtons(Category.FIVES, Category.FIVES.evaluateSet(game.getDiceValues()));
			getView().getScorePanel().setUpperCategoryScore(Category.SIXES, game.getCategoryScore(Category.SIXES, player));
			getView().getScorePanel().setUpperCategoryButtons(Category.SIXES, Category.SIXES.evaluateSet(game.getDiceValues()));
			
			getView().getScorePanel().setUpperScore(game.getUpperScore(player));
			getView().getScorePanel().setUpperBonus(game.getUpperBonus(player));
			getView().getScorePanel().setUpperTotalScore(game.getUpperTotal(player));
			
			getView().getScorePanel().setLowerCategoryScore(Category.THREE_OF_A_KIND, game.getCategoryScore(Category.THREE_OF_A_KIND, player));
			getView().getScorePanel().setLowerCategoryButtons(Category.THREE_OF_A_KIND, Category.THREE_OF_A_KIND.evaluateSet(game.getDiceValues()));
			getView().getScorePanel().setLowerCategoryScore(Category.FOUR_OF_A_KIND, game.getCategoryScore(Category.FOUR_OF_A_KIND, player));
			getView().getScorePanel().setLowerCategoryButtons(Category.FOUR_OF_A_KIND, Category.FOUR_OF_A_KIND.evaluateSet(game.getDiceValues()));
			getView().getScorePanel().setLowerCategoryScore(Category.FULL_HOUSE, game.getCategoryScore(Category.FULL_HOUSE, player));
			getView().getScorePanel().setLowerCategoryButtons(Category.FULL_HOUSE, Category.FULL_HOUSE.evaluateSet(game.getDiceValues()));
			getView().getScorePanel().setLowerCategoryScore(Category.SMALL_STRAIGHT, game.getCategoryScore(Category.SMALL_STRAIGHT, player));
			getView().getScorePanel().setLowerCategoryButtons(Category.SMALL_STRAIGHT, Category.SMALL_STRAIGHT.evaluateSet(game.getDiceValues()));
			getView().getScorePanel().setLowerCategoryScore(Category.LARGE_STRAIGHT, game.getCategoryScore(Category.LARGE_STRAIGHT, player));
			getView().getScorePanel().setLowerCategoryButtons(Category.LARGE_STRAIGHT, Category.LARGE_STRAIGHT.evaluateSet(game.getDiceValues()));
			getView().getScorePanel().setLowerCategoryScore(Category.CHANCE, game.getCategoryScore(Category.CHANCE, player));
			getView().getScorePanel().setLowerCategoryButtons(Category.CHANCE, Category.CHANCE.evaluateSet(game.getDiceValues()));
			getView().getScorePanel().setLowerCategoryScore(Category.YAHTZEE, game.getCategoryScore(Category.YAHTZEE, player));
			getView().getScorePanel().setLowerCategoryButtons(Category.YAHTZEE, Category.YAHTZEE.evaluateSet(game.getDiceValues()));
			
			getView().getScorePanel().setLowerScore(game.getLowerScore(player));
			getView().getScorePanel().setTotalScore(game.getTotalScore(player));
		}
	}
	
	private class DieOnePickedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Die[] dice = getGame().getDice();
			getGame().pickedDie(dice[0]);
			
			getView().getDicePanel().setDiceValues(game.getDice());
		}		
	}
	private class DieTwoPickedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Die[] dice = getGame().getDice();
			getGame().pickedDie(dice[1]);
			getView().getDicePanel().setDiceValues(game.getDice());
		}		
	}
	
	private class DieThreePickedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Die[] dice = getGame().getDice();
			getGame().pickedDie(dice[2]);
			getView().getDicePanel().setDiceValues(game.getDice());
		}		
	}
	
	private class DieFourPickedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Die[] dice = getGame().getDice();
			getGame().pickedDie(dice[3]);
			getView().getDicePanel().setDiceValues(game.getDice());
		}		
	}
	
	private class DieFivePickedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Die[] dice = getGame().getDice();
			getGame().pickedDie(dice[4]);
			getView().getDicePanel().setDiceValues(game.getDice());
		}
	}
	
	private class setAcesScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.ACES, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.ACES);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setTwosScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.TWOS, dice, player);
			nextPlayer();		
			getView().getScorePanel().disableScoreButton(Category.TWOS);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setThreesScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.THREES, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.THREES);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setFoursScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.FOURS, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.FOURS);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setFivesScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.FIVES, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.FIVES);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setSixesScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.SIXES, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.SIXES);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setThreeOfAKindScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.THREE_OF_A_KIND, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.THREE_OF_A_KIND);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setFourOfAKindScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.FOUR_OF_A_KIND, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.FOUR_OF_A_KIND);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setFullHouseScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.FULL_HOUSE, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.FULL_HOUSE);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setSmallStraightScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.SMALL_STRAIGHT, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.SMALL_STRAIGHT);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setLargeStraightScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.LARGE_STRAIGHT, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.LARGE_STRAIGHT);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setChanceScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.CHANCE, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.CHANCE);
			getView().getScorePanel().update(getPlayer());
		}		
	}
	
	private class setYahtzeeScore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int[] dice = getGame().getDiceValues();
			getGame().addCategoryScore(Category.YAHTZEE, dice, player);
			nextPlayer();
			getView().getScorePanel().disableScoreButton(Category.YAHTZEE);
			getView().getScorePanel().update(getPlayer());
		}		
	}	

	private void addRollDiceListener() {
		this.getView().getDicePanel().addRollDiceListener(new RollDiceListener());
	}

	private void addDicePickListeners() {		
		this.getView().getDicePanel().addDieOnePickedListener(new DieOnePickedListener());
		this.getView().getDicePanel().addDieTwoPickedListener(new DieTwoPickedListener());
		this.getView().getDicePanel().addDieThreePickedListener(new DieThreePickedListener());
		this.getView().getDicePanel().addDieFourPickedListener(new DieFourPickedListener());
		this.getView().getDicePanel().addDieFivePickedListener(new DieFivePickedListener());
	}
	
	private void addScoreListeners() {		
		this.getView().getScorePanel().setAcesScoreCategory(new setAcesScore());
		this.getView().getScorePanel().setTwosScoreCategory(new setTwosScore());
		this.getView().getScorePanel().setThreesScoreCategory(new setThreesScore());
		this.getView().getScorePanel().setFoursScoreCategory(new setFoursScore());
		this.getView().getScorePanel().setFivesScoreCategory(new setFivesScore());
		this.getView().getScorePanel().setSixesScoreCategory(new setSixesScore());		
		this.getView().getScorePanel().setThreeOfAKindScoreCategory(new setThreeOfAKindScore());
		this.getView().getScorePanel().setFourOfAKindScoreCategory(new setFourOfAKindScore());
		this.getView().getScorePanel().setFullHouseScoreCategory(new setFullHouseScore());
		this.getView().getScorePanel().setSmallStraightScoreCategory(new setSmallStraightScore());
		this.getView().getScorePanel().setLargeStraightScoreCategory(new setLargeStraightScore());
		this.getView().getScorePanel().setChanceScoreCategory(new setChanceScore());
		this.getView().getScorePanel().setYahtzeeScoreCategory(new setYahtzeeScore());		
	}
}