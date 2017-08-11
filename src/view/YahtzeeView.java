package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

import controller.Controller;

public class YahtzeeView {		
	private JFrame frame;
	private Container contentPane;
	
	private Controller controller;
	
	private YahtzeeDicePanel dicePanel;
	private YahtzeeScorePanel scorePanel;
	
	public YahtzeeView() {	
		frame = new JFrame();		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);	
		
		contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout(10, 10));
				
		this.dicePanel = new YahtzeeDicePanel(contentPane);
		this.scorePanel = new YahtzeeScorePanel(contentPane);
	}
	
	public void start() {
		frame.setVisible(true);
	}
	
	public YahtzeeDicePanel getDicePanel() {
		return dicePanel;
	}
	
	public YahtzeeScorePanel getScorePanel() {
		return scorePanel;
	}
	
	public Controller getController() {
		return controller;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public void setFrameTitle(String name) {
		this.frame.setTitle(name);
	}
}
