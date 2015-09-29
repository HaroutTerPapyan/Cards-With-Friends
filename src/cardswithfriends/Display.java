package cardswithfriends;

import java.applet.*;
import java.awt.*;


public class Display extends Applet{

   TextField tf;


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
      setLayout(new BorderLayout());
      setBackground(Color.GREEN);
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
      g.drawString("P2 has " + /*getPlayer2Cards() +*/ " cards.",0,10);
      g.drawString("P3 has " + /*getPlayer3Cards() +*/ " cards.",0,35);
      g.drawString("P4 has " + /*getPlayer4Cards() +*/ " cards.",0,60);
   }

}
