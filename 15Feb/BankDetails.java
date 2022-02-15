import java.util.*;

class BankAccount{
    
    int accNo;
    double accBalance;
    String accHolderName;
    
    public BankAccount() {
        this.accNo =0;
        this.accBalance =0;
        this.accHolderName="XYZ";
    }

   


    public BankAccount(int accNo, double accBalance, String accHolderName) {
        this.accNo = accNo;
        this.accBalance = accBalance;
        this.accHolderName = accHolderName;
    }

    public int getAccNo() {
        return accNo;
    }

    

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }
    public double getYearlyTax(){
        return 0;
    }
    public double getInHandYearlySalary(){
        return 0;
    }
    public BankAccount Copy(BankAccount obj){
        
        return new BankAccount(obj.accNo,obj.accBalance,obj.accHolderName);
    }

    @Override
    public String toString() {
       
        return "BankAccount [accBalance=" + accBalance + ", accHolderName=" + accHolderName + ", accNo=" + accNo + "]";
    }

    
    


}
class SavingsAccount extends BankAccount{
    static double rateOfInterest=10;

    

    public SavingsAccount(int accNo, double accBalance, String accHolderName) {
        super(accNo, accBalance, accHolderName);
        
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public double getComputedInterest(int year) {
        return (accBalance*rateOfInterest*year)/100;
    }
    public double getYearlyInterest(){
        return getComputedInterest(1);  

    }
    




}
 class CurrentAccount extends BankAccount{
     int avgDailyTransaction;

    public CurrentAccount(int avgDailyTransaction) {
        this.avgDailyTransaction = avgDailyTransaction;
    }
    

    public CurrentAccount(int accNo, double accBalance, String accHolderName) {
        super(accNo, accBalance, accHolderName);
    }


    public CurrentAccount(int accNo, double accBalance, String accHolderName, int avgDailyTransaction) {
        super(accNo, accBalance, accHolderName);
        this.avgDailyTransaction = avgDailyTransaction;
    }

    public int getAvgDailyTransaction() {
        return avgDailyTransaction;
    }

    public void setAvgDailyTransaction(int avgDailyTransaction) {
        this.avgDailyTransaction = avgDailyTransaction;
    }
    public double getTotalTransactionAmount(int days){
        return avgDailyTransaction*days;
    }
     public double getYearlyTransaction(){
         return getTotalTransactionAmount(365);

     }


     

    @Override
    public String toString() {
        return super.toString() + "CurrentAccount [avgDailyTransaction=" + avgDailyTransaction + "]";
    }

}

public class BankDetails{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        BankAccount[] bankAcc=new BankAccount[n];
        SavingsAccount[] savingsAcc=new SavingsAccount[n];
        CurrentAccount[] currentAcc=new CurrentAccount[n];
        BankAccount[] salaryAcc=new BankAccount[n];
        
        for(int i=0;i<n;i++){
            bankAcc[i]=new BankAccount(sc.nextInt(),sc.nextDouble(),sc.next());
            savingsAcc[i]=new SavingsAccount(sc.nextInt(),sc.nextDouble(),sc.next());
            currentAcc[i]=new CurrentAccount(sc.nextInt(),sc.nextDouble(),sc.next(),sc.nextInt());
            salaryAcc[i]=new BankAccount(){

                double salary=12000;
                double pfAmount=2200;
                 double incomeTaxRate=4;
                 
             
                public double getYearlyTax(){
                    return (incomeTaxRate*salary*12)/100;
                }
                public double getInHandYearlySalary(){
                    return (salary-pfAmount)*12-getYearlyTax();
                }
     
             };


        }

      
        System.out.println(bankAcc[0]);
        System.out.println("Yearly interst : "+savingsAcc[0].getYearlyInterest());
        System.out.println("Computed interest  :"+savingsAcc[0].getComputedInterest(4));
        System.out.println("Yearly transaction: "+currentAcc[0].getYearlyTransaction());
        System.out.println("Total transaction: "+currentAcc[0].getTotalTransactionAmount(56));
        System.out.println("Inhand salary: "+salaryAcc[0].getInHandYearlySalary());
        System.out.println("Yearly Tax: "+salaryAcc[0].getYearlyTax());
        System.out.println("Copy of bank Acc: "+bankAcc[0].Copy(bankAcc[0]));
        System.out.println("Copy of savings acc: "+bankAcc[0].Copy(savingsAcc[0]));
        System.out.println("Copy of current acc: "+bankAcc[0].Copy(currentAcc[0]));
        
        
        
        
        
    }

}