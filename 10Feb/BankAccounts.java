class Account{
    double balance;
    String accountHolder;
    Account(String accountHolder,double balance){
        this.balance = balance;
        this.accountHolder = accountHolder;
    }
     void debit(double amount){
        if(amount<=balance){
            balance -= amount;
            System.out.println(amount+" debited to : " +accountHolder+". Balance left: "+balance);
            

        }
        else{
            System.out.println("Debit amount exceeded account balance.");
        }

        }
        void credit(double amount){
            balance += amount;
            System.out.println(amount+" credited to : " +accountHolder+". Balance left: "+balance);
            
        }
    }

public class BankAccounts {

    public static void main(String[] args) {
        Account a=new Account("Preeti",600000);
        Account b=new Account("Rahul",1200000);
        a.credit(12000);
        b.debit(30000);
        
    }
    
}

