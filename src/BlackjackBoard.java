import javax.swing.*;
import java.awt.*;
//ㅁ
public class BlackjackBoard extends JPanel{
	private Card card;
	private CardDeck computer_deck;
	private CardDeck player_deck;
	private ComputerPlayer npc;
	private HumanPlayer player;
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0, 0, 1000, 600);
		
		//computer 카드 자리
		g.setColor(Color.black);
		g.drawRect(450, 30, 100, 150);
		g.drawRect(600, 30, 100, 150);
		
		//player 카드 자리
		g.drawRect(450, 400, 100, 150);
		g.drawRect(600, 400, 100, 150);
		
	}
	
}
