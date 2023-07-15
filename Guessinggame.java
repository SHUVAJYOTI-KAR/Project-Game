import java.util.Scanner;
import java.util.Random;
class Game
{
    int systemInput;
    int userInput;
    int NoOfGuesses = 0;
    
    Game()
    {
        Random random = new Random();
        this.systemInput = random.nextInt(100) + 1;
    }

    public boolean takeUserInput()
    {
        if (NoOfGuesses < 10)
        {
            System.out.println("Guess the number: ");
            this.userInput = Guessinggame.takeIntegerInput(100);
            NoOfGuesses++;
            return false;
        }
        else
        {
            System.out.println("Number of attempts finished...Better luck next time");
            return true;
        }
    }
    public boolean isCorrectGuess()
    {
        if (systemInput == userInput)
        {
            System.out.println("Congratulations!! You have guessed correctly! You have done it in "+ NoOfGuesses +"guesses!");
            switch(NoOfGuesses)
            {
                case 1:
                System.out.println("Your score is 100!");
                break;
                case 2:
                System.out.println("Your score is 90!");
                break;
                case 3:
                System.out.println("Your score is 80!");
                break;
                case 4:
                System.out.println("Your score is 70!");
                break;
                case 5:
                System.out.println("Your score is 60!");
                break;
                case 6:
                System.out.println("Your score is 50!");
                break;
                case 7:
                System.out.println("Your score is 40!");
                break;
                case 8:
                System.out.println("Your score is 30!");
                break;
                case 9:
                System.out.println("Your score is 20!");
                break;
                case 10:
                System.out.println("Your score is 10!");
                break;
            }
            return true; 
        }
        else if(NoOfGuesses < 10 && userInput > systemInput)
        {
            if( userInput - systemInput > 10)
            {
                System.out.println("Too High!");
            }
            else
            {
                System.out.println("Too Low!");
            }
        }
        else if(NoOfGuesses < 10 && userInput < systemInput)
        {
            if( systemInput - userInput > 10)
            {
                System.out.println("Too Low!");
            }
            else
            {
                System.out.println("Too High!");
            }
        }
        return false;
    }
}

public class Guessinggame
{
    public static int takeIntegerInput(int limit)
    {
        int input = 0;
        boolean flag = false;
        while(!flag)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if(flag && input > limit || input <1)
                {
                    System.out.println("Choose the number between 1 to " + limit);
                }
            }
            catch ( Exception e )
            {
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args)
    {
        System.out.println("1. Start the Game \n2. Exit ");
        System.out.println("Enter your choice");
        int choice = takeIntegerInput(2);
        int nextRound = 1;
        int NoOfRounds = 0;
        if( choice == 1)
        {
            while( nextRound == 1)
            {
                Game game = new Game();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println("\nRound " + NoOfRounds + "starts...");
                while ( !isMatched && !isLimitCross)
                {
                    isLimitCross = game.takeUserInput();
                    isMatched = game.isCorrectGuess();
                }
                System.out.println("1. Next Round \n2. Exit");
                System.out.println("Enter your choice: ");
                nextRound = takeIntegerInput(2);
                if(nextRound != 1)
                {
                    System.exit(0);
                }
            }
        }
        else
        {
            System.exit(0);
        }
    }
}

