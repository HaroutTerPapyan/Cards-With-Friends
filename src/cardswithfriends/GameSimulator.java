
package cardswithfriends;

import java.util.*;

public class GameSimulator {

    
    public static void main(String[] args) {
        int [] deck = new int[52];
        for(int i = 0; i < 52; i++){
            deck[i] = i;
        }
        start(deck);
        
    }
    
    public static void start(int [] deck){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 to play.");
        int play = sc.nextInt();
        while(play == 0){
            shuffle(deck);
            int [] p1 = new int [13];
            int [] p2 = new int [13];
            int [] p3 = new int [13];
            int [] p4 = new int [13];
            handCards(p1, p2, p3, p4, deck);
            insertionSort(p1);
            insertionSort(p2);
            insertionSort(p3);
            insertionSort(p4);
            if(p1[0] == 0){
                System.out.println("Player 1 goes first.");
                playGame(1, p1, 2, p2, 3, p3, 4, p4);
            }
            else if(p2[0] == 0){
                System.out.println("Player 2 goes first.");
                playGame(2, p2, 3, p3, 4, p4, 1, p1);
            }
            else if(p3[0] == 0){
                System.out.println("Player 3 goes first.");
                playGame(3, p3, 4, p4, 1, p1, 2, p2);
            }
            else{
                System.out.println("Player 4 goes first.");
                playGame(4, p4, 1, p1, 2, p2, 3, p3);
            }

            
        }
    }
    static void playGame(int a, int [] first, int b, int [] second, int c, 
            int [] third, int d, int [] fourth){
        int playersDone = 0;
        int pass = 0;
        int [] beatHand = {999, 999, 999, 999, 999};
        int [] playHand = new int [5];
        playHand[0] = 0;
        boolean playAnything = true;
        boolean beaten = false;
        boolean player1Done = false, player2Done = false, player3Done = false,
                player4Done = false;
        while(playersDone < 3){
            playHand[0] = -1;
            beaten = false;
            if((pass + playersDone) == 3){
                pass = 0;
                System.out.println("Everyone passed. You control the table.");
                playAnything = true;
            }
            if(first[0] != 999){
                System.out.println("Hand to beat.");
                for(int i = 0; i < 5; i++){
                    System.out.print(beatHand[i] + " ");
                    System.out.println("");
                }
                while(playHand[0] != 999 && !beaten){
                    pass = enterHand(a, first, playHand, pass, playAnything, 
                            beatHand);
                    beaten = beatChecker(playHand, beatHand, pass, 
                            playAnything, first);
                    if(beaten){
                        pass = 0;
                    }
                }
                beaten = false;
                playAnything = false;
            }
            else{
            }
            if(first[0] == 999){
                if(!player1Done){
                    playersDone++;
                    player1Done = true;
                    playAnything = true;
                }
            }
            playHand[0] = -1;
            beaten = false;
            if((pass + playersDone) == 3){
                pass = 0;
                System.out.println("Everyone passed. You control the table.");
                playAnything = true;
            }
            if(second[0] != 999){
                System.out.println("Hand to beat.");
                for(int i = 0; i < 5; i++){
                    System.out.print(beatHand[i] + " ");
                    System.out.println("");
                }
                System.out.println(playHand[0]);
                System.out.println(beaten);
                while(playHand[0] != 999 && !beaten){
                    System.out.println(playHand[0]);
                    pass = enterHand(b, second, playHand, pass, playAnything, 
                            beatHand);
                    beaten = beatChecker(playHand, beatHand, pass, 
                            playAnything, second);
                    if(beaten){
                        pass = 0;
                    }
                }
                beaten = false;
                playAnything = false;
            }
            else{
            }
            if(second[0] == 999){
                if(!player2Done){
                    playersDone++;
                    player2Done = true;
                    playAnything = true;
                }
            }
            playHand[0] = -1;
            beaten = false;
            if((pass + playersDone) == 3){
                pass = 0;
                System.out.println("Everyone passed. You control the table.");
                playAnything = true;
            }
            if(third[0] != 999){
                System.out.println("Hand to beat.");
                for(int i = 0; i < 5; i++){
                    System.out.print(beatHand[i] + " ");
                    System.out.println("");
                }
                while(playHand[0] != 999 && !beaten){
                    pass = enterHand(c, third, playHand, pass, playAnything, 
                            beatHand);
                    beaten = beatChecker(playHand, beatHand, pass, 
                            playAnything, third);
                    if(beaten){
                        pass = 0;
                    }
                }
                beaten = false;
                playAnything = false;
            }
            else{
            }
            if(third[0] == 999){
                if(!player3Done){
                    playersDone++;
                    player3Done = true;
                    playAnything = true;
                }
            }
            playHand[0] = -1;
            beaten = false;
            if((pass + playersDone) == 3){
                pass = 0;
                System.out.println("Everyone passed. You control the table.");
                playAnything = true;
            }
            if(fourth[0] != 999){
                System.out.println("Hand to beat.");
                for(int i = 0; i < 5; i++){
                    System.out.print(beatHand[i] + " ");
                }
                System.out.println("");
                while(playHand[0] != 999 && !beaten){
                    pass = enterHand(d, fourth, playHand, pass, playAnything, 
                            beatHand);
                    beaten = beatChecker(playHand, beatHand, pass, 
                            playAnything, fourth);
                    if(beaten){
                        pass = 0;
                    }
                }
                beaten = false;
                playAnything = false;
            }
            else{
            }
            if(fourth[0] == 999){
                if(!player4Done){
                    playersDone++;
                    player4Done = true;
                    playAnything = true;
                }
            }
            
        }
    }
    static int enterHand(int pID, int [] hand, int [] playHand, int pass, 
            boolean playAnything, int [] beatHand){
        int [] input = new int [5];
        System.out.println("Player " + pID);
        for(int i = 0; i < 13; i++){
            if(hand[i] == 999){
                break;
            }
            else{
                System.out.print(hand[i] + " ");
            }
        }
        System.out.println();
        System.out.println("Enter the card's index you want to play. "
                + "Enter 999 to pass or when done.");
        int i = 0;
        while(i < 5){
            Scanner sc = new Scanner(System.in);
            int b = sc.nextInt();
            if(i == 0 && b == 999 && playAnything){
                System.out.println("You cannot pass as you control the table.");
                playHand[0] = 999;
                //newHand(hand, playHand, beatHand);
                //reset(playHand);
                return pass;
            }
            else{
                input[i] = b;
                if(b == 999){
                    i++;
                    while(i < 5){
                        input[i] = 999;
                        i++;
                    }
                }
            }
            i++;
        }
        if(input[0] == 999){
            playHand[0] = 999;
            System.out.println("Player " + pID + " passed.");
            return pass = pass + 1;
        }
        else{
            insertionSort(input);
            for(i = 0; i < 5; i++){
                if(input[i] != 999){
                    playHand[i] = hand[input[i]];
                }
                else{
                    while(i < 5){
                        playHand[i] = 999;
                        i++;
                    }
                }
            }
            return pass;
        }
    }
    static boolean beatChecker(int [] playHand, int [] beatHand, int pass, 
            boolean playAnything, int [] mainHand){
        if(playHand[0] == 999 && !playAnything){
            System.out.println("Passed");
            return false;
        }
        if(playHand[0] == 999){
            //System.out.println("Passed");
            reset(playHand);
            return false;
        }
        else{
            HandChecker bHand = new HandChecker(beatHand);
            HandChecker pHand = new HandChecker(playHand);
            boolean beat = false;
            if(playAnything){
                if(pHand.getHandID() != 0){
                    newHand(mainHand, playHand, beatHand);
                    reset(playHand);
                    return true;
                }
                else{
                    System.out.println("Invalid hand");
                    reset(playHand);
                    return false;
                }
            }
            else{
                //HandChecker bHand = new HandChecker(beatHand);
                //HandChecker pHand = new HandChecker(playHand);
                if(pHand.getHandID() == 0){
                    System.out.println("Invalid hand.");
                    reset(playHand);
                    return false;
                }
                else if(pHand.getHandID() > bHand.getHandID() && 
                        bHand.getHandID() > 3){
                    System.out.println("Hand won");
                    newHand(mainHand, playHand, beatHand);
                    reset(playHand);
                    return true;
                }
                else if(pHand.getHandID() < bHand.getHandID() &&
                        pHand.getHandID() > 3){
                    System.out.println("Hand lost. Try again");
                    reset(playHand);
                    return false;
                }
                else{
                    if(pHand.getHandID() == 3 && bHand.getHandID() == 3){
                        if(threeCheck(playHand, beatHand)){
                            System.out.println("Hand won.");
                            newHand(mainHand, playHand, beatHand);
                            reset(playHand);
                            return true;
                        }
                        else{
                            System.out.println("Hand lost. Try again.");
                            reset(playHand);
                            return false;
                        }
                    }
                    else if(pHand.getHandID() == 2 && bHand.getHandID() == 2){
                        if(pairCheck(playHand, beatHand)){
                            System.out.println("Hand won.");
                            newHand(mainHand, playHand, beatHand);
                            reset(playHand);
                            return true;
                        }
                        else{
                            System.out.println("Hand lost. Try again.");
                            reset(playHand);
                            return false;
                        }
                    }
                    else if(pHand.getHandID() == 1 && bHand.getHandID() == 1){
                        if(singleCheck(playHand, beatHand)){
                            System.out.println("Hand won.");
                            newHand(mainHand, playHand, beatHand);
                            reset(playHand);
                            return true;
                        }
                        else{
                            System.out.println("Hand lost. Try again.");
                            reset(playHand);
                            return false;
                        }
                    }
                    if(pHand.getHandID() == 8){
                        if(straightFlushCheck(playHand, beatHand)){
                            System.out.println("Hand won.");
                            newHand(mainHand, playHand, beatHand);
                            reset(playHand);
                            return true;
                        }
                        else{
                            System.out.println("Hand lost. Try again.");
                            reset(playHand);
                            return false;
                        }
                    }
                    else if(pHand.getHandID() == 7){
                        if(fourCheck(playHand, beatHand)){
                            System.out.println("Hand won.");
                            newHand(mainHand, playHand, beatHand);
                            reset(playHand);
                            return true;
                        }
                        else{
                            System.out.println("Hand lost. Try again.");
                            reset(playHand);
                            return false;
                        }
                    }
                    else if(pHand.getHandID() == 6){
                        if(fullHouseCheck(playHand, beatHand)){
                            System.out.println("Hand won.");
                            newHand(mainHand, playHand, beatHand);
                            reset(playHand);
                            return true;
                        }
                        else{
                            System.out.println("Hand lost. Try again.");
                            reset(playHand);
                            return false;
                        }
                    }
                    else if(pHand.getHandID() == 5){
                        if(flushCheck(playHand, beatHand)){
                            System.out.println("Hand won.");
                            newHand(mainHand, playHand, beatHand);
                            reset(playHand);
                            return true;
                        }
                        else{
                            System.out.println("Hand lost. Try again.");
                            reset(playHand);
                            return false;
                        }
                    }
                    else{
                        if(straightCheck(playHand, beatHand)){
                            System.out.println("Hand won.");
                            newHand(mainHand, playHand, beatHand);
                            reset(playHand);
                            return true;
                        }
                        else{
                            System.out.println("Hand lost. Try again.");
                            reset(playHand);
                            return false;
                        }
                    }
                }
            }
        }
    }
    static boolean threeCheck(int [] playHand, int [] beatHand){
        if(playHand[2] / 4 > beatHand[2] / 4){
            System.out.println("Hand beaten");
            return true;
        }
        else{
            System.out.println("Hand lost");
            return false;
        }
    }
    static boolean pairCheck(int [] playHand, int [] beatHand){
        if(playHand[1] / 4 > beatHand[1] / 4){
            System.out.println("Hand beaten");
            return true;
        }
        else if((playHand[1] / 4 == beatHand[1] / 4) && 
                (playHand[1] % 4 > beatHand[1] % 4)){
            System.out.println("Hand beaten2");
            return true;
        }
        else{
            System.out.println("Hand lost");
            return false;
        }
    }
    static boolean singleCheck(int [] playHand, int [] beatHand){
        if(playHand[0] > beatHand[0]){
            System.out.println("Hand won");
            return true;
        }
        else{
            System.out.println("Hand lost");
            return false;
        }
    }
    static boolean straightFlushCheck(int [] playHand, int [] beatHand){
        if(beatHand[3] / 4 == 11){
            if((playHand[4] / 4 > 3 && playHand[4] / 4 < 11)
                || playHand[3] / 4 == 3){
                return true;
            }
            else if(playHand[4] % 4 > beatHand[4] % 4){
                return true;
            }
            else{
                return false;
            }
        }
        else if(beatHand[4] / 4 == 12){
            if(playHand[4] / 4 == 12 && playHand[3] / 4 != 11){
                if(playHand[4] % 4 > beatHand[4] % 4){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(playHand[4] / 4 > 3 && playHand[4]/4 < 11){
                System.out.println("won");
                return true;
            }
            else{
                System.out.println("y");
                return false;
            }
        }
        else{
            if(playHand[4] / 4 > 10){
                //Hand lost.
                return false;
            }
            else{
                if(playHand[4] / 4 > beatHand[4] / 4){
                    System.out.println("Hand beaten3");
                    return true;
                }
                else{
                    if(playHand[4] / 4 == beatHand[4] / 4){
                        if(playHand[4] % 4 > beatHand [4] % 4){
                            System.out.println("Hand beaten4");
                            return true;
                        }
                        else{
                            System.out.println("Hand lost2");
                            return false;
                        }                            
                    }
                    else{
                        System.out.println("Hand lost3");
                        return false;
                    }
                }
            }
        }
    }
    static boolean fourCheck(int [] playHand, int [] beatHand){
        if(playHand[2] / 4 > beatHand[2] / 4){
            System.out.println("Hand won2");
            return true;
        }
        else{
            System.out.println("Hand lost");
            return false;
        }
    }
    static boolean fullHouseCheck(int [] playHand, int [] beatHand){
        if(playHand[2] / 4 > beatHand[2] / 4){
            System.out.println("Hand won2");
            return true;
        }
        else{
            System.out.println("Hand lost)");                        
            return false;
        }
    }
    static boolean flushCheck(int [] playHand, int [] beatHand){
        if(playHand[0] % 4 == beatHand[0] % 4){
            if(playHand[4] > beatHand[4]){
                System.out.println("Hand won2");
                return true;
            }
            else{
                System.out.println("Hand lost");
                return false;
            }
        }
        else if(playHand[0] % 4 > beatHand[0] % 4){
            System.out.println("Hand won3");
            return true;
        }
        else{
            System.out.println("Hand lost2");
            return false;
        }
    }
    static boolean straightCheck(int [] playHand, int [] beatHand){
        if(beatHand[3] / 4 == 11){
            if((playHand[4] / 4 > 3 && playHand[4] / 4 < 11) || 
                playHand[3] / 4 == 3){
                System.out.println("Hand beaten");
                return true;
            }
            else if(playHand[4] % 4 > beatHand[4] % 4){
                System.out.println("Hand beaten1");
                return true;
            }
            else{
                System.out.println("Hand lost");
                return false;
            }
        }
        else if(beatHand[4] / 4 == 12){
            if(playHand[4] / 4 > 3 && playHand[4] / 4 < 11){
                System.out.println("Hand beaten2");
                return true;
            }
            else if(playHand[4] / 4 == 12 && playHand[4] % 4 > 
                    beatHand[4] % 4){
                System.out.println("Hand beaten3");
                return true;
            }
            else{
                System.out.println("Hand lost");
                return false;
            }
        }
        else{
            if(playHand[4] / 4 > 10){
                //Hand lost.
                return false;
            }
            else{
                if(playHand[4] / 4 > beatHand[4] / 4){
                    System.out.println("Hand beaten4");
                    return true;
                }
                else if(playHand[4] / 4 == beatHand[4] / 4 && 
                        playHand[4] % 4 > beatHand[4] % 4){
                    System.out.println("Hand beaten5");
                    return true;
                }
                else{
                    System.out.println("Hand lost2");
                    return false;
                }
            }
        }
    }
    
    static void shuffle(int [] sDeck){
        Random rnd = new Random();
        for(int i = sDeck.length - 1; i > 0; i--){
            int index = rnd.nextInt(i+1);
            int a = sDeck[index];
            sDeck[index] = sDeck[i];
            sDeck[i] = a;
        }    
    }
    static void handCards(int [] a, int [] b, int [] c, int [] d, int [] deck){
        
        for(int i = 0, j = 0; i < deck.length; i += 4, j++){
            a[j] = deck[i];
            b[j] = deck[i+1];
            c[j] = deck[i+2];
            d[j] = deck[i+3];
        }
    }
    
    static void insertionSort(int [] hand){
        for(int i = 1; i < hand.length; i++){
            if(hand[i] != -1){               
                int temp = hand[i];
                int j;
                for(j = i - 1; j >= 0 && temp < hand[j]; j--){
                    hand[j+1] = hand[j];
                }
                hand[j+1] = temp;
            }
        }
    }
    
    static void newHand(int [] mainHand, int [] playHand, int [] beatHand){
        for(int i = 0; i < 5; i++){
            beatHand[i] = playHand[i];
        }
        for(int i = 0; i < 5; i++){
            int j = 0;
            while(j < 13){
                if(mainHand[j] == playHand[i]){
                    mainHand[j] = 999;
                }
                else{
                    //j++;
                }
                j++;
            }
        }
        insertionSort(mainHand);
    }
    
    static void reset(int [] playHand){
        for(int i = 0; i < 5; i++){
            playHand[i] = 0;
        }
    }
}
