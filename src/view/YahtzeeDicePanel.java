package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;

import model.Die;

public class YahtzeeDicePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel gamePanel;
	private JPanel dicePanel;
	private JPanel buttonPanel;
	
	private JButton die1;
	private JButton die2;
	private JButton die3;
	private JButton die4;
	private JButton die5;
	
	private JButton roll;
	
	public YahtzeeDicePanel(Container contentPane) {
		gamePanel = new JPanel( );
	    gamePanel.setLayout(new GridBagLayout());
	    gamePanel.setBorder(BorderFactory.createTitledBorder("Yahtzee"));
	    contentPane.add(gamePanel, BorderLayout.CENTER);

	    GridBagConstraints gbc = new GridBagConstraints( );
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 2;
	    gbc.weighty = .5;

	    dicePanel = new JPanel( );
	    dicePanel.setLayout(new GridLayout(1, 5, 5, 0));

	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.insets = new Insets(0, 15, 0, 15);
	    gamePanel.add(dicePanel, gbc);

	    roll = new JButton("Roll");

	    buttonPanel = new JPanel( );
	    buttonPanel.setLayout(new BorderLayout());
	    buttonPanel.add(roll, BorderLayout.CENTER );

	    gbc.gridy = GridBagConstraints.RELATIVE;
	    gbc.ipadx = 10;
	    gbc.ipady = 10;
	    gbc.insets = new Insets(0, 40, 180, 40);
	    gbc.weightx = .01;
	    gbc.weighty = .0175;
	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.anchor = GridBagConstraints.PAGE_START;
	    gamePanel.add(buttonPanel, gbc);
	    
	    die1 = new JButton();
	    this.setDieButton(die1);
	    die2 = new JButton();	
	    this.setDieButton(die2);	
	    die3 = new JButton();	
	    this.setDieButton(die3);	
	    die4 = new JButton();	
	    this.setDieButton(die4);	
	    die5 = new JButton();
	    this.setDieButton(die5);
		
		dicePanel.add(die1);
		dicePanel.add(die2);
		dicePanel.add(die3);
		dicePanel.add(die4);
		dicePanel.add(die5);
		
		//this.disableRollButton();
	}
	
	public void enableRollButton() {
		roll.setEnabled(true);
	}
	
	public void disableRollButton() {
		roll.setEnabled(false);
	}
	
	public void addRollDiceListener(ActionListener listener) {
		roll.addActionListener(listener);
	}
	
	public void addDieOnePickedListener(ActionListener listener) {
		die1.addActionListener(listener);
	}
	
	public void addDieTwoPickedListener(ActionListener listener) {
		die2.addActionListener(listener);		
	}
	
	public void addDieThreePickedListener(ActionListener listener) {
		die3.addActionListener(listener);		
	}
	
	public void addDieFourPickedListener(ActionListener listener) {
		die4.addActionListener(listener);		
	}
	
	public void addDieFivePickedListener(ActionListener listener) {
		die5.addActionListener(listener);
	}

	public void setDiceValues(Die[] dice) {
		this.setDiePicture(dice);
	}
	
	private void setDiePicture(Die[] dice) {
		ImageIcon imageDie = null;
		for(int i = 0; i < dice.length; i++){
			if(dice[i].getValue() == 1) {
				if(!dice[i].isSavedDie()){
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Die_value_1.png");				
				} else {
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Saved_Die_value_1.png");			
				}
			}
			if(dice[i].getValue() == 2) {
				if(!dice[i].isSavedDie()){
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Die_value_2.png");				
				} else {
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Saved_Die_value_2.png");			
				}
			}
			if(dice[i].getValue() == 3) {
				if(!dice[i].isSavedDie()){
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Die_value_3.png");				
				} else {
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Saved_Die_value_3.png");			
				}
			}
			if(dice[i].getValue() == 4) {
				if(!dice[i].isSavedDie()){
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Die_value_4.png");				
				} else {
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Saved_Die_value_4.png");			
				}
			}
			if(dice[i].getValue() == 5) {
				if(!dice[i].isSavedDie()){
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Die_value_5.png");				
				} else {
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Saved_Die_value_5.png");			
				}
			}
			if(dice[i].getValue() == 6) {
				if(!dice[i].isSavedDie()){
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Die_value_6.png");				
				} else {
					imageDie = new ImageIcon("C:/Users/verli/OneDrive/Workspace/OOO_Yahtzee/resources/images/Saved_Die_value_6.png");			
				}
			}
			if(i == 0) {
				die1.setIcon(imageDie);
			}
			if(i == 1) {
				die2.setIcon(imageDie);	
			}
			if(i == 2) {
				die3.setIcon(imageDie);			
			}
			if(i == 3) {
				die4.setIcon(imageDie);	
			}
			if(i == 4) {
				die5.setIcon(imageDie);	
			}
		}			
	}
	
	private void setDieButton(JButton button) {
		button.setFocusPainted(false);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setOpaque(false);		
	}
}

