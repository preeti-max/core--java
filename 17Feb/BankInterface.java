interface RBI{
    static double rateOfInterest=4;
    void showBalance();
    double withdraw(double amount);
    double deposit(double amount);
    double calculateYearlyInterest();

}
class SBIAccount implements RBI{
    
    int accNo;
    double accBalance;
    String accHolderName;
    static double accOpeningBonus=1000;
    

    
    public SBIAccount(int accNo, double accBalance, String accHolderName) {
        this.accNo = accNo;
        this.accBalance = accBalance+accOpeningBonus;
        this.accHolderName = accHolderName;
    }
    
    public String getAccHolderName() {
        return accHolderName;
    }

    public void showBalance(){
        System.out.println("Balance : "+accBalance);
        
    }
    public double withdraw(double amount){
        if(amount>accBalance){
            System.out.println("Insufficient balance");
            return -1;
        }
        return this.accBalance=this.accBalance-amount;
    }
    public double deposit(double amount){
        return this.accBalance=this.accBalance+amount;
    }
    public double calculateYearlyInterest(){
        return (RBI.rateOfInterest*accBalance)/100;

    }
    void displayFeatures(){
        System.out.println("SBI offers an account opening bonus of :"+accOpeningBonus);
    }
    @Override
    public String toString() {
        return "[accBalance=" + accBalance + ", accHolderName=" + accHolderName + ", accNo=" + accNo + "]";
    }
    


   

}
class ICICIAccount extends SBIAccount implements RBI{
    static double additionalInterest=2;
    
    public ICICIAccount(int accNo, double accBalance, String accHolderName) {
        super(accNo, accBalance, accHolderName);
        this.accBalance-=accOpeningBonus;
    }
    @Override
    public double calculateYearlyInterest(){
        return ((RBI.rateOfInterest+additionalInterest)*this.accBalance)/100;

    }
    @Override
    void displayFeatures(){
        System.out.println("ICICI offers an additional interst rate of :"+additionalInterest+"%");
    }


}
public class BankInterface {
    public static void main(String[] args) {
       
        SBIAccount sbi2=new SBIAccount(103,70000,"Akshat");
        ICICIAccount icici2=new ICICIAccount(104,90000,"Shreya");
        System.out.println("Amount deposited to :"+sbi2.getAccHolderName()+"\t Account Balance : "+sbi2.deposit(1000));
        System.out.println("Amount withdrawn from :"+sbi2.getAccHolderName()+"\t Account Balance : "+sbi2.withdraw(2000));
        System.out.println("Yearly interset rate for SBI : "+sbi2.calculateYearlyInterest());
        sbi2.showBalance();
        sbi2.displayFeatures();
        System.out.println("RBI");
        System.out.println("Amount deposited to :"+icici2.getAccHolderName()+"\t Account Balance : "+icici2.deposit(1000));
        System.out.println("Amount withdrawn from :"+icici2.getAccHolderName()+"\t Account Balance : "+icici2.withdraw(2000));
        System.out.println("Yearly interset rate for SBI : "+icici2.calculateYearlyInterest());
        icici2.showBalance();
        
        
        icici2.displayFeatures();

        
    }
    
}
