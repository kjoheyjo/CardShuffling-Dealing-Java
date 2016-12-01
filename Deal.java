
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Deal{
	
	public static void main(String args[]){
		//int numPlayers = Integer.parseInt(args[0]);
		//int cardsPerPlayer = Integer.parseInt(args[1]);
		
		List<DeckCards> deck = DeckCards.newDeck();
		for(int i=0;i<52;i++){
			System.out.println(deck.get(i).toString());
		}
		System.out.println();
		System.out.println("Shuffled cards");
		ExecutorService service = Executors.newSingleThreadExecutor(); 
		
		try{
			Runnable r = new Runnable(){
				public void run(){
					List<DeckCards> shuffledDeck = shuffle(deck);
					System.out.println(shuffledDeck);
				}
				
			};
			
			Future<?> f = service.submit(r);
			f.get(2,TimeUnit.MINUTES);
			
		}
		catch(final InterruptedException e){
			System.out.println("Interrupted");
		}
		catch(final ExecutionException e){
			System.out.println("Execution error");
		}
		catch(final TimeoutException e){
			System.out.println("took too long");
		}
		finally{
			service.shutdown();
		}
		
		//List<DeckCards> shuffledDeck = shuffle(deck);
		// for(int i=0;i<52;i++){
			// System.out.println(shuffledDeck.get(i).toString());
		// }
		 
		
		
	
	}
	
	public static List<DeckCards> shuffle(List<DeckCards> deck){
		int n = deck.size();
		List<DeckCards> shuffled = new ArrayList<DeckCards>(); 
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