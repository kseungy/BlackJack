import java.awt.*;
import javax.swing.*;


public class BlackjackFrame extends JFrame{
	/*private Image background = new ImageIcon(BlackjackFrame.class.getResource("C:\\desktop\\image_bj.jpg")).getImage();
	private BlackjackBoard board;
	private HitButton[] hit;
	private StandButton[] stand;
	private SurrenderButton[] surren;
	private NewgameButton[] nGame;*/
	Button b1,b2,b3, b4;
	
	public BlackjackFrame() {
		homeframe();
	}
	public void homeframe() {
		Panel p = new Panel();
		b1 = new Button("Hit");
		b2 = new Button("Stand");
		b3 = new Button("Surren");
		b4 = new Button("New Game");
		p.add(b1); p.add(b2); p.add(b3); p.add(b4);
		
		JLabel dl = new JLabel("딜러 점수: ");
		dl.setBounds(10, 30, 100, 50);
		JLabel pl = new JLabel("사용자 점수: ");
		pl.setBounds(10, 300, 100, 50);
		
		JLabel card = new JLabel("카드1");
		card.setOpaque(true);
		card.setBounds(180, 20, 50, 80);
		card.setBackground(Color.red);
		card.setForeground(Color.black);
		
		
		add(dl); add(pl); add(card);
		add(p);
		
		setTitle("BlackJack Game");
		setSize(730,400);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BlackjackFrame();
	}
	
		/*BlackjackBoard = b;
		hit = new HitButton[1];
		stand = new StandButton[1];
		surren = new SurrenderButton[1];
		nGame = new NewgameButton[1];*/

	

}
