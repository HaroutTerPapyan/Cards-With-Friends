package cardswithfriends;

import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Display extends Applet implements ActionListener{

   TextField tf;
   String play;

   Image[] playerHandImage = new Image[13];
   Image[] potImage = new Image[5];


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
       button2.setBounds(300,400,100,50);
       button2.addActionListener(this);
       
       setLayout(new BorderLayout());
   }

   public void paint(Graphics g)
   {
    //g.setColor(Color.GREEN); //font color
    int [] playerHand = getPlayersCards();
    int [] pot = getPot();
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
      g.drawString("P2 has " + getPlayer2Cards() + " cards.",0,10);
      g.drawString("P3 has " + getPlayer3Cards() + " cards.",0,35);
      g.drawString("P4 has " + getPlayer4Cards() + " cards.",0,60);
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
        else
            System.out.println("Button 2 was pressed: PASS");
    }
    Button button1, button2;


    public int[] getPlayersCards() {
        int [] hand = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        return hand;
    }

    public int[] getPot() {
        int[] pot = {1,2,3,4,5};
        return pot;
    }

    public String getPrompt() {
        return "hi";
    }

    public int getPlayer2Cards() {
        return 4;
    }
    public int getPlayer3Cards() {
        return 6;
    }
    public int getPlayer4Cards() {
        return 2;
    }
}
