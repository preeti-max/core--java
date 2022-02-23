package File_Handling;
import java.util.Scanner;

import java.io.*;


public class Warning {
    static boolean hasWarning(int creditHrs,double gpa){
        return(creditHrs<30 && gpa<1.5)||(creditHrs<60 && gpa<1.75)||(gpa<2.0);

    }
    
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main (String[]args)
    {
        int creditHrs;		// number of semester hours earned
        double qualityPts;	// number of quality points earned
        double gpa;			// grade point (quality point) average
        String line, name, inputName = "students.dat";
        
        String outputName = "warning.dat";
        
        try
        {   File f=new File("File_Handling/students.dat");
            Scanner sc=new Scanner(f);
            FileWriter writer=new FileWriter("File_Handling/warning.dat",true);
            writer.write("Students on Academic Warning\n");


            // Set up scanner to input file
            // Set up the output file stream

            // Print a header to the output file - "Students on Academic Warning"
        
            // Process the input file, one token at a time
            while(sc.hasNext())
            {  
                String data[]=sc.nextLine().split(" ");
                 name=data[0];
                 creditHrs=Integer.parseInt(data[1]);
                 qualityPts=Double.parseDouble(data[2]);
                 gpa=qualityPts/creditHrs;
                 if(hasWarning(creditHrs,gpa)){
                     writer.write(name+" "+creditHrs+" "+qualityPts+"\n");
                 }
                 

                // Get the credit hours and quality points and
                // determine if the student is on warning. If so,
                // write the student data to the output file.
             }
             writer.close();
            // Close output file
        }
        catch (FileNotFoundException exception)
        {
          System.out.println ("The file " + inputName + " was not found.");
        }
        catch (IOException exception)
        {
          System.out.println (exception);
        }
        catch (NumberFormatException e)
        {
          System.out.println ("Format error in input file: " + e);
        }
    }
    
}
