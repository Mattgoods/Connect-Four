import java.util.*;

public class ConnectFour {

    public static void printBoard(char[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static void initializeBoard(char[][] array) {

        for (int j = 0; j < array[0].length; j++) {
            for (int i = 0; i < array.length; i++) {
                array[i][j] = '-';
            }
        }

    }

    public static int insertChip(char[][] array, int col, char chipType) {
        for(int i = array.length - 1; i >= 0; i--) {
             if(array[i][col] == '-') {
                array[i][col] = chipType;
                return i;
            }
        }
        return -1;
    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == chipType) {
                    if (j < array[0].length - 3) {
                        if (array[i][j + 1] == chipType) { //check to the right
                            if (array[i][j + 2] == chipType) {
                                if (array[i][j + 3] == chipType) {
                                    return true;
                                }
                            }
                        }
                    }
                    if (j >= 3) {
                        if (array[i][j - 1] == chipType) { //check to the left
                            if (array[i][j - 2] == chipType) {
                                if (array[i][j - 3] == chipType) {
                                    return true;
                                }
                            }
                        }
                    }
                    if (i >= 3) {
                        if (array[i - 1][j] == chipType) { //checks up
                            if (array[i - 2][j] == chipType) {
                                if (array[i - 3][j] == chipType) {
                                    return true;
                                }
                            }
                        }
                    }
                    if (i < array.length - 3) {
                        if (array[i + 1][j] == chipType) { //checks down
                            if (array[i + 2][j] == chipType) {
                                if (array[i + 3][j] == chipType) {
                                    return true;
                                }
                            }
                        }
                    }
                    if (i >= 3 && j < array[0].length - 3) {
                        if (array[i - 1][j + 1] == chipType) { //checks diagonal (UP-RIGHT)
                            if (array[i - 2][j + 2] == chipType) {
                                if (array[i - 3][j + 3] == chipType) {
                                    return true;
                                }
                            }
                        }
                    }
                    if (i >= 3 && j >= 3) {
                        if (array[i - 1][j - 1] == chipType) { //checks diagonal (UP-LEFT)
                            if (array[i - 2][j - 2] == chipType) {
                                if (array[i - 3][j - 3] == chipType) {
                                    return true;
                                }
                            }
                        }
                    }
                    if (i < array.length - 3 && j < array[0].length - 3) {
                        if (array[i + 1][j + 1] == chipType) { //checks diagonal (DOWN-RIGHT)
                            if (array[i + 2][j + 2] == chipType) {
                                if (array[i + 3][j + 3] == chipType) {
                                    return true;
                                }
                            }
                        }
                    }
                    if (i < array.length - 3 && j >= 3) {
                        if (array[i + 1][j - 1] == chipType) { //checks diagonal (DOWN-LEFT)
                            if (array[i + 2][j - 2] == chipType) {
                                if (array[i + 3][j - 3] == chipType) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        int column;
        int row;
        int selectedColumn;
        int winCount = 0;
        char p1 = 'x';
        char p2 = 'o';

        System.out.print("What would you like the height of the board to be? ");
        column = scnr.nextInt();

        System.out.print("What would you like the length of the board to be? ");
        row = scnr.nextInt();

        char[][] board = new char[row][column];
        initializeBoard(board);
        printBoard(board);
        System.out.println();

        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        System.out.println();

        while (winCount == 0) {
            System.out.print("Player 1: Which column would you like to choose? ");
            selectedColumn = scnr.nextInt();
            insertChip(board, selectedColumn, p1);
            printBoard(board);
            System.out.println();

            if (checkIfWinner(board, column, row, p1) == true) {
                System.out.println("Player 1 won the game!");
                winCount = 1;
                break;
            }

            System.out.print("Player 2: Which column would you like to choose? ");
            selectedColumn = scnr.nextInt();
            insertChip(board, selectedColumn, p2);
            printBoard(board);
            System.out.println();

            if (checkIfWinner(board, column, row, p2) == true) {
                System.out.println("Player 2 won the game!");
                winCount = 1;
                break;
            }
        }
        
    }

}
