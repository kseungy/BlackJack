import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackjackFrame extends JFrame{
	private BlackjackBoard board;
	private JLabel com_score = new JLabel(); // 컴퓨터 점수
	private JLabel ply_score = new JLabel(); // 플레이어 점수
	private Card card;
	private CardDeck deck;
	
	int score1 = 10;
	int score2 = 20;
	
	//버튼
	JButton hitb = new JButton();
	JButton standb = new JButton();
	JButton surrenb = new JButton();
	JButton newGameb = new JButton();
	
	public BlackjackFrame() {
		
		board = new BlackjackBoard();
		setContentPane(board);
		setLayout(null);
		
		setSize(1000,600);
		setTitle("Blackjack");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//버튼 배치
		//hit 버튼
		HitButton hb = new HitButton();
		hitb.addActionListener(hb);
		hitb.setBounds(30, 10, 150, 100);
		hitb.setBackground(Color.white);
		hitb.setText("HIT");
		
		//stand 버튼
		StandButton sb = new StandButton();
		standb.addActionListener(sb);
		standb.setBounds(30, 150, 150, 100);
		standb.setBackground(Color.white);
		standb.setText("STAND");
		
		//surrender 버튼
		SurrenderButton surb = new SurrenderButton();
		surrenb.addActionListener(surb);
		surrenb.setBounds(30, 300, 150, 100);
		surrenb.setBackground(Color.white);
		surrenb.setText("SURREN");
		
		//new game 버튼
		NewGameButton ngb = new NewGameButton();
		newGameb.addActionListener(ngb);
		newGameb.setBounds(30, 450, 150, 100);
		newGameb.setBackground(Color.white);
		newGameb.setText("NewGame");
		
		board.add(hitb); board.add(standb); 
		board.add(surrenb); board.add(newGameb);
		
		
		//점수판
		JLabel L1 = new JLabel();
		L1.setText("딜러의 점수: "+Integer.toString(score1));
		L1.setBounds(250, 30, 180, 50);
		board.add(L1);
		
		JLabel L2 = new JLabel();
		L2.setText("플레이어의 점수: "+Integer.toString(score2));
		L2.setBounds(250, 500, 180, 50);
		board.add(L2);
		
		
	}
	
	public void count_score() {
		//만약 플레이어가 이기면 +1
		//컴퓨터가 이기며면 +1
	}
	
	public class HitButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("hit");
		}
	}

	public class StandButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("stand");
		}
	}

	public class SurrenderButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("surren");

		}
	}

	public class NewGameButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("new game");

		}
	}
	
	public static void main(String[] args) {
		new BlackjackFrame();		
	}
	 
}

