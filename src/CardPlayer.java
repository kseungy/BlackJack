
public abstract class CardPlayer{ 
	
	private Card[] hand; // 갖고 있는 카드 
	private int card_count; // 갖고 있는 카드의 장 수 
	
	public CardPlayer(int max_cards) {
		hand = new Card[max_cards];
		card_count = 0;
	}
}
