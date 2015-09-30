
package cardswithfriends;

import java.util.*;

    public class GameSimulator {

    public static String [] cards = {"3-c", "3-s", "3-h", "3-d", "4-c", "4-s", 
    "4-h", "4-d", "5-c", "5-s", "5-h", "5-d", "6-c", "6-s", "6-h", "6-d", 
    "7-c", "7-s","7-h", "7-d", "8-c", "8-s", "8-h", "8-d", "9-c", "9-s", "9-h", 
    "9-d", "10-c","10-s", "10-h", "10-d", "Jack-c", "Jack-s", "Jack-h", 
    "Jack-d", "Queen-c", "Queen-s", "Queen-h", "Queen-d", "King-s", "King-s", 
    "King-h", "King-d", "Ace-c", "Ace-s", "Ace-h", "Ace-d", "2-c", "2-s", 
    "2-h", "2-d"};
    
    public static int [] playersDone = {0};
    public static boolean [] done = {false, false, false, false};
    public static boolean [] playAnything = new boolean[1];
    public static int [] p1 = new int [13];
    public static int [] p2 = new int [13];
    public static int [] p3 = new int [13];
    public static int [] p4 = new int [13];
    public static int [] beatHand = {999, 999, 999, 999, 999};
    
    
    public static int getPlayer2Cards(){
        int size = 0;
        for(int i = 0; i < 13;i++){
            if(p2[i] != 999){
                size++;
            }
        }
        return size;
    }
    public static int getPlayer3Cards(){
        int size = 0;
        for(int i = 0; i < 13;i++){
            if(p3[i] != 999){
                size++;
            }
        }
        return size;
    }
    public static int getPlayer4Cards(){
        int size = 0;
        for(int i = 0; i < 13;i++){
            if(p4[i] != 999){ 
                size++;
            }
        }
        return size;
    }
    public static int [] getPlayersCards(){
        return p1;
    }
    public static int [] getPot(){
        return beatHand;
    }
    
    public GameSimulator() {
        
        int [] deck = new int[52];
        for(int i = 0; i < 52; i++){
            deck[i] = i;
        }
        Display.start(deck);
    }
    

    static void playGame(int a, int [] first, int b, int [] second, int c, 
            int [] third, int d, int [] fourth){
        int [] pass = {0};
        //int [] beatHand = {999, 999, 999, 999, 999};
        int [] playHand = new int [5];
        playHand[0] = 0;
        playAnything[0] = true;
        int i = 0;
        while(playersDone[0] < 3){
            
            //System.out.println(pass[0]);
            if(i == 4){
                i = 0;
            }
            if((pass[0] + playersDone[0]) == 3){
                playAnything[0] = true;
            }
            if(i == 0){
                if(first[0] == 999){
                    if(!done[0]){
                        done[0] = true;
                        playersDone[0]++;
                        pass[0] = 0;
                        playAnything[0] = true;
                        System.out.println("Player " + a + " is done.");
                    }
                }
                else{
                    if(a == 1){
                        playerTurn(a, first, beatHand, playHand, pass);
                        if(first[0] == 999){
                            if(!done[0]){
                                done[0] = true;
                                playersDone[0]++;
                                pass[0] = 0;
                                playAnything[0] = true;
                                System.out.println("Player " + a + " is done.");
                            }
                        }
                    }
                    else{
                        /*
                        System.out.println("Player " + a);
                        for(int j = 0; j < 13; j++){
                            if(first[j] == 999){
                                break;
                            }
                            else{
                                printCard(first[j]);
                            }
                        }
                        System.out.println();
                                */
                        computerTurn(a, first, playHand, beatHand, pass);
                        if(first[0] == 999){
                            if(!done[0]){
                                done[0] = true;
                                playersDone[0]++;
                                pass[0] = 0;
                                playAnything[0] = true;
                                System.out.println("Player " + a + " is done.");
                            }
                        }
                        System.out.println("Enter 0 to continue");
                        Scanner sc = new Scanner(System.in);
                        int k = sc.nextInt();
                        while(k != 0){
                            k = sc.nextInt();
                        }
                    }
                }
            }
            else if(i == 1){
                if(second[0] == 999){
                    if(!done[1]){
                        done[1] = true;
                        playersDone[0]++;
                        pass[0] = 0;
                        playAnything[0] = true;
                        System.out.println("Player " + b + " is done.");
                    }
                }
                else{
                    if(b == 1){
                        playerTurn(b, second, beatHand, playHand, pass);
                        if(second[0] == 999){
                            if(!done[1]){
                                done[1] = true;
                                playersDone[0]++;
                                pass[0] = 0;
                                playAnything[0] = true;
                                System.out.println("Player " + b + " is done.");
                            }
                        }
                    }
                    else{
                        /*
                        System.out.println("Player " + b);
                        for(int j = 0; j < 13; j++){
                            if(second[j] == 999){
                                break;
                            }
                            else{
                                printCard(second[j]);
                            }
                        }
                        System.out.println();
                                */
                        computerTurn(b, second, playHand, beatHand, pass);
                        if(second[0] == 999){
                            if(!done[1]){
                                done[1] = true;
                                playersDone[0]++;
                                pass[0] = 0;
                                playAnything[0] = true;
                                System.out.println("Player " + b + " is done.");
                            }
                        }
                        System.out.println("Enter 0 to continue");
                        Scanner sc = new Scanner(System.in);
                        int k = sc.nextInt();
                        while(k != 0){
                            k = sc.nextInt();
                        }
                    }
                }
            }
            else if(i == 2){
                if(third[0] == 999){
                    if(!done[2]){
                        done[2] = true;
                        playersDone[0]++;
                        pass[0] = 0;
                        playAnything[0] = true;
                        System.out.println("Player " + c + " is done.");
                    }
                }
                else{
                    if(c == 1){
                        playerTurn(c, third, beatHand, playHand, pass);
                    }
                    else{
                        /*
                        System.out.println("Player " + c);
                        for(int j = 0; j < 13; j++){
                            if(third[j] == 999){
                                break;
                            }
                            else{
                                printCard(third[j]);
                            }
                        }
                        
                        System.out.println();
                                */
                        computerTurn(c, third, playHand, beatHand, pass);
                        if(third[0] == 999){
                            if(!done[2]){
                                done[2] = true;
                                playersDone[0]++;
                                pass[0] = 0;
                                playAnything[0] = true;
                                System.out.println("Player " + c + " is done.");
                            }
                        }
                        System.out.println("Enter 0 to continue");
                        Scanner sc = new Scanner(System.in);
                        int k = sc.nextInt();
                        while(k != 0){
                            k = sc.nextInt();
                        }
                    }
                }
            }
            else{
                if(fourth[0] == 999){
                    if(!done[3]){
                        done[3] = true;
                        playersDone[0]++;
                        pass[0] = 0;
                        playAnything[0] = true;
                        System.out.println("Player " + d + " is done.");
                    }
                }
                else{
                    if(d == 1){
                        playerTurn(d, fourth, beatHand, playHand, pass);
                        if(fourth[0] == 999){
                            if(!done[3]){
                                done[3] = true;
                                playersDone[0]++;
                                pass[0] = 0;
                                playAnything[0] = true;
                                System.out.println("Player " + d + " is done.");
                            }
                        }
                    }
                    else{
                        /*
                        System.out.println("Player " + d);
                        for(int j = 0; j < 13; j++){
                            if(fourth[j] == 999){
                                break;
                            }
                            else{
                                printCard(fourth[j]);
                            }
                        }
                        System.out.println();
                                */
                        computerTurn(d, fourth, playHand, beatHand, pass);
                        if(fourth[0] == 999){
                            if(!done[3]){
                                done[3] = true;
                                playersDone[0]++;
                                pass[0] = 0;
                                playAnything[0] = true;
                                System.out.println("Player " + d + " is done.");
                            }
                        }
                        System.out.println("Enter 0 to continue");
                        Scanner sc = new Scanner(System.in);
                        int k = sc.nextInt();
                        while(k != 0){
                            k = sc.nextInt();
                        }
                    }
                }
            }
            i++;
        }
    }
    static void playerTurn(int id, int [] hand, int [] beatHand, 
            int [] playHand, int [] pass){
        boolean beaten = false;
        playHand[0] = -1;
        if((pass[0] + playersDone[0]) == 3){
            pass[0] = 0;
            System.out.println("Everyone passed. You control the table.");
            playAnything[0] = true;
        }
        if(hand[0] != 999){
            System.out.println("Hand to beat.");
            for(int i = 0; i < 5; i++){
                printCard(beatHand[i]);
            }
            System.out.println();
            while(playHand[0] != 999 && !beaten){
                enterHand(id, hand, playHand, pass, beatHand);
                beaten = beatChecker(playHand, beatHand, hand);
                if(beaten){
                    pass[0] = 0;
                }
            }
            beaten = false;
            playAnything[0] = false;
        }
        else{
        }
    }
    static void enterHand(int pID, int [] hand, int [] playHand, int [] pass, 
            int [] beatHand){
        int [] input = new int [5];
        System.out.println("Player " + pID);
        for(int i = 0; i < 13; i++){
            if(hand[i] == 999){
                break;
            }
            else{
                printCard(hand[i]);
            }
        }
        System.out.println();
        System.out.println("Enter the card's index you want to play. "
                + "Enter 999 to pass or when done.");
        int i = 0;
        while(i < 5){
            Scanner sc = new Scanner(System.in);
            int b = sc.nextInt();
            if(i == 0 && b == 999 && playAnything[0]){
                System.out.println("You cannot pass as you control the table.");
                playHand[0] = 999;
                return;
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
            pass[0]++;
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
        }
    }
    static boolean beatChecker(int [] playHand, int [] beatHand,
            int [] mainHand){
        if(playHand[0] == 999 && !playAnything[0]){
            System.out.println("Passed");
            return false;
        }
        if(playHand[0] == 999){
            reset(playHand);
            return false;
        }
        else if(mainHand[0] == 0 && playHand[0] != 0){
            System.out.println("You must have the 3 of spades in your hand.");
            reset(playHand);
            return false;
        }
        else{
            HandChecker bHand = new HandChecker(beatHand);
            HandChecker pHand = new HandChecker(playHand);
            if(playAnything[0]){
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
    
    
    static void computerTurn(int id, int [] hand, int [] playHand, 
            int [] beatHand, int [] pass){
        if(hand[0] == 0){
            playHand[0] = hand[0];
            for(int i = 1; i < 5; i++){
                playHand[i] = 999;
            }
            newHand(hand, playHand, beatHand);
            reset(playHand);
            playAnything[0] = false;
            pass[0] = 0;
            printBeatHand(id, beatHand);
            return;
        }
        int size;
        for(size = 0; size < 13; size++){
            if(hand[size] == 999){
                break;
            }
        }
        if(playAnything[0]){
            if(hand[4] != 999){
                if(cStraightFlush(hand, playHand, beatHand, size, pass)){
                    playAnything[0] = false;
                    pass[0] = 0;
                    newHand(hand, playHand, beatHand);
                    reset(playHand);
                    printBeatHand(id, beatHand);              
                }
                else if(cFour(hand, playHand, beatHand, size, pass)){
                    playAnything[0] = false;
                    pass[0] = 0;
                    newHand(hand, playHand, beatHand);
                    reset(playHand);
                    printBeatHand(id, beatHand);  
                }
                else if(cFullHouse(hand, playHand, beatHand, size, pass)){
                    playAnything[0] = false;
                    pass[0] = 0;
                    newHand(hand, playHand, beatHand);
                    reset(playHand);
                    printBeatHand(id, beatHand); 
                }
                else if(cFlush(hand, playHand, beatHand, size, pass)){
                    playAnything[0] = false;
                    pass[0] = 0;
                    newHand(hand, playHand, beatHand);
                    reset(playHand);
                    printBeatHand(id, beatHand); 
                }
                else if(cStraight(hand, playHand, beatHand, size, pass)){
                    playAnything[0] = false;
                    pass[0] = 0;
                    newHand(hand, playHand, beatHand);
                    reset(playHand);
                    printBeatHand(id, beatHand); 
                }
            }
            if(cThree(hand, playHand, beatHand, size, pass)){  
                playAnything[0] = false;
                pass[0] = 0;
                newHand(hand, playHand, beatHand);
                reset(playHand);
                printBeatHand(id, beatHand); 
            }
            else if(cPair(hand, playHand, beatHand, size, pass)){
                playAnything[0] = false;
                pass[0] = 0;
                newHand(hand, playHand, beatHand);
                reset(playHand);
                printBeatHand(id, beatHand); 
            }
            else{
                playAnything[0] = false;
                pass[0] = 0;
                playHand[0] = hand[0]; 
                for(int i = 1; i < 5; i++){
                    playHand[i] = 999;
                }
                newHand(hand, playHand, beatHand);
                reset(playHand);
                printBeatHand(id, beatHand);  
            }
        }
        else{
            HandChecker bHand = new HandChecker(beatHand);
            if(bHand.getHandID() == 1){
                for(int i = 0; i < size; i++){
                    if(hand[i] > beatHand[0]){
                        playHand[0] = hand[i];
                        for(int j = 1; j < 5; j++){
                            playHand[j] = 999;
                        }
                        playAnything[0] = false;
                        pass[0] = 0;
                        newHand(hand, playHand, beatHand);
                        reset(playHand);
                        printBeatHand(id, beatHand); 
                        return;
                    }
                } 
                System.out.println("Player " + id + " passed.");
                pass[0]++;
                reset(playHand);
            }
            else if(bHand.getHandID() == 2){
                for(int i = 0; i < size - 1; i++){
                    playHand[0] = hand[i];
                    playHand[1] = hand[i+1];
                    playHand[2] = 999;
                    playHand[3] = 999;
                    playHand[4] = 999;
                    HandChecker cHand = new HandChecker(playHand);
                    if(cHand.getHandID() == 2){
                        if(playHand[1] > beatHand[1]){
                            playAnything[0] = false;
                            pass[0] = 0;
                            newHand(hand, playHand, beatHand);
                            reset(playHand);
                            printBeatHand(id, beatHand); 
                            return;
                        }
                    }
                }
                System.out.println("Player " + id + " passed.");
                pass[0]++;
                reset(playHand);
            }
            else if(bHand.getHandID() == 3){
                for(int i = 0; i < size - 2; i++){
                    playHand[0] = hand[i];
                    playHand[1] = hand[i+1];
                    playHand[2] = hand[i+2];
                    playHand[3] = 999;
                    playHand[4] = 999;
                    HandChecker cHand = new HandChecker(playHand);
                    if(cHand.getHandID() == 3){
                        if(playHand[0] > beatHand[0]){
                            playAnything[0] = false;
                            pass[0] = 0;
                            newHand(hand, playHand, beatHand);
                            reset(playHand);
                            printBeatHand(id, beatHand); 
                        }
                    }
                }
                System.out.println("Player " + id + " passed.");
                pass[0]++;
                reset(playHand);
            }
            else{
                if(bHand.getHandID() == 4){
                    int [] checkHand = {hand[0], hand[1], hand[2], 
                        hand[size - 2], hand[size - 1]};
                    HandChecker cHand = new HandChecker(checkHand);
                    if(cHand.getHandID() == 4){
                        for(int i = 0; i < 5; i++){
                            playHand[i] = checkHand[i];
                        }
                        if(straightCheck(playHand, beatHand)){
                            playAnything[0] = false;
                            pass[0] = 0;
                            newHand(hand, playHand, beatHand);
                            reset(playHand);
                            printBeatHand(id, beatHand); 
                            return;
                        }
                    }
                    checkHand[3] = hand[3];
                    cHand = new HandChecker(checkHand);
                    if(cHand.getHandID() == 4){
                        for(int i = 0; i < 5; i++){
                            playHand[i] = checkHand[i];
                        }
                        if(straightCheck(playHand, beatHand)){
                            playAnything[0] = false;
                            pass[0] = 0;
                            newHand(hand, playHand, beatHand);
                            reset(playHand);
                            printBeatHand(id, beatHand); 
                            return;
                        }
                    }
                    for(int i = 0; i < size - 4; i++){
                        checkHand = new int [5];
                        checkHand[0] = hand[i];
                        checkHand[1] = hand[i+1];
                        checkHand[2] = hand[i+2];
                        checkHand[3] = hand[i+3];
                        checkHand[4] = hand[i+4];
                        cHand = new HandChecker(checkHand);
                        if(cHand.getHandID() == 4){
                            for(int j = 0; j < 5; j++){
                                playHand[j] = checkHand[j];
                            }
                            if(straightCheck(playHand, beatHand)){
                                playAnything[0] = false;
                                pass[0] = 0;
                                newHand(hand, playHand, beatHand);
                                reset(playHand);
                                printBeatHand(id, beatHand); 
                                return;
                            }
                        }
                    }
                    if(cFlush(hand, playHand, beatHand, size, pass) || 
                       cFullHouse(hand, playHand, beatHand, size, pass) || 
                       cFour(hand, playHand, beatHand, size, pass) || 
                       cStraightFlush(hand, playHand, beatHand, size, pass)){
                        playAnything[0] = false;
                        pass[0] = 0;
                        newHand(hand, playHand, beatHand);
                        reset(playHand);
                        printBeatHand(id, beatHand);  
                    }
                    else{
                        System.out.println("Player " + id + " passed.");
                        pass[0]++;
                        reset(playHand);
                    }
                }
                else if(bHand.getHandID() == 5){
                    for(int i = 0; i < 5; i++){
                        int flushNum = 0;
                        for(int j = 0; j < size - 1; j++){
                            if(hand[j] != 999){
                                if(hand[j] % 4 == i){
                                    playHand[flushNum] = hand[j];
                                    flushNum++;
                                }
                            }
                            if(flushNum == 5){
                                if(flushCheck(playHand, beatHand)){
                                    playAnything[0] = false;
                                    pass[0] = 0;
                                    newHand(hand, playHand, beatHand);
                                    reset(playHand);
                                    printBeatHand(id, beatHand);
                                    return;
                                }
                            }
                        }
                    }
                    if(cFullHouse(hand, playHand, beatHand, size, pass) || 
                       cFour(hand, playHand, beatHand, size, pass) || 
                       cStraightFlush(hand, playHand, beatHand, size, pass)){
                        playAnything[0] = false;
                        pass[0] = 0;
                        newHand(hand, playHand, beatHand);
                        reset(playHand);
                        printBeatHand(id, beatHand); 
                    }
                    else{
                        System.out.println("Player " + id + " passed.");
                        pass[0]++;
                        reset(playHand);
                    }
                }
                else if(bHand.getHandID() == 6){
                    for(int i = 0; i < size - 4; i++){
                        int [] checkHand = new int[5];
                        checkHand[0] = hand[i];
                        checkHand[1] = hand[i+1];
                        checkHand[2] = hand[i+2];
                        checkHand[3] = 999;
                        checkHand[4] = 999;
                        HandChecker cHand = new HandChecker(checkHand);
                        if(cHand.getHandID() == 3){
                            for(int j = 0; j < 3; j++){
                                playHand[j] = checkHand[j];
                            }
                            for(int j = 0; j < size - 1; j++){
                                if(hand[j] == playHand[0]){
                                    j = j + 2;
                                }
                                else{
                                    checkHand = new int[5];
                                    checkHand[0] = hand[j];
                                    checkHand[1] = hand[j+1];
                                    checkHand[2] = 999;
                                    checkHand[3] = 999;
                                    checkHand[4] = 999;
                                    cHand = new HandChecker(checkHand);
                                    if(cHand.getHandID() == 2){
                                        playHand[3] = checkHand[0]; 
                                        playHand[4] = checkHand[1];
                                        insertionSort(playHand);
                                        if(fullHouseCheck(playHand, beatHand)){
                                            playAnything[0] = false;
                                            pass[0] = 0;
                                            newHand(hand, playHand, beatHand);
                                            reset(playHand);
                                            printBeatHand(id, beatHand);  
                                            return;
                                        }
                                    }  
                                }
                            }
                        }
                    }
                    if(cFour(hand, playHand, beatHand, size, pass) || 
                       cStraightFlush(hand, playHand, beatHand, size, pass)){
                        playAnything[0] = false;
                        pass[0] = 0;
                        newHand(hand, playHand, beatHand);
                        reset(playHand);
                        printBeatHand(id, beatHand); 
                    }
                    else{
                        System.out.println("Player " + id + " passed.");
                        pass[0]++;
                        reset(playHand);
                    }
                }
                else if(bHand.getHandID() == 7){
                    for(int i = 0; i < size - 4; i++){
                        int [] checkHand = new int [5];
                        checkHand[0] = hand[i];
                        checkHand[1] = hand[i+1];
                        checkHand[2] = hand[i+2];
                        checkHand[3] = hand[i+3];
                        checkHand[4] = hand[i+4];
                        HandChecker cHand = new HandChecker(checkHand);
                        if(cHand.getHandID() == 7){
                            for(int j = 0; j < 5; j++){
                                playHand[j] = checkHand[j];
                            }
                            if(fourCheck(playHand, beatHand)){
                                playAnything[0] = false;
                                pass[0] = 0;
                                newHand(hand, playHand, beatHand);
                                reset(playHand);
                                printBeatHand(id, beatHand);
                                return;
                            }
                        }
                    }
                    if(cStraightFlush(hand, playHand, beatHand, size, pass)){
                        playAnything[0] = false;
                        pass[0] = 0;
                        newHand(hand, playHand, beatHand);
                        reset(playHand);
                        printBeatHand(id, beatHand); 
                    }
                }
                else if(bHand.getHandID() == 8){
                    int [] checkHand = {hand[0], hand[1], hand[2], 
                        hand[size - 2], hand[size - 1]};
                    HandChecker cHand = new HandChecker(checkHand);
                    if(cHand.getHandID() == 8){
                        for(int i = 0; i < 5; i++){
                            playHand[i] = checkHand[i];
                        }
                        if(straightFlushCheck(playHand, beatHand)){
                            playAnything[0] = false;
                            pass[0] = 0;
                            newHand(hand, playHand, beatHand);
                            reset(playHand);
                            printBeatHand(id, beatHand);
                            return;
                        }
                    }
                    checkHand[3] = hand[3];
                    cHand = new HandChecker(checkHand);
                    if(cHand.getHandID() == 8){
                        for(int i = 0; i < 5; i++){
                        playHand[i] = checkHand[i];
                        }
                        if(straightFlushCheck(playHand, beatHand)){
                            playAnything[0] = false;
                            pass[0] = 0;
                            newHand(hand, playHand, beatHand);
                            reset(playHand);
                            printBeatHand(id, beatHand);
                            return;
                        }
                    }
                    for(int i = 0; i < size - 4; i++){
                        checkHand = new int [5];
                        checkHand[0] = hand[i];
                        checkHand[1] = hand[i+1];
                        checkHand[2] = hand[i+2];
                        checkHand[3] = hand[i+3];
                        checkHand[4] = hand[i+4];
                        cHand = new HandChecker(checkHand);
                        if(cHand.getHandID() == 8){
                            for(int j = 0; j < 5; j++){
                                playHand[j] = checkHand[j];
                            }
                            if(straightFlushCheck(playHand, beatHand)){
                                playAnything[0] = false;
                                pass[0] = 0;
                                newHand(hand, playHand, beatHand);
                                reset(playHand);
                                printBeatHand(id, beatHand); 
                                return;
                            }
                        }
                    }
                    System.out.println("Player " + id + " passed.");
                    pass[0]++;
                    reset(playHand);
                }
                else{
                    System.out.println("Player " + id + " passed.");
                    pass[0]++;
                    reset(playHand);
                }
            }
        }
    }
    static boolean threeCheck(int [] playHand, int [] beatHand){
        if(playHand[2] / 4 > beatHand[2] / 4){
            return true;
        }
        else{
            return false;
        }
    }
    static boolean pairCheck(int [] playHand, int [] beatHand){
        if(playHand[1] / 4 > beatHand[1] / 4){
            return true;
        }
        else if((playHand[1] / 4 == beatHand[1] / 4) && 
                (playHand[1] % 4 > beatHand[1] % 4)){
            return true;
        }
        else{
            return false;
        }
    }
    static boolean singleCheck(int [] playHand, int [] beatHand){
        if(playHand[0] > beatHand[0]){
            return true;
        }
        else{
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
                return true;
            }
            else{
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
                    return true;
                }
                else{
                    if(playHand[4] / 4 == beatHand[4] / 4){
                        if(playHand[4] % 4 > beatHand [4] % 4){
                            return true;
                        }
                        else{
                            return false;
                        }                            
                    }
                    else{
                        return false;
                    }
                }
            }
        }
    }
    static boolean fourCheck(int [] playHand, int [] beatHand){
        if(playHand[2] / 4 > beatHand[2] / 4){
            return true;
        }
        else{
            return false;
        }
    }
    static boolean fullHouseCheck(int [] playHand, int [] beatHand){
        if(playHand[2] / 4 > beatHand[2] / 4){
            return true;
        }
        else{
            return false;
        }
    }
    static boolean flushCheck(int [] playHand, int [] beatHand){
        if(playHand[0] % 4 == beatHand[0] % 4){
            if(playHand[4] > beatHand[4]){
                return true;
            }
            else{
                return false;
            }
        }
        else if(playHand[0] % 4 > beatHand[0] % 4){
            return true;
        }
        else{
            return false;
        }
    }
    static boolean straightCheck(int [] playHand, int [] beatHand){
        if(beatHand[3] / 4 == 11){
            if((playHand[4] / 4 > 3 && playHand[4] / 4 < 11) || 
                playHand[3] / 4 == 3){
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
            if(playHand[4] / 4 > 3 && playHand[4] / 4 < 11){
                return true;
            }
            else if(playHand[4] / 4 == 12 && playHand[4] % 4 > 
                    beatHand[4] % 4){
                return true;
            }
            else{
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
                    return true;
                }
                else if(playHand[4] / 4 == beatHand[4] / 4 && 
                        playHand[4] % 4 > beatHand[4] % 4){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }
    static boolean cStraightFlush(int [] hand, int [] playHand, int [] beatHand,
            int size, int [] pass){
        int [] checkHand = {hand[0], hand[1], hand[2], hand[size - 2], 
                hand[size - 1]};
            HandChecker cHand = new HandChecker(checkHand);
            if(cHand.getHandID() == 8){
                for(int i = 0; i < 5; i++){
                    playHand[i] = checkHand[i];
                }
                return true;
            }
            checkHand[3] = hand[3];
            cHand = new HandChecker(checkHand);
            if(cHand.getHandID() == 8){
                for(int i = 0; i < 5; i++){
                playHand[i] = checkHand[i];
                }
                return true;
            }
            for(int i = 0; i < size - 4; i++){
                checkHand = new int [5];
                checkHand[0] = hand[i];
                checkHand[1] = hand[i+1];
                checkHand[2] = hand[i+2];
                checkHand[3] = hand[i+3];
                checkHand[4] = hand[i+4];
                cHand = new HandChecker(checkHand);
                if(cHand.getHandID() == 8){
                    for(int j = 0; j < 5; j++){
                        playHand[j] = checkHand[j];
                    }
                    return true;
                }
            }
            return false;
    }
    static boolean cFour(int [] hand, int [] playHand, int [] beatHand, 
            int size, int [] pass){
        for(int i = 0; i < size - 4; i++){
            int [] checkHand = new int [5];
            checkHand[0] = hand[i];
            checkHand[1] = hand[i+1];
            checkHand[2] = hand[i+2];
            checkHand[3] = hand[i+3];
            checkHand[4] = hand[i+4];
            HandChecker cHand = new HandChecker(checkHand);
            if(cHand.getHandID() == 7){
                for(int j = 0; j < 5; j++){
                    playHand[j] = checkHand[j];
                }
                return true;
            }
        }
        return false;
    }
    static boolean cFullHouse(int [] hand, int [] playHand, int [] beatHand,
            int size, int [] pass){
        for(int i = 0; i < size - 2; i++){
            int [] checkHand = new int[5];
            checkHand[0] = hand[i];
            checkHand[1] = hand[i+1];
            checkHand[2] = hand[i+2];
            checkHand[3] = 999;
            checkHand[4] = 999;
            HandChecker cHand = new HandChecker(checkHand);
            if(cHand.getHandID() == 3){
                for(int j = 0; j < 3; j++){
                    playHand[j] = checkHand[j];
                }
                for(int j = 0; j < size - 1; j++){
                    if(hand[j] == playHand[0]){
                        j = j + 2;
                    }
                    else{
                        checkHand = new int[5];
                        checkHand[0] = hand[j];
                        checkHand[1] = hand[j+1];
                        checkHand[2] = 999;
                        checkHand[3] = 999;
                        checkHand[4] = 999;
                        cHand = new HandChecker(checkHand);
                        if(cHand.getHandID() == 2){
                            playHand[3] = checkHand[0]; 
                            playHand[4] = checkHand[1];
                            insertionSort(playHand);
                            return true;
                        }  
                    }
                }
            }
        }
        return false;
    }
    static boolean cFlush(int [] hand, int [] playHand, int [] beatHand, 
            int size, int [] pass){
        for(int i = 0; i < 5; i++){
            int flushNum = 0;
            for(int j = 0; j < size - 1; j++){
                if(hand[j] != 999){
                    if(hand[j] % 4 == i){
                        playHand[flushNum] = hand[j];
                        flushNum++;
                    }
                }
                if(flushNum == 5){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean cStraight(int [] hand, int [] playHand, int [] beatHand,
            int size, int [] pass){
        int [] checkHand = {hand[0], hand[1], hand[2], hand[size - 2], 
                hand[size - 1]};
            HandChecker cHand = new HandChecker(checkHand);
            if(cHand.getHandID() == 4){
                for(int i = 0; i < 5; i++){
                    playHand[i] = checkHand[i];
                }
                return true;
            }
            checkHand[3] = hand[3];
            cHand = new HandChecker(checkHand);
            if(cHand.getHandID() == 4){
                for(int i = 0; i < 5; i++){
                playHand[i] = checkHand[i];
                }
                return true;
            }
            for(int i = 0; i < size - 4; i++){
                checkHand = new int [5];
                checkHand[0] = hand[i];
                checkHand[1] = hand[i+1];
                checkHand[2] = hand[i+2];
                checkHand[3] = hand[i+3];
                checkHand[4] = hand[i+4];
                cHand = new HandChecker(checkHand);
                if(cHand.getHandID() == 4){
                    for(int j = 0; j < 5; j++){
                        playHand[j] = checkHand[j];
                    }
                    return true;
                }
            }
            return false;
    }
    static boolean cThree(int [] hand, int [] playHand, int [] beatHand, 
            int size, int [] pass){
        for(int i = 0; i < size - 2; i++){
            int [] checkHand = new int[5];
            checkHand[0] = hand[i];
            checkHand[1] = hand[i+1];
            checkHand[2] = hand[i+2];
            checkHand[3] = 999;
            checkHand[4] = 999;
            HandChecker cHand = new HandChecker(checkHand);
            if(cHand.getHandID() == 3){
                for(int j = 0; j < 5; j++){
                    playHand[j] = checkHand[j];
                }
                return true;
            }
        }
        return false;
    }
    static boolean cPair(int [] hand, int [] playHand, int [] beatHand, 
            int size, int [] pass){
        for(int i = 0; i < size - 1; i++){
            int [] checkHand = new int[5];
            checkHand[0] = hand[i];
            checkHand[1] = hand[i+1];
            checkHand[2] = 999;
            checkHand[3] = 999;
            checkHand[4] = 999;
            HandChecker cHand = new HandChecker(checkHand);
            if(cHand.getHandID() == 2){
                for(int j = 0; j < 5; j++){
                    playHand[j] = checkHand[j];
                }
                return true;
            }
        }
        return false;
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
    static void printCard(int index){
        if(index != 999){
            System.out.print(cards[index] + " ");
        }
    }
    static void printBeatHand(int id, int [] beatHand){
        System.out.println("Player " + id + " played:");
        for(int j = 0; j < 5; j++){
            if(beatHand[j] == 999){
                break;
            }
            else{
                printCard(beatHand[j]);
            }
        } 
        System.out.println();
    }
}
