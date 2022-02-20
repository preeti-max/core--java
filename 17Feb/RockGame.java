import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
class Game {
String pcChoice;
String userInput;
public static int getRandomValue(int Min, int Max)
    {return ThreadLocalRandom
            .current()
            .nextInt(Min, Max + 1);
    }

void computerChoice() {
    int choice = getRandomValue(1,3);

    if (choice == 1)
        pcChoice = "rock";
    else if (choice == 2)
        pcChoice = "paper";
    else
        pcChoice = "scissors";
}

void helper() {
    if (userInput.equals(pcChoice)) {
        System.out.println("It's a tie! You have to play again!");
        
    } else if (userInput.equals("rock") && pcChoice.equals("scissors")
            || (userInput.equals("scissors") && pcChoice.equals("paper"))
            || (userInput.equals("paper") && pcChoice.equals("rock"))) {
        System.out.println("You win!");
    } else
        System.out.println("You lose!");

    
}
}

class RockGame {
public static void main(String[] args) {
Game obj = new Game();
Scanner sc = new Scanner(System.in);
while (true) {
System.out.println("Enter your Choice:");
obj.userInput = sc.next();

        obj.computerChoice();
        System.out.println("Computer chose: " + obj.pcChoice);

        obj.helper();
        
        System.out.println("Do you want to quit? Y/N");
        if (sc.next().equalsIgnoreCase("N"))
            break;
    }
    
}
}