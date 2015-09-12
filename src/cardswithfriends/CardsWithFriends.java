package cardswithfriends;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CardsWithFriends {
    static String[] suit = {"Clubs", "Spades", "Hearts", "Diamonds"};
    static String[] rank = {"3", "4", "5", "6", "7", "8", "9", "10", "Jack",
            "Queen", "King", "Ace", "2"};

    static int SUITS = suit.length;
    static int RANKS = rank.length;
    static int N = SUITS * RANKS;
    static String[] deck = new String[N];



    public static void main(String[] args) {

        iniDeck(deck); //initialize deck
        shuffle(deck); //shuffle deck

        //print entire deck
        //System.out.println(Arrays.toString(deck));
/*
        //print shuffled deck
        for (int i = 0; i < N; i++) {
            System.out.println(deck[i]);
        }
*/
        String[] poDeck = new String[13]; //player one
        String[] ptDeck = new String[13]; //player two
        String[] ptrDeck = new String[13]; //player three
        String[] pfDeck = new String[13]; //player four


        playerOne(poDeck);
        System.out.println("Player One: " + Arrays.toString(poDeck));
        playerTwo(ptDeck);
        System.out.println("Player Two: " + Arrays.toString(ptDeck));
        playerThree(ptrDeck);
        System.out.println("Player Three: " + Arrays.toString(ptrDeck));
        playerFour(pfDeck);
        System.out.println("Player Four: " + Arrays.toString(pfDeck));



        int min = 0;
        int max = 12;
        int k = 0;
        while (k <= 12) {
            System.out.println();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a value from 0 to " + max + " to play a card");
            String inp = input.nextLine();
            int in = Integer.parseInt(inp);
            System.out.println(poDeck[in]);

            System.out.println("Player two plays: " + ptDeck[randomWithRange(min, max)]);
            System.out.println("Player three plays: " + ptDeck[randomWithRange(min, max)]);
            System.out.println("Player four plays: " + ptDeck[randomWithRange(min, max)]);
            k++;
            max--;

            /*
            method 1: put played card into garbage[]
            check if next played card is in garbage[]
            call randomWithRange until new card
            */

            /*
            method 2: number check during input
            check if number played, if played, play another
            */

            /*
            method 3: use an ArrayList because im an idiot
             */

        }

    }

    //Initialize deck
    public static String[] iniDeck(String[] iDeck) {
        for (int i = 0; i < RANKS; i++) {
            for (int j = 0; j < SUITS; j++) {
                deck[SUITS*i + j] = rank[i] + " of " + suit[j];
                //print deck
                //System.out.println(deck[SUITS*i + j]);
            }
        }
        return iDeck;
    }

    //shuffle deck
    public static String[] shuffle(String[] sDeck) {
        for (int i = 0; i < N; i++) {
            int r = i + (int) (Math.random() * (N - i));
            String t = sDeck[r];
            sDeck[r] = sDeck[i];
            sDeck[i] = t;
        }
        return sDeck;
    }

    public static String[] playerOne(String[] poDeck) {
        System.out.println();
        //p1 0-12
        for (int i = 0; i <= 12; i++) {
            poDeck[i] = deck[i];
            //System.out.println(poDeck[i]);
        }
        return poDeck;
    }

    public static String[] playerTwo(String[] ptDeck) {
        //p2 13-25
        int i = 0;
        while(i <= 12) {
            for (int j = 13; j <= 25; j++) {
                ptDeck[i] = deck[j];
                //System.out.println(ptDeck[i]);
                i++;
            }
        }
        return ptDeck;
    }

    public static String[] playerThree(String[] ptrDeck) {
        //p3 26-38
        int i = 0;
        while(i <= 12) {
            for (int j = 26; j <= 38; j++) {
                ptrDeck[i] = deck[j];
                //System.out.println(ptrDeck[i]);
                i++;
            }
        }
        return ptrDeck;
    }

    public static String[] playerFour(String[] pfDeck) {
        //p3 39-51
        int i = 0;
        while(i <= 12) {
            for (int j = 39; j <= 51; j++) {
                pfDeck[i] = deck[j];
                //System.out.println(pfDeck);
                i++;
            }
        }
        return pfDeck;
    }

    public static int randomWithRange(int min, int max) {
        int range = (max-min) + 1;
        return (int)(Math.random()*range) + min;
    }
}
