package application;

import javax.swing.JOptionPane;

import controller.Controller;
import model.Game;
import model.Player;
import view.YahtzeeView;

public class YahtzeeApp {
	
	public static void main(String[] args) {
		Game model = new Game();
		
		String playersString = JOptionPane.showInputDialog("How many players?");
		int players = Integer.parseInt(playersString);
			
		for(int i = 0; i < players; i++) {
			String playerName = JOptionPane.showInputDialog("What's your name?");
			try {
				Player newPlayer = new Player(playerName);	
				model.addPlayer(newPlayer);				
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				i--;
			}
		}	
		
		for(int i = 0; i < model.getPlayers().size(); i++) {
			YahtzeeView view = new YahtzeeView();
			Controller controller = new Controller(model, view, model.getPlayers().get(i));	
			controller.startView();
		}
		
		while(model.categoriesLeft()){}
		
		JOptionPane.showMessageDialog(null, model.winner().getName()+" won with " + model.winner().getTotalScore()+ " points!");
		System.exit(0);			
	}
	
}