
import java.util.*;
public class DeckCards{
	public enum Rank{TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE}
	
	public enum Suit{CLUBS,DIAMONDS,HEARTS,SPADES}
	
	private final Rank rank;
	private final Suit suit;
	private DeckCards(Rank r, Suit s){
		this.rank = r;
		this.suit = s;
	
	}
	public Rank rank(){return rank;}
	public Suit suit(){return suit;}
	
	public String toString(){
			return rank + " of " + suit;
	}
	
	private static final List<DeckCards> Deck = new ArrayList<DeckCards>();
	
	static {
		for(Suit s: Suit.values()){
			for(Rank r: Rank.values()){
				Deck.add(new DeckCards(r,s));
			}
		}
	}
	
	public static ArrayList<DeckCards> newDeck(){
		return new ArrayList<DeckCards>(Deck);
	}
	
}
