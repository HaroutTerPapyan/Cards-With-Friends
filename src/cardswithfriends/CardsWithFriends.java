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
    static ArrayList garbage = new ArrayList();


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

        System.out.println("Dealing cards: ");
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
        int maxX = 12;
        int maxY = 12;
        int maxZ = 12;
        int k = 0;
        int x,y,z;
        while (k <= 12) {
            System.out.println();
            Scanner input = new Scanner(System.in);

            System.out.println("Enter a value from 0 to " + max + " to play a card");
            String inp = input.nextLine();
            int in = Integer.parseInt(inp);

            if (garbage.contains(poDeck[in])) {
                System.out.println("You have already played that hand, please choose another ");
                inp = input.nextLine();
                in = Integer.parseInt(inp);
                garbage.add(poDeck[in]);
                System.out.println(poDeck[in]);
            }
            else {
                garbage.add(poDeck[in]);
                System.out.println(poDeck[in]);
            }


            x=randomWithRange(min,maxX);
            while(garbage.contains(ptDeck[x])) {
                x = randomWithRange(min, maxX);
            }
            System.out.println("Player two plays: " + ptDeck[x]);
            garbage.add(ptDeck[x]);


            y=randomWithRange(min,maxY);
            while(garbage.contains(ptrDeck[y])) {
                y = randomWithRange(min, maxY);
            }
            System.out.println("Player three plays: " + ptrDeck[y]);
            garbage.add(ptrDeck[y]);


            z=randomWithRange(min,maxZ);
            while(garbage.contains(pfDeck[z])) {
                z = randomWithRange(min, maxZ);
            }
            System.out.println("Player four plays: " + pfDeck[z]);
            garbage.add(pfDeck[z]);

            k++;

        }

    }

    //Initialize deck
    public static String[] iniDeck(String[] iDeck) {
        for (int i = 0; i < RANKS; i++) {
            for (int j = 0; j < SUITS; j++) {
                deck[SUITS*i + j] = rank[i] + " of " + suit[j];
                //print deck
                System.out.println(deck[SUITS*i + j]);
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
        //p4 39-51
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
