package cardswithfriends;

public class HandChecker {
    
    private int [] hand = new int[5];
    private int handID;
    public HandChecker(){  
        hand = null;
        handID = 0;
    }
    public HandChecker(int [] played){
        for(int i = 0; i < 5; i++){
            this.hand[i] = played[i];
        }
        if(this.hand[4] != 999){
            boolean straight = straightCheck(this.hand);
            boolean flush = flushCheck(this.hand);
            if(straight && flush){
                this.handID = 8;
            }
            else if(fourCheck(this.hand)){
                this.handID = 7;
            }
            else if(fullHouseCheck(this.hand)){
                this.handID = 6;
            }
            else if(flush){
                this.handID = 5; 
            }
            else if(straight){
                this.handID = 4;
            }
            else{
                this.handID = 0;
            }
        }
        else if(this.hand[2] != 999){
            if(threeCheck(this.hand)){
                this.handID = 3;
            }
            else{
                this.handID = 0;
            }
        }
        else if(this.hand[1] != 999){
            if(pairCheck(this.hand)){
                this.handID = 2;
            }
            else{
                this.handID = 0;
            }
        }
        else{
            if(this.hand[0] != 999){
                this.handID = 1;
            }
            else{
                this.handID = 0;
            }
        }
    }
    public int[] getHand(){
        return this.hand;
    }
    public int getHandID(){
        return this.handID;
    }
      
    private static boolean pairCheck(int [] hand){
        if((hand[0] / 4) == (hand[1] / 4)){
            return true;
        }
        else{
            return false;
        }
    }
    private static boolean threeCheck(int [] hand){
        if((hand[0] / 4) == (hand[2] / 4)){
            return true;
        }
        else{
            return false;
        }
    }
    private static boolean straightCheck(int [] hand){
        if((hand[1]/4) == 11 || (hand[2]/4) == 11){
            return false;
        }
        else if(((hand[0] / 4) + 1 == hand[1] / 4 && (hand[1] / 4) + 1 
                == hand[2] / 4 && hand[3] / 4 == 11 && 
                hand[4] / 4 == 12) || ((hand[0] / 4) + 1 == 
                hand[1] / 4 && (hand[1] / 4) +1 == hand[2] / 4 && 
                (hand[2] / 4) + 1 == hand[3] / 4 && hand[4] / 4 == 12)){
            return true;
        }
        else if((hand[0] / 4) + 1 == (hand[1] /4) && (hand[1] / 4) + 1  
                == (hand[2] / 4) && (hand[2] / 4 ) + 1 == (hand[3] / 4)
                && (hand[3] / 4) + 1 == (hand[4] / 4)){
            return true;        
        }
        else{
            return false;
        }
    }
    private static boolean flushCheck(int [] hand){
        if(hand[0] % 4 == hand[1] % 4 && hand[1] % 4 == hand[2] % 4 &&
           hand[2] % 4 == hand[3] % 4 && hand[3] % 4 == hand[4] % 4){
            return true;
        }
        else{
            return false;
        }
    }
    private static boolean fullHouseCheck(int [] hand){
        if((hand[0] / 4 == hand[1] / 4 && hand[2] / 4 == hand[4] / 4) 
            || (hand[0] / 4 == hand[2] / 4 && hand[3] / 4 == hand[4] / 4)){
            return true;
        }
        else{
            return false;
        }
    }
    private static boolean fourCheck(int [] hand){
        if((hand[0] / 4 == hand[1] / 4 && hand[1] / 4 == hand[2] / 4 && 
            hand[2] / 4 == hand[3] / 4) || (hand[1] / 4 == hand[2] / 4 &&
            hand[2] / 4 == hand[3] / 4 && hand[3] / 4 == hand[4] / 4)){
            return true;               
        }
        else{
            return false;
        }
    }
}
