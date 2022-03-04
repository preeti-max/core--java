package File_Handling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class Insertion {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("File_Handling/playground.txt");
                Scanner sc = new Scanner(fr);
                FileWriter writer = new FileWriter("File_Handling/playgound.txt"))

        {
            String str = sc.nextLine();
            String updatedStr = str.substring(0, 5) + "@" + str.substring(5, 8) + "123" + str.substring(8);
            System.out.println(updatedStr);
            writer.write(updatedStr);
        }

        catch (IOException e) {
            System.out.println("iooo");

        }

    }

}
