import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {
    @Override
    public int playerMove() {
        Scanner input = new Scanner(System.in);
        boolean quit = false;

        while (!quit)
        {
            System.out.print("Enter the column number you want to play your counter in: ");
            if (input.hasNextInt())
            {
                return input.nextInt();
            }

            else {
                System.out.println("Error - enter a valid number");
                input.nextLine();
            }
        }

        return 0;
    }
}
