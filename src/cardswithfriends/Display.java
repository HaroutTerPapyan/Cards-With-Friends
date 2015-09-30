package cardswithfriends;

import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;

public class Display extends Applet implements ActionListener{

   static TextField tf;
   String play;

   Image[] playerHandImage = new Image[13];
   Image[] potImage = new Image[5];
   
   static int[] deck = new int[52];
    static GameSimulator gs;

    public static int [] p1 = new int [13];
    public static int [] p2 = new int [13];
    public static int [] p3 = new int [13];
    public static int [] p4 = new int [13];


   public void init()
   {


      for (int i = 0; i < 13; i++)
         playerHandImage[i] = getImage(getDocumentBase(), "blank.jpg");
      for (int i = 0; i < 5; i++)
         potImage[i] = getImage(getDocumentBase(), "blank.jpg");
      tf = new TextField("");
      add(tf);
      tf.setBounds(0,400,100,20);

      setBackground(Color.GREEN);

       button1 = new Button("Play");
       add(button1);
       button1.setBounds(150,400,100,50);
       button1.addActionListener(this);

       button2 = new Button("Pass");
       add(button2);
       button2.setBounds(300, 400, 100, 50);
       button2.addActionListener(this);

       button3 = new Button("START GAME");
       add(button3);
       button3.setBounds(500, 400, 100, 50);
       button3.addActionListener(this);


       setLayout(new BorderLayout());


   }

   public void paint(Graphics g)
   {
       
    //g.setColor(Color.GREEN); //font color
    int [] playerHand = playerOne(p1);
    int [] pot = GameSimulator.getPot();
  //  int k = 0;
  //  while (k < 13) {
 //       if (k < 999) {
  //          playerHandImage[k] = getImage(getDocumentBase(), playerHand[k] + ".jpg");
  //          k++;
//        }
/*
        else {
            playerHandImage[k] = getImage(getDocumentBase(), "blank.jpg");
            k++;
        }
*/
 //   }

      for (int i = 0; i < 13; i++) {
         if (playerHand[i] != 999)
            playerHandImage[i] = getImage(getDocumentBase(), playerHand[i] + ".jpg");
         else playerHandImage[i] = getImage(getDocumentBase(), "blank.jpg");
         }

      for (int i = 0; i < 5; i++)
         potImage[i] = getImage(getDocumentBase(), pot[i] + ".jpg");
         
      for (int i = 0; i < 5; i++)
         g.drawImage(potImage[i], (i * 80 + 540), 0, this);
      for (int i = 0; i < 13; i++)
         g.drawImage(playerHandImage[i], i * 80 + 1, 150, this);
      g.drawString(getPrompt(),0,300);
      g.drawString("P2 has " + GameSimulator.getPlayer2Cards() + " cards.",0,10);
      g.drawString("P3 has " + GameSimulator.getPlayer3Cards() + " cards.",0,35);
      g.drawString("P4 has " + GameSimulator.getPlayer4Cards() + " cards.",0,60);
   }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
             play = tf.getText();
             System.out.println(play);
             //todo
             /*
             send String to GameSimulator and update/play hand
             CLEAR 
             */
             }
        else if(e.getSource() == button2) {
            System.out.println("Button 2 was pressed: PASS");
        }
        else {
            gs = new GameSimulator();
        }
    }

    Button button1, button2, button3;

//Dummy methods
/*
    public int[] getPlayersCards() {
        int [] hand = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        return hand;
    }
*/
/*
    public int[] getPot() {
        int[] pot = {1,2,3,4,5};
        return pot;
    }
*/
    public String getPrompt() {
        return "hi";
    }



/*
    public int getPlayer2Cards() { return 4; }
    public int getPlayer3Cards() { return 6; }
    public int getPlayer4Cards() { return 2; }
 */

    public static void start(int [] deck){
        Scanner sc = new Scanner(tf.getText());
        System.out.println("Enter 0 to play.");
        int play = sc.nextInt();
        while(play == 0){
            GameSimulator.shuffle(deck);
            GameSimulator.handCards(p1, p2, p3, p4, deck);
            GameSimulator.insertionSort(p1);
            GameSimulator.insertionSort(p2);
            GameSimulator.insertionSort(p3);
            GameSimulator.insertionSort(p4);
            if(p1[0] == 0){
                System.out.println("Player 1 goes first.");
                GameSimulator.playGame(1, p1, 2, p2, 3, p3, 4, p4);
            }
            else if(p2[0] == 0){
                System.out.println("Player 2 goes first.");
                GameSimulator.playGame(2, p2, 3, p3, 4, p4, 1, p1);
            }
            else if(p3[0] == 0){
                System.out.println("Player 3 goes first.");
                GameSimulator.playGame(3, p3, 4, p4, 1, p1, 2, p2);
            }
            else{
                System.out.println("Player 4 goes first.");
                GameSimulator.playGame(4, p4, 1, p1, 2, p2, 3, p3);
            }
            System.out.println("Game Over");
            System.out.println("Enter 0 to play again.");
            play = sc.nextInt();
        }
    }

    public static int [] getPlayersCards(int[] player){
        //GameSimulator.shuffle(deck);
        //handCards(p1, p2, p3, p4, deck);
        playerOne(player);
        return player;
    }

    static int[] handCards(int [] a, int [] b, int [] c, int [] d, int [] deck){

        for(int i = 0, j = 0; i < deck.length; i += 4, j++){
            a[j] = deck[i];
            b[j] = deck[i+1];
            c[j] = deck[i+2];
            d[j] = deck[i+3];
        }
        return a;
    }




    public static int[] playerOne(int[] poDeck) {
        System.out.println();
        //p1 0-12
        for (int i = 0; i <= 12; i++) {
            poDeck[i] = deck[i];
            //System.out.println(poDeck[i]);
        }
        return poDeck;
    }
}
