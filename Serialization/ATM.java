package Serialization;

import java.io.*;

public class ATM {
    public static void displayBalance(BankAccount account) {
        System.out.println("Account balance is :" + account.accBalance);
    }

    public static void main(String[] args) throws IOException {
        ObjectInputStream in = null;
        FileInputStream fin = null;
        try {

            fin = new FileInputStream("Serialization/account.txt");

            in = new ObjectInputStream(fin);
            BankAccount s = (BankAccount) in.readObject();
            displayBalance(s);

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            in.close();

            fin.close();
        }
    }

}
