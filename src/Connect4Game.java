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
