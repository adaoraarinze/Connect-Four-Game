import java.util.Arrays;

public class Connect4Grid2DArray implements Connect4Grid {
    public String[][] board;
    private int[] columnArray = new int[] {0, 1, 3, 5, 7, 9, 11, 13};
    private int lastColumn = 0;
    private int lastRow = 0;
    private String lastChip = "";

    public void emptyGrid() {
        board = new String[][] {
                {"|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|"},
                {"|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|"},
                {"|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|"},
                {"|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|"},
                {"|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|"},
                {"|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|"},
                {"|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|"},
                {"|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|"},
                {"|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|"},
                {"|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|", "", "|"}
        };
    }

    public String toString(){
        StringBuilder grid = new StringBuilder();
        String arrayValue;

        for (int heightOfArray = 0; heightOfArray < 10; heightOfArray++)
        {
            for (int widthOfArray = 0; widthOfArray < 15; widthOfArray++)
            {
                if (((board[heightOfArray][widthOfArray]).equalsIgnoreCase("|") && (widthOfArray == 14)))
                {
                    arrayValue = (board[heightOfArray][widthOfArray]) + "\n";
                }

                else
                {
                    arrayValue = (board[heightOfArray][widthOfArray]) + "\t";
                }
                grid.append(arrayValue);
            }
        }
        return grid + "";
    }

    public boolean isValidColumn(int column)
    {
        return column == 1 || column == 2 || column == 3 || column == 4
                || column == 5 || column == 6 || column == 7;
    }

    public boolean isColumnFull(int column) {
        if (isValidColumn(column))
        {
            for (int heightOfArray = 0; heightOfArray < 10; heightOfArray++)
            {
                for (int widthOfArray = 0; widthOfArray < 15; widthOfArray++)
                {
                    if (((board[heightOfArray][widthOfArray]).equalsIgnoreCase("")
                            && (widthOfArray == columnArray[column])))
                    {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void dropPiece(ConnectPlayer player, int column) {
        int heightOfArray = 9;
        boolean quit = false;
        while (!quit)
        {
            if (!isColumnFull(column))
            {
                while (!quit && isValidColumn(column))
                {
                    if ((board[heightOfArray][columnArray[column]]).equalsIgnoreCase(""))
                    {
                        lastRow = heightOfArray;
                        lastColumn = columnArray[column];
                        lastChip = player.getPlayerChip();
                        board[heightOfArray][columnArray[column]] = player.getPlayerChip();
                        quit = true;
                    }

                    heightOfArray--;
                }
            }

            else
            {
                if (player instanceof C4HumanPlayer)
                {
                    System.out.println("Error - not a valid column number");
                }
                column = player.playerMove();
            }
        }

    }

    public boolean didLastPieceConnect4() {

        // checking all horizontal wins
        if (lastColumn <= 7)
        {
            if (((board[lastRow][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn + 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn + 4]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn + 6]).equalsIgnoreCase(lastChip))
            )
            {
                return true;
            }
        }

        if (lastColumn >= 7)
        {
            if (((board[lastRow][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn - 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn - 4]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn - 6]).equalsIgnoreCase(lastChip))
            )
            {
                return true;
            }
        }

        if (lastColumn >= 5 && lastColumn <= 11)
        {
            if (((board[lastRow][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn - 4]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn - 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn + 2]).equalsIgnoreCase(lastChip))
            )
            {
                return true;
            }
        }

        if (lastColumn >= 3 && lastColumn <= 9)
        {
            if (((board[lastRow][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn - 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn + 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow][lastColumn + 4]).equalsIgnoreCase(lastChip))
            )
            {
                return true;
            }
        }

        //checking vertical wins
        if (lastRow <= 6)
        {
            if (((board[lastRow][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 1][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 2][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 3][lastColumn]).equalsIgnoreCase(lastChip))
            )
            {
                return true;
            }
        }

        //checking all diagonal wins
        if (lastColumn <= 7 && lastRow >= 5) {
            if (((board[lastRow][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow - 1][lastColumn + 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow - 2][lastColumn + 4]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow - 3][lastColumn + 6]).equalsIgnoreCase(lastChip))
            )
            {
                return true;
            }
        }

        if (lastColumn >= 7 && lastRow <= 6)
        {
            if (((board[lastRow][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 1][lastColumn - 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 2][lastColumn - 4]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 3][lastColumn - 6]).equalsIgnoreCase(lastChip))
            )
            {
                return true;
            }
        }

        if (lastColumn >= 5 && lastColumn <= 11 &&  lastRow <= 8 && lastRow > 1)
        {
            if (((board[lastRow][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow - 2][lastColumn - 4]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow - 1][lastColumn - 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 1][lastColumn + 2]).equalsIgnoreCase(lastChip))
            )
            {
                return true;
            }
        }

        if (lastColumn >= 3 && lastColumn <= 9 && lastRow <= 7 && lastRow != 0)
        {
            if (((board[lastRow][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow - 1][lastColumn - 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 1][lastColumn + 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 2][lastColumn + 4]).equalsIgnoreCase(lastChip))
            )
            {
                return true;
            }
        }

        if (lastColumn >= 5 && lastColumn <= 11 && lastRow != 0 && lastRow <= 7)
        {
            if (((board[lastRow][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 2][lastColumn - 4]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 1][lastColumn - 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow - 1][lastColumn + 2]).equalsIgnoreCase(lastChip))
            )
            {
                return true;
            }
        }

        if (lastColumn >= 3 && lastColumn <= 9 && lastRow <= 8 && lastRow > 1)
        {
            if (((board[lastRow][lastColumn]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow + 1][lastColumn - 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow - 1][lastColumn + 2]).equalsIgnoreCase(lastChip))
                    && ((board[lastRow - 2][lastColumn + 4]).equalsIgnoreCase(lastChip))
            )
            {
                return true;
            }
        }

        return false;
    }

    public boolean isGridFull() {
        for (int heightOfArray = 0; heightOfArray < 10; heightOfArray++)
        {
            for (int widthOfArray = 0; widthOfArray < 15; widthOfArray++)
            {
                if (((board[heightOfArray][widthOfArray]).equalsIgnoreCase("")))
                {
                    return false;
                }
            }
        }

        return true;
    }
}
