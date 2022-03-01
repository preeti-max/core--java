package Serialization;

import java.io.Serializable;

public class BankAccount implements Serializable {

    int accNumber;
    String accHolders;
    double accBalance;

    public BankAccount(int accNumber, String accHolders, double accBalance) {
        this.accNumber = accNumber;
        this.accHolders = accHolders;
        this.accBalance = accBalance;
    }

    @Override
    public String toString() {
        return "BankAccount [accBalance=" + accBalance + ", accHolders=" + accHolders + ", accNumber=" + accNumber
                + "]";
    }

}
