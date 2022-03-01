package Serialization;

import java.io.*;

public class Kiosk {
    public static void main(String[] args) {
        try (FileOutputStream fout = new FileOutputStream("Serialization/account.txt");
                ObjectOutputStream out = new ObjectOutputStream(fout);) {
            // Creating the object
            BankAccount account = new BankAccount(101, "Preeti", 20000);

            // Write the object into the file
            out.writeObject(account);
            // Flush the output stream pipe
            out.flush();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("failure");
            System.out.println(e);
        }

    }

}
