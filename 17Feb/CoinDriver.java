import java.util.Random;
class Coin{
    private String sideUp;
    public Coin() {
        toss();
    }
    public void toss(){
        Random random = new Random();
        
        int number = random.nextInt(2);
        if(number==0){
            this.sideUp ="heads";

        }
        else{
            this.sideUp ="tails";
        }


    }
    public String getSideUp(){
        return sideUp;
    }
}
public class CoinDriver {
    static double randomCoin(){
        Random random=new Random();
        int number=random.nextInt(3);
        if(number==0){
            return 0.25;
        }
        else if(number==1){
            return 0.1;
        }
        return 0.05;
        

    }
    public static void main(String[] args) {
        double balance=0;
        while(balance<1){
            Coin coin=new Coin();
            double randomCoin=randomCoin();
            if(coin.getSideUp().equals("heads")){
                balance+=randomCoin;
                System.out.println("You got heads. Coin worth $ "+randomCoin+" added to your balance");
            }
            else{System.out.println("You got tails. No amount will be added to your account");}
        }
        System.out.println(balance==1?"You won":"You lost.Your account balance is $:"+balance);
        

        
    }
    
}
