package Reflection.user_data_migration;

import java.io.*;
import java.lang.reflect.*;

public class FetchUser {
    public static void main(String[] args) throws IOException {
        ObjectInputStream in = null;
        FileInputStream fin = null;
        try {

            fin = new FileInputStream("userdata.txt");

            in = new ObjectInputStream(fin);
            User s = (User) in.readObject();
            System.out.println("user record retreived");
            System.out.println(s);
            Class obj = s.getClass();

            Field field1 = obj.getDeclaredField("password");
            field1.setAccessible(true);

            field1.set(s, "89034");
            System.out.println(s);

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            in.close();

            fin.close();
        }

    }

}
