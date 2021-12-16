import javax.swing.*;

public class HumanPlayer extends CardPlayer {
	
	private String name;	
	private double chips = 0;
	private Card card;
	private CardDeck deck;
	
	public HumanPlayer(int max_cards, String n) {
		super(max_cards);
		name = n;
	}
	
	
	public void youWin() {
		chips += 1;
	}
	
	public void youWinBlackjack() {
		chips += 2;
	}
	
	public void youLose() {
		chips -= 1;
	}
	
	public void youDraw() {
		
	}
	public void youSurrender() {
		chips -=0.5;
	}
	
	public double countChips() {
		return chips;
	}
	
	

}
