package Reflection.user_data_migration;

import java.io.*;

public class SaveUser {
    public static void main(String[] args) {
        try (FileOutputStream fout = new FileOutputStream("userdata.txt");
                ObjectOutputStream out = new ObjectOutputStream(fout);) {

            User user = new User("Preeti", "isthatright@gmail.com", "1234");

            out.writeObject(user);

            out.flush();
            System.out.println("User record saved");
        } catch (Exception e) {
            System.out.println("failure");
            System.out.println(e);
        }

    }

}
