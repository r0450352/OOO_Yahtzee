package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Category;
import model.Player;

public class YahtzeeScorePanel extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
		
	private JPanel scorePanel;
	private JPanel upperScorePanel;
	private JPanel lowerScorePanel;

	private JButton upperAces, upperTwos, upperThrees, upperFours, upperFives, upperSixes;	
	private JLabel labelAces, labelTwos, labelThrees, labelFours, labelFives, labelSixes, 
						labelUpperScore, labelBonus, labelUpperTotal;
	
	private JButton lowerToak, lowerFoak, lowerFullHouse, lowerSmallStraight, lowerLargeStraight, lowerChance, lowerYahtzee;
	private JLabel labelToak, labelFoak, labelFullHouse, labelSmallStraight, labelLargeStraight, labelChance, labelYahtzee,
						labelLowerScore, labelTotalScore;
	
	public YahtzeeScorePanel(Container contentPane) {
	    scorePanel = new JPanel();
	    scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
	    scorePanel.setBorder(BorderFactory.createTitledBorder("Score Sheet"));
	    
	    upperScorePanel = new JPanel();
	    upperScorePanel.setLayout(new GridLayout(9, 3));
	    upperScorePanel.setBorder(BorderFactory.createTitledBorder("Upper score"));
	    lowerScorePanel = new JPanel();
	    lowerScorePanel.setLayout(new GridLayout(9, 1));
	    lowerScorePanel.setBorder(BorderFactory.createTitledBorder("Lower score"));
	    
	    this.createComponents();
	    this.setUpUpperScore();
	    this.setUpLowerScore();

	    scorePanel.add(upperScorePanel, BorderLayout.WEST);
	    scorePanel.add(lowerScorePanel, BorderLayout.WEST);
	    
	    contentPane.add(scorePanel, BorderLayout.EAST);
	    
	}
	
	private void createComponents() {		    
	    /**
	     * Upper score
	     * Labels
	     */
		this.labelAces = new JLabel("0");
		this.labelTwos = new JLabel("0");
		this.labelThrees = new JLabel("0");
		this.labelFours = new JLabel("0");
		this.labelFives = new JLabel("0");
	    this.labelSixes = new JLabel("0");
	    this.labelUpperScore = new JLabel("0");
	    this.labelBonus = new JLabel("0");
	    this.labelUpperTotal = new JLabel("0");	    
		/**
		 * Upper score
		 * Buttons
		 */
	    this.upperAces = new JButton();
	    this.upperTwos = new JButton();
	    this.upperThrees = new JButton();
	    this.upperFours = new JButton();
	    this.upperFives = new JButton();
	    this.upperSixes = new JButton();
	    
	    /**
	     * Lower score
	     * Labels
	     */
	    this.labelToak = new JLabel("0");
	    this.labelFoak = new JLabel("0");
	    this.labelFullHouse = new JLabel("0");
	    this.labelSmallStraight = new JLabel("0");
	    this.labelLargeStraight = new JLabel("0");
	    this.labelChance = new JLabel("0");
	    this.labelYahtzee = new JLabel("0");
	    this.labelLowerScore = new JLabel("0");
	    this.labelTotalScore = new JLabel("0");
	    
	    /**
	     * Lower score
	     * Buttons
	     */
	    this.lowerToak = new JButton();
	    this.lowerFoak = new JButton();
	    this.lowerFullHouse = new JButton();
	    this.lowerSmallStraight = new JButton();
	    this.lowerLargeStraight = new JButton();
	    this.lowerChance = new JButton();
	    this.lowerYahtzee = new JButton();
		
	}
	
	private void setUpUpperScore() {
		upperScorePanel.add(new JLabel(Category.ACES.getName()));
		upperScorePanel.add(this.labelAces);
		upperScorePanel.add(this.upperAces);
		upperScorePanel.add(new JLabel(Category.TWOS.getName()));
		upperScorePanel.add(this.labelTwos);
		upperScorePanel.add(this.upperTwos);
		upperScorePanel.add(new JLabel(Category.THREES.getName()));
		upperScorePanel.add(this.labelThrees);
		upperScorePanel.add(this.upperThrees);
		upperScorePanel.add(new JLabel(Category.FOURS.getName()));
		upperScorePanel.add(this.labelFours);
		upperScorePanel.add(this.upperFours);
		upperScorePanel.add(new JLabel(Category.FIVES.getName()));
		upperScorePanel.add(this.labelFives);
		upperScorePanel.add(this.upperFives);
		upperScorePanel.add(new JLabel(Category.SIXES.getName()));
		upperScorePanel.add(this.labelSixes);
		upperScorePanel.add(this.upperSixes);
		upperScorePanel.add(new JLabel("Upper score"));
		upperScorePanel.add(this.labelUpperScore);
		upperScorePanel.add(new JLabel(""));
		upperScorePanel.add(new JLabel("Bonus"));
		upperScorePanel.add(this.labelBonus);
		upperScorePanel.add(new JLabel(""));
		upperScorePanel.add(new JLabel("Upper total"));
		upperScorePanel.add(this.labelUpperTotal);
		upperScorePanel.add(new JLabel(""));
	}
	
	private void setUpLowerScore() {
		lowerScorePanel.add(new JLabel(Category.THREE_OF_A_KIND.getName()));
		lowerScorePanel.add(this.labelToak);
		lowerScorePanel.add(this.lowerToak);
		lowerScorePanel.add(new JLabel(Category.FOUR_OF_A_KIND.getName()));
		lowerScorePanel.add(this.labelFoak);
		lowerScorePanel.add(this.lowerFoak);
		lowerScorePanel.add(new JLabel(Category.FULL_HOUSE.getName()));
		lowerScorePanel.add(this.labelFullHouse);
		lowerScorePanel.add(this.lowerFullHouse);
		lowerScorePanel.add(new JLabel(Category.SMALL_STRAIGHT.getName()));
		lowerScorePanel.add(this.labelSmallStraight);
		lowerScorePanel.add(this.lowerSmallStraight);
		lowerScorePanel.add(new JLabel(Category.LARGE_STRAIGHT.getName()));
		lowerScorePanel.add(this.labelLargeStraight);
		lowerScorePanel.add(this.lowerLargeStraight);
		lowerScorePanel.add(new JLabel(Category.CHANCE.getName()));
		lowerScorePanel.add(this.labelChance);
		lowerScorePanel.add(this.lowerChance);
		lowerScorePanel.add(new JLabel(Category.YAHTZEE.getName()));
		lowerScorePanel.add(this.labelYahtzee);
		lowerScorePanel.add(this.lowerYahtzee);
		lowerScorePanel.add(new JLabel("Lower score"));
		lowerScorePanel.add(this.labelLowerScore);
		lowerScorePanel.add(new JLabel(""));
		lowerScorePanel.add(new JLabel("Total score"));
		lowerScorePanel.add(this.labelTotalScore);
		lowerScorePanel.add(new JLabel(""));		
	}

	public void setUpperCategoryScore(Category category, int categoryScore) {
		if (category.getName().equals(Category.ACES.getName())) {
			this.labelAces.setText(String.valueOf(categoryScore));
		}
		if (category.getName().equals(Category.TWOS.getName())) {
			this.labelTwos.setText(String.valueOf(categoryScore));
		}
		if (category.getName().equals(Category.THREES.getName())) {
			this.labelThrees.setText(String.valueOf(categoryScore));
		}
		if (category.getName().equals(Category.FOURS.getName())) {
			this.labelFours.setText(String.valueOf(categoryScore));
		}
		if (category.getName().equals(Category.FIVES.getName())) {
			this.labelFives.setText(String.valueOf(categoryScore));
		}
		if (category.getName().equals(Category.SIXES.getName())) {
			this.labelSixes.setText(String.valueOf(categoryScore));
		}
	}

	public void setLowerCategoryScore(Category category, int categoryScore) {
		if (category.getName().equals(Category.THREE_OF_A_KIND.getName())) {
			this.labelToak.setText(String.valueOf(categoryScore));
		}
		if (category.getName().equals(Category.FOUR_OF_A_KIND.getName())) {
			this.labelFoak.setText(String.valueOf(categoryScore));
		}
		if (category.getName().equals(Category.FULL_HOUSE.getName())) {
			this.labelFullHouse.setText(String.valueOf(categoryScore));
		}
		if (category.getName().equals(Category.SMALL_STRAIGHT.getName())) {
			this.labelSmallStraight.setText(String.valueOf(categoryScore));
		}
		if (category.getName().equals(Category.LARGE_STRAIGHT.getName())) {
			this.labelLargeStraight.setText(String.valueOf(categoryScore));
		}
		if (category.getName().equals(Category.CHANCE.getName())) {
			this.labelChance.setText(String.valueOf(categoryScore));
		}
		if (category.getName().equals(Category.YAHTZEE.getName())) {
			this.labelYahtzee.setText(String.valueOf(categoryScore));
		}
	}

	public void setUpperScore(int upperScore) {
		this.labelUpperScore.setText(String.valueOf(upperScore));
	}

	public void setUpperBonus(int upperBonus) {
		this.labelBonus.setText(String.valueOf(upperBonus));
	}

	public void setUpperTotalScore(int upperTotal) {
		this.labelUpperTotal.setText(String.valueOf(upperTotal));
	}

	public void setLowerScore(int lowerScore) {
		this.labelLowerScore.setText(String.valueOf(lowerScore));
	}

	public void setTotalScore(int totalScore) {
		this.labelTotalScore.setText(String.valueOf(totalScore));
	}
	
	public void setUpperCategoryButtons(Category category, int scoreCategory) {		
		if(category.getName().equals(Category.ACES.getName())) {
			this.upperAces.setText(String.valueOf(scoreCategory));
		}
		if(category.getName().equals(Category.TWOS.getName())) {
			this.upperTwos.setText(String.valueOf(scoreCategory));
		}
		if(category.getName().equals(Category.THREES.getName())) {
			this.upperThrees.setText(String.valueOf(scoreCategory));
		}
		if(category.getName().equals(Category.FOURS.getName())) {
			this.upperFours.setText(String.valueOf(scoreCategory));
		}
		if(category.getName().equals(Category.FIVES.getName())) {
			this.upperFives.setText(String.valueOf(scoreCategory));
		}
		if(category.getName().equals(Category.SIXES.getName())) {
			this.upperSixes.setText(String.valueOf(scoreCategory));
		}
	}
	
	public void setLowerCategoryButtons(Category category, int scoreCategory) {
		if(category.getName().equals(Category.THREE_OF_A_KIND.getName())) {
			this.lowerToak.setText(String.valueOf(scoreCategory));
		}
		if(category.getName().equals(Category.FOUR_OF_A_KIND.getName())) {
			this.lowerFoak.setText(String.valueOf(scoreCategory));
		}
		if(category.getName().equals(Category.FULL_HOUSE.getName())) {
			this.lowerFullHouse.setText(String.valueOf(scoreCategory));
		}
		if(category.getName().equals(Category.SMALL_STRAIGHT.getName())) {
			this.lowerSmallStraight.setText(String.valueOf(scoreCategory));
		}
		if(category.getName().equals(Category.LARGE_STRAIGHT.getName())) {
			this.lowerLargeStraight.setText(String.valueOf(scoreCategory));
		}
		if(category.getName().equals(Category.CHANCE.getName())) {
			this.lowerChance.setText(String.valueOf(scoreCategory));
		}
		if(category.getName().equals(Category.YAHTZEE.getName())) {
			this.lowerYahtzee.setText(String.valueOf(scoreCategory));
		}
	}
	
	public void setAcesScoreCategory(ActionListener listener) {
		upperAces.addActionListener(listener);
	}
	
	public void setTwosScoreCategory(ActionListener listener) {
		upperTwos.addActionListener(listener);		
	}
	
	public void setThreesScoreCategory(ActionListener listener) {
		upperThrees.addActionListener(listener);		
	}
	
	public void setFoursScoreCategory(ActionListener listener) {
		upperFours.addActionListener(listener);		
	}
	
	public void setFivesScoreCategory(ActionListener listener) {
		upperFives.addActionListener(listener);		
	}
	
	public void setSixesScoreCategory(ActionListener listener) {
		upperSixes.addActionListener(listener);		
	}
	
	public void setThreeOfAKindScoreCategory(ActionListener listener) {
		lowerToak.addActionListener(listener);		
	}
	
	public void setFourOfAKindScoreCategory(ActionListener listener) {
		lowerFoak.addActionListener(listener);		
	}
	
	public void setFullHouseScoreCategory(ActionListener listener) {
		lowerFullHouse.addActionListener(listener);		
	}
	
	public void setSmallStraightScoreCategory(ActionListener listener) {
		lowerSmallStraight.addActionListener(listener);		
	}
	
	public void setLargeStraightScoreCategory(ActionListener listener) {
		lowerLargeStraight.addActionListener(listener);		
	}
	
	public void setChanceScoreCategory(ActionListener listener) {
		lowerChance.addActionListener(listener);		
	}
	
	public void setYahtzeeScoreCategory(ActionListener listener) {
		lowerYahtzee.addActionListener(listener);		
	}

	public void disableScoreButton(Category category) {	
		if(category.getName().equals(Category.ACES.getName())) {
			this.upperAces.setEnabled(false);
		}
		if(category.getName().equals(Category.TWOS.getName())) {
			this.upperTwos.setEnabled(false);
		}
		if(category.getName().equals(Category.THREES.getName())) {
			this.upperThrees.setEnabled(false);
		}
		if(category.getName().equals(Category.FOURS.getName())) {
			this.upperFours.setEnabled(false);
		}
		if(category.getName().equals(Category.FIVES.getName())) {
			this.upperFives.setEnabled(false);
		}
		if(category.getName().equals(Category.SIXES.getName())) {
			this.upperSixes.setEnabled(false);
		}
		if (category.getName().equals(Category.THREE_OF_A_KIND.getName())) {
			this.lowerToak.setEnabled(false);
		}
		if (category.getName().equals(Category.FOUR_OF_A_KIND.getName())) {
			this.lowerFoak.setEnabled(false);
		}
		if (category.getName().equals(Category.FULL_HOUSE.getName())) {
			this.lowerFullHouse.setEnabled(false);
		}
		if (category.getName().equals(Category.SMALL_STRAIGHT.getName())) {
			this.lowerSmallStraight.setEnabled(false);
		}
		if (category.getName().equals(Category.LARGE_STRAIGHT.getName())) {
			this.lowerLargeStraight.setEnabled(false);
		}
		if (category.getName().equals(Category.CHANCE.getName())) {
			this.lowerChance.setEnabled(false);
		}
		if (category.getName().equals(Category.YAHTZEE.getName())) {
			this.lowerYahtzee.setEnabled(false);
		}		
	}

	@Override
	public void update(Player player) {
		this.setUpperCategoryScore(Category.ACES, player.getCategoryScore(Category.ACES));
		this.setUpperCategoryScore(Category.TWOS, player.getCategoryScore(Category.TWOS));
		this.setUpperCategoryScore(Category.THREES, player.getCategoryScore(Category.THREES));
		this.setUpperCategoryScore(Category.FOURS, player.getCategoryScore(Category.FOURS));
		this.setUpperCategoryScore(Category.FIVES, player.getCategoryScore(Category.FIVES));
		this.setUpperCategoryScore(Category.SIXES, player.getCategoryScore(Category.SIXES));
		this.setLowerCategoryScore(Category.THREE_OF_A_KIND, player.getCategoryScore(Category.THREE_OF_A_KIND));
		this.setLowerCategoryScore(Category.FOUR_OF_A_KIND, player.getCategoryScore(Category.FOUR_OF_A_KIND));
		this.setLowerCategoryScore(Category.FULL_HOUSE, player.getCategoryScore(Category.FULL_HOUSE));
		this.setLowerCategoryScore(Category.SMALL_STRAIGHT, player.getCategoryScore(Category.SMALL_STRAIGHT));
		this.setLowerCategoryScore(Category.LARGE_STRAIGHT, player.getCategoryScore(Category.LARGE_STRAIGHT));
		this.setLowerCategoryScore(Category.CHANCE, player.getCategoryScore(Category.CHANCE));
		this.setLowerCategoryScore(Category.YAHTZEE, player.getCategoryScore(Category.YAHTZEE));
		this.setUpperScore(player.getUpperScore());
		this.setUpperBonus(player.getUpperBonus());
		this.setUpperTotalScore(player.getUpperTotal());
		this.setLowerScore(player.getLowerScore());
		this.setTotalScore(player.getTotalScore());
	}
}
