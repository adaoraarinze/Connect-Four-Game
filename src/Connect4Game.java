/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether
he/she would like to play/quit inside a loop. If the user decides to play then:
1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised
#- must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she
would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface.
Finally a check is performed to determine a win.
Comment: My class provides all the functionality to play the connect four game properly

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: All 7 methods are clearly defined

Connect4Grid2DArray class (25 marks)
My class implements the Connect4Grid interface. It creates a grid using a 2D array
Implementation of the method to check whether the column to drop the piece is valid.
It provides as implementation of the method to check whether the column to drop the piece
is full. It provides as implementation of the method to drop the piece.  It provides as
implementation of the method to check whether there is a win.
Comment: My class provides all functionality needed for the connect four grid to work properly.

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method.
Comment: My class provides 3 non-abstract methods and one abstract method.

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s).
It provides the Human player functionality.
Comment: My class provides the human player with the needed functionality.

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s).
It provides AI player functionality.
Comment: My class provides the computer player with the needed functionality.

Total Marks out of 100: 100

*/

import java.util.Scanner;

public class Connect4Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to connect four, would you like to play? (enter yes or quit): ");
        ConnectPlayer playerOne = null;
        ConnectPlayer playerTwo = null;

        boolean quit = false;
        boolean play = true;

        while (!quit)
        {
            if (input.hasNext())
            {
                String userInput = input.next();
                if (userInput.equalsIgnoreCase("quit"))
                {
                    play = false;
                    quit = true;
                }

                else if (userInput.equalsIgnoreCase("yes"))
                {
                    quit = true;
                }

                else
                {
                    System.out.print("Error - enter a valid input: ");
                    input.nextLine();
                }
            }

            else
            {
                System.out.print("Error - enter a valid input: ");
                input.nextLine();
            }
        }

        if (play)
        {
            System.out.print("Would you like a human or computer as player one?: ");
            quit = false;
            while (!quit)
            {
                if (input.hasNext())
                {
                    while (!quit)
                    {
                        String playerType = input.next();
                        if (playerType.equalsIgnoreCase("human"))
                        {
                            playerOne = new C4HumanPlayer();
                            playerOne.setPlayerChip("X");
                            quit = true;
                        }

                        else if (playerType.equalsIgnoreCase("computer"))
                        {
                            playerOne = new C4RandomAIPlayer();
                            playerOne.setPlayerChip("X");
                            quit = true;
                        }

                        else
                        {
                            System.out.print("Error - enter a valid player type: ");
                            input.nextLine();
                        }
                    }
                }

                else
                {
                    System.out.print("Error - enter a valid player type: ");
                    input.nextLine();
                }
            }

            System.out.print("Would you like a human or computer as player two?: ");
            quit = false;
            while (!quit)
            {
                if (input.hasNext())
                {
                    while (!quit)
                    {
                        String playerType = input.next();
                        if (playerType.equalsIgnoreCase("human"))
                        {
                            playerTwo = new C4HumanPlayer();
                            playerTwo.setPlayerChip("O");
                            quit = true;
                        }

                        else if (playerType.equalsIgnoreCase("computer"))
                        {
                            playerTwo = new C4RandomAIPlayer();
                            playerTwo.setPlayerChip("O");
                            quit = true;
                        }

                        else
                        {
                            System.out.print("Error - enter a valid player type: ");
                            input.nextLine();
                        }
                    }
                }

                else
                {
                    System.out.print("Error - enter a valid player type: ");
                    input.nextLine();
                }
            }

            Connect4Grid2DArray grid = new Connect4Grid2DArray();
            grid.emptyGrid();
            System.out.println(grid.toString());
            boolean gameOver = false;

            while (!grid.isGridFull() && !gameOver)
            {
                grid.dropPiece(playerOne, playerOne.playerMove());
                System.out.println(grid.toString());

                if (grid.didLastPieceConnect4())
                {
                    gameOver = true;
                    playerOne.playerWins("Player one");
                }

                if (!gameOver)
                {
                    grid.dropPiece(playerTwo, playerTwo.playerMove());
                    System.out.println(grid.toString());

                    if (grid.didLastPieceConnect4())
                    {
                        gameOver = true;
                        playerTwo.playerWins("Player two");
                    }
                }
            }
        }
    }
}
