
import javax.swing.*;

public class HumanPlayer extends CardPlayer {
	
	private String name;	
	private int chips = 0;

	public HumanPlayer(int max_cards, String n) {
		super(max_cards);
		name = n;
	}
	
	public boolean wantsACard() {
		String response = JOptionPane.showInputDialog("�븳�옣 �뜑 �뱶由닿퉴�슂? (Y/N)");
		return response.equals("Y") || response.equals("y");
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
	
	public int countChips() {
		return chips;
	}
}
