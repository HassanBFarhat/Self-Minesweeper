import java.util.Scanner;

/**
 *  This class is used to (and has methods for) taking a simple minesweeper field
 *  comprised of "*" and "." and will then determine the hint grid that indicates
 *  to a user how far an adjacent mine is from that position.
 *
 *  @author Hassan Bassam Farhat
 *  @version TCSS360 Summer 2023
 */
public class MinesweeperHintField {

    // instance fields

    /** Constant variable that holds String "*". */
    private static final String ASTERISK = "*";

    /**
     * This value will hold the number that expresses the current minefield
     * given an input by the user (or cmd prompt file redirect). Will increment
     * according to the number of minefields entered (or read from file).
     */
    private int myFieldNumber;


    //constructor

    /** Class constructor only initializes myFieldNumber to start at value 1. */
    MinesweeperHintField() {
        myFieldNumber = 1;
    }


    // methods

    /**
     *  This method, addBufferAroundMineField(), adds a buffer around a current set of
     *  minefield inputs by surrounding the entirety of the minefield by 9's. The max
     *  number of mines that can surround a single cell is 8, therefore, 9 will act as
     *  a buffer and prevent NullPointerExceptions from occurring when generating the
     *  complete hinted minefield.
     *
     *  @param theArray takes a current empty array.
     *  @param theCurrentRows takes in the number of rows in the array.
     *  @param theCurrentCols takes in the number of columns in the array.
     *  @param theScanner takes in a scanner object used to obtain input from user
     *                    or file redirection.
     */
    public final void addBufferAroundMineField(final String[][] theArray,
                                                final int theCurrentRows,
                                                final int theCurrentCols,
                                                final Scanner theScanner) {
        String string = theScanner.nextLine();  // takes the first line of minefield.
        for (int row = 0; row < theCurrentRows; row++) {
            final int lastRow = row + 1;
            for (int col = 0; col < theCurrentCols; col++) {
                final int lastCol = col + 1;
                // if statement adds buffer of 9's surrounding the given minefield.
                // else, the character in the minefield is placed in its spot in the 2D-Array.
                if (row == 0 || lastRow == theCurrentRows
                        || col == 0 || lastCol == theCurrentCols) {
                    theArray[row][col] = "9";
                } else {
                    theArray[row][col] = string.charAt(col - 1) + "";
                }
            }
            // if the last row of the minefield is reached, break out of loop and don't
            //    go to the next line.
            // else if, the current row is equal to the last row of the minefield input,
            //          then continue to add the last buffer of 9's without going to the
            //          next line.
            // else, set string to the next line in the input.
            if (row + 1 == theCurrentRows) {
                break;
            } else if (row == theCurrentRows - 2) {
                continue;
            } else {
                string = theScanner.nextLine();
            }
        }
    }

    /**
     *  This method, generateHintedMineField(), will take in a buffered 2D-array and start
     *  checking the actual minefield (ignoring the buffered indexes) and output to the
     *  console (or redirected file) that contains an "*" if our element is a mine, or the
     *  proper "FieldNumber" which indicates how many mines are adjacent to that element
     *  (max FieldNumber can equal is 8) in the 2D-Array.
     *
     *  @param theInputtedMineField takes the current 2D-Array of minefield with the
     *                              buffer of 9's surrounding it.
     *  @param theCurrentRow takes in the number of rows of the array.
     *  @param theCurrentCol takes in the number of columns of the array.
     */
    public final void generateHintedMineField(final String[][] theInputtedMineField,
                                                final int theCurrentRow,
                                                final int theCurrentCol) {

        System.out.println("Field #" + myFieldNumber + ":");
        for (int row = 1; row < (theCurrentRow - 1); row++) {
            for (int col = 1; col < (theCurrentCol - 1); col++) {
                // if the current element in the 2D-array is an "*", then we will
                //    display an "*" to the console or redirected file.
                // else, we're going to display the appropriate number value of mines
                //       adjacent to this elements location in the 2D-array.
                if (theInputtedMineField[row][col].equals(ASTERISK)) {
                    System.out.print(ASTERISK);
                } else {
                    final int mineCount = hintCounter(row, col, theInputtedMineField);
                    System.out.print(mineCount);
                }
            }
            System.out.println();
        }
        myFieldNumber++;    // indicates next minefield to generate its hinted field.
    }


    // private helper methods

    private int hintCounter(final int theCurrentRow,
                            final int theCurrentCol,
                            final String[][] theInputFieldArray) {
        int counter = 0;
        // checks the upper left corner of the element for a mine.
        if (theInputFieldArray[theCurrentRow - 1][theCurrentCol - 1].equals(ASTERISK)) {
            counter++;
        }
        // checks the upper center of the element for a mine.
        if (theInputFieldArray[theCurrentRow - 1][theCurrentCol].equals(ASTERISK)) {
            counter++;
        }
        // checks the upper right corner of the element for a mine.
        if (theInputFieldArray[theCurrentRow - 1][theCurrentCol + 1].equals(ASTERISK)) {
            counter++;
        }
        // checks the left of the element for a mine.
        if (theInputFieldArray[theCurrentRow][theCurrentCol - 1].equals(ASTERISK)) {
            counter++;
        }
        // checks the right of the element for a mine.
        if (theInputFieldArray[theCurrentRow][theCurrentCol + 1].equals(ASTERISK)) {
            counter++;
        }
        // checks the bottom left corner of the element for a mine.
        if (theInputFieldArray[theCurrentRow + 1][theCurrentCol - 1].equals(ASTERISK)) {
            counter++;
        }
        // checks the lower center of the element for a mine.
        if (theInputFieldArray[theCurrentRow + 1][theCurrentCol].equals(ASTERISK)) {
            counter++;
        }
        // checks the bottom right corner of the element for a mine.
        if (theInputFieldArray[theCurrentRow + 1][theCurrentCol + 1].equals(ASTERISK)) {
            counter++;
        }
        return counter;
    }

}
