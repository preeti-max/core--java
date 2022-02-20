import java.util.Scanner;

import java.util.concurrent.ThreadLocalRandom;
public class Rock {
    public static int getRandomValue(int Min, int Max)
    {return ThreadLocalRandom
            .current()
            .nextInt(Min, Max + 1);
    }
    
    static void helper(int computerChoice,int choice){

    }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String computerChoice,choice;    
        
        
        do {
            computerChoice = getRandomValue(1, 3);

            System.out.print("Choose your option : ");
            do {
                choice = sc.nextInt();
                if (choice <= 3 && choice >= 1) {
                    break;
                }
                System.out.print("Wrong Choice. Choose again : ");
            } while (true);

            System.out.println(helper(computerChoice, choice));

            System.out.println("Would you like to continue? (Y/N)");
            option = sc.next().charAt(0);

        } while (option == 'Y' || option == 'y');

        
    }
    
}
