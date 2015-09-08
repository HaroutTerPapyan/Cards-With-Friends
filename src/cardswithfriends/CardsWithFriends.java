package cardswithfriends;

public class CardsWithFriends {

    public static void main(String[] args) {
        String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", 
            "Queen", "King", "Ace"};
        
        int SUITS = suit.length;
        int RANKS = rank.length;
        int N = SUITS * RANKS;
        
        //Initialize deck
        String[] deck = new String[N];
        for (int i = 0; i < RANKS; i++) {
            for (int j = 0; j < SUITS; j++) {
                deck[SUITS*i + j] = rank[i] + " of " + suit[j];
                //print deck
                System.out.println(deck[SUITS*i + j]);
            }
        }
        
        System.out.println();
        
        //shuffle
        for (int i = 0; i < N; i++){
            int r = i + (int) (Math.random() * (N-i));
            String t = deck[r];
            deck[r] = deck[i];
            deck[i] = t;
        }

        //print shuffled deck
        for (int i = 0; i < N; i++) {
            System.out.println(deck[i]);
        }
    }
    
}
