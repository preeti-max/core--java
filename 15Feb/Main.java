class UPIPayementApp implements Cloneable{
    String appName="BHIM";
    String country="INDIA";
    int dailyLimit=30;
    double maxDailyAmount=100000;
    public UPIPayementApp(){

    }

    UPIPayementApp(String appName, String country,int dailyLimit,double maxDailyAmount){
        this.appName = appName;
        this.country = country;
        this.dailyLimit = dailyLimit;
        this.maxDailyAmount = maxDailyAmount;
    }
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();

    }
    
}
public class Main{
    public static void main(String[] args) throws Exception {
        UPIPayementApp bhim= new UPIPayementApp();
        UPIPayementApp PhonePay= (UPIPayementApp)bhim.clone();
        UPIPayementApp GPay= (UPIPayementApp)bhim.clone();
        
    }
    
}
