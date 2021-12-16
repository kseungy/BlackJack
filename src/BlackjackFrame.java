import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackjackFrame extends JFrame{
	
	private BlackjackBoard board;
	private int p_sum;// 플레이어 점수 합계
	private int c_sum;// 딜러 점수 합계
	boolean progressGame = true;//게임 진행 상태

	//플레이어 이름 입력
	String name = JOptionPane.showInputDialog("닉네임을 입력하세요");

	HumanPlayer user = new HumanPlayer(10, name);
	ComputerPlayer npc =new ComputerPlayer(10);
	
	private Card card;
	private CardDeck deck = new CardDeck();
	
	Card[] computerCards = new Card[10];
	Card[] playerCards = new Card[10];
	
	//버튼
	JButton hitb = new JButton();
	JButton standb = new JButton();
	JButton surrenb = new JButton();
	JButton newGameb = new JButton();
	
	JLabel L1 = new JLabel(); //승,패 확인판
	JLabel L2 = new JLabel(); //플레이어 점수
	JLabel L3 = new JLabel(); //chip 개수
	JLabel L4 = new JLabel(); //딜러의 점수
	JLabel L5 = new JLabel(); //플레이어 카드
	JLabel L6 = new JLabel(); // 딜러 카드
	
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
		board.add(L1); board.add(L2); board.add(L3); 
		board.add(L4); board.add(L5); board.add(L6);
		start_game(); // 게임 시작
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		g.setFont(new Font("Serif",Font.BOLD,18));
		
		L1.setBounds(400, 100, 500, 300);
		L1.setFont(new Font("Serif",Font.BOLD,40));
		L1.setForeground(Color.white);
		
		L2.setBounds(250, 430, 130, 50);
		L2.setFont(new Font("Serif",Font.BOLD,18));
		L2.setForeground(Color.white);
		L2.setText(name+"의 점수: "+ player_score());
		
		L3.setBounds(250, 480, 100, 50);
		L3.setFont(new Font("Serif",Font.BOLD,18));
		L3.setForeground(Color.white);
		L3.setText("Chips: "+user.countChips());

		L4.setBounds(240, 30, 130, 50);
		L4.setFont(new Font("Serif",Font.BOLD,18));
		L4.setForeground(Color.white);
		
		
		L5.setFont(new Font("Serif",Font.BOLD,18));
		L5.setForeground(Color.white);
		
		if (c_sum > 21) {
			user.youWin();
			L1.setText(name+"이(가) 승리했습니다.");
		}
		else if(p_sum == 21) {
			user.youWin();
			L1.setText(name+"이(가) 승리했습니다.");
		}
		
		//블랙잭 승리 처리
		if(playerCards[0].getRank()+playerCards[1].getRank()==21) {
			user.youWinBlackjack();
			showPhand(g);
			showChand(g);
			L1.setText("블랙잭 승리!");
			hitb.setEnabled(false);
			standb.setEnabled(false);
			surrenb.setEnabled(false);
			progressGame=false;
		}
		
		if(progressGame==false) {
			L4.setText("딜러의 점수: "+computer_score());
			showChand(g);
		}
		else if(progressGame==true) {
			L4.setText("딜러의 점수: ");
			g.drawString(computerCards[1].getSuit()+computerCards[1].getRank(), 450, 100 );		
		}
		else {
			L4.setText("딜러의 점수: ");
			g.drawString(computerCards[1].getSuit()+computerCards[1].getRank(), 450, 100 );		
		}
		showPhand(g);
		repaint();
	}
	
	//플레이어 점수 합계 return
	public int player_score() {
		int p_sum=0;
		int cardRank=0;
		int i = 0;
		while(playerCards[i]!=null) {
			cardRank = playerCards[i].getRank();
			if(cardRank == Card.ACE && p_sum<=10)
				cardRank = 11; //ACE를 11점으로 선택하는 경우
			else if(cardRank == Card.JACK) // JACK,Qeen,KING은 10점
				cardRank=10;
			else if(cardRank == Card.KING)
				cardRank=10;
			else if(cardRank == Card.QUEEN)
				cardRank=10;
			p_sum+=cardRank;
			i++;
		}
		return p_sum;		
	}
	
	//딜러 점수  return
	public int computer_score() {
		int c_sum = 0;
		int cardRank=0;
		int i=0;
		while(computerCards[i]!=null) {
			cardRank = computerCards[i].getRank();
			if(cardRank == Card.ACE && c_sum<=10)
				cardRank = 11; //ACE를 11점으로 선택하는 경우
			else if(cardRank == Card.JACK)
				cardRank=10;
			else if(cardRank == Card.QUEEN)
				cardRank=10;
			else if(cardRank == Card.KING)
				cardRank=10;
			c_sum+=cardRank;
			i++;
		}
		return c_sum;
		
	}
	
	//플레이어 카드 보여주기
	public void showPhand(Graphics g) {
		int y = 470;
		int i = 0;
		while(playerCards[i]!=null) {
			g.drawString(playerCards[i].getSuit() + playerCards[i].getRank(), y, 500);
			y += 100;
			i++;
		}
	}
	
	//딜러 카드 보여주기
	public void showChand(Graphics g) {
		int y = 470;
		int i = 0;
		while(computerCards[i]!=null) {
			
		    g.drawString(computerCards[i].getSuit() + computerCards[i].getRank(), y, 100);
			y += 100;
			i++;
		}
	}
	
	//플레이어가 갖고 있는 카드 수
	public int player_hand() {
		int i = 0;
		while(playerCards[i]!= null) 
			i++;
		return i;
		
	}
		
	//딜러가 갖고 있는 카드 수
	public int computer_hand() {
		int i = 0;
		while(computerCards[i]!= null) 
			i++;
		return i;
	}
	
	//게임 시작
	public void start_game() {
		computerCards = new Card[10];
		playerCards = new Card[10];
		deck = new CardDeck();
		
		playerCards[0] = deck.newCard();		
		computerCards[0] = deck.newCard();		
		playerCards[1] = deck.newCard();
		computerCards[1] = deck.newCard();
		L1.setText("");	
	}
	
	public class HitButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Card c = deck.newCard();
			try {
				playerCards[player_hand()] = c;
				repaint();
				if(player_score()>21) {
					progressGame = false;
					user.youLose();
					L1.setText("BUSTED!! 패배하였습니다.");
					hitb.setEnabled(false);
					standb.setEnabled(false);
					surrenb.setEnabled(false);
				}
				else if(player_score()==21) {
					progressGame = false;
					user.youWin();
					L1.setText(name+"이(가) 승리하였습니다.");
					hitb.setEnabled(false);
					standb.setEnabled(false);
					surrenb.setEnabled(false);
				}
			}
			catch(IndexOutOfBoundsException ep) {
				JOptionPane.showMessageDialog(null, "더 이상 카드를 받을 수 없습니다.");
				hitb.setEnabled(false);
				standb.setEnabled(false);
			}
		}
	}

	public class StandButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			progressGame = false;
			if(player_score()>21) {
				L1.setText("BUSTED!! 패배하였습니다.");
				user.youLose();
			}
			Card c = deck.newCard();
			while(computer_score()<=16)
				computerCards[computer_hand()] = c;
			if(computer_score()>21) {
				L1.setText(name+"이(가) 승리하였습니다.");
				user.youWin();
			}
			else {
				if(player_score()>computer_score()) {
					L1.setText(name+"이(가) 승리하였습니다.");
					user.youWin();
				}
				else if(player_score()==computer_score()) {
					L1.setText("비겼습니다.");
					user.youDraw();
				}
				else {
					L1.setText(name+"이(가) 패배하였습니다.");
					user.youLose();
				}
			}
			hitb.setEnabled(false);
			standb.setEnabled(false);
			surrenb.setEnabled(false);
		}
	}

	public class SurrenderButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			L1.setText(name+"이(가) 항복했습니다.");
			user.youSurrender();
			hitb.setEnabled(false);
			standb.setEnabled(false);
			surrenb.setEnabled(false);
			progressGame = false;
		}
	}

	public class NewGameButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "새 게임을 시작합니다.");
			progressGame = true;
			start_game();
			hitb.setEnabled(true);
			standb.setEnabled(true);
			surrenb.setEnabled(true);
		}
	}
	
	 
}

