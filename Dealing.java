

import java.util.*;


public class Dealing{
	
	public static void main(String args[]){
		//int numPlayers = Integer.parseInt(args[0]);
		//int cardsPerPlayer = Integer.parseInt(args[1]);
		
		List<DeckCards> deck = DeckCards.newDeck();
		for(int i=0;i<52;i++){
			System.out.println(deck.get(i).toString());
		}
		System.out.println();
		System.out.println("Shuffled cards");
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				List<DeckCards> shuffledDeck = shuffle(deck);
				System.out.println(shuffledDeck);
			}
		}, 5000, 100);
		
		//List<DeckCards> shuffledDeck = shuffle(deck);
		// for(int i=0;i<52;i++){
			// System.out.println(shuffledDeck.get(i).toString());
		// }
		 
		
		
	
	}
	
	public static List<DeckCards> shuffle(List<DeckCards> deck){
		int n = deck.size();
		//List<DeckCards> shuffled = new ArrayList<DeckCards>(); 
		//Random random = new Random();
		Random random = new Random();
		for(int i=n-1;i>0;i--){
			int j = random.nextInt(i);
			//System.out.println(j + "  " + i);
			DeckCards temp = deck.get(i);
			deck.set(i,deck.get(j));
			deck.set(j,temp);
		}
		
		return deck;
	}
	
	

}