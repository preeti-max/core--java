package Exception_Handling;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDriver {
    public static void main(String[] args) {
        File f= new File("Exception_Handling/Test.txt");
        
        try (Scanner myReader = new Scanner(f)) {
            try {
                File myObj = new File("Filename.txt");
                if (myObj.createNewFile()) {
                  System.out.println("File created: " + myObj.getName());
                } else {
                  System.out.println("File already exists.");
                }
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
              try {
                FileWriter myWriter = new FileWriter("Filename.txt");
                while(myReader.hasNextLine()) {
                    myWriter.write(myReader.nextLine());
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
   
   
                }
                
                
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
      


    }
    
}
