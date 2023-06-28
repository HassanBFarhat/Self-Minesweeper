import java.io.IOException;
import java.util.Scanner;

public class MinesweeperHintField {

    private int myFieldNumber;

    private static final String ASTERISK = "*";

    MinesweeperHintField() {
        myFieldNumber = 1;
    }


    public final void addBufferAroundMineField(final String[][] theArray,
                                                final int theCurrentRows,
                                                final int theCurrentCols,
                                                final Scanner theScanner) throws IOException {
        String string = theScanner.nextLine();
        for (int row = 0; row < theCurrentRows; row++) {
            for (int col = 0; col < theCurrentCols; col++) {
                if (row == 0 || row + 1 == theCurrentRows
                        || col == 0 || col + 1 == theCurrentCols) {
                    theArray[row][col] = "9";
                } else {
                    theArray[row][col] = string.charAt(col - 1) + "";
                }
            }
            if (row + 1 == theCurrentRows) {
                break;
            } else if (row == theCurrentRows - 2) {
                continue;
            } else {
                string = theScanner.nextLine();
            }
        }
    }


    private int hintCounter(final int theCurrentRow, final int theCurrentCol, final String[][] theInputFieldArray) {
        int counter = 0;
        if (theInputFieldArray[theCurrentRow - 1][theCurrentCol - 1].equals(ASTERISK)) {
            counter++;
        }
        if (theInputFieldArray[theCurrentRow - 1][theCurrentCol].equals(ASTERISK)) {
            counter++;
        }
        if (theInputFieldArray[theCurrentRow - 1][theCurrentCol + 1].equals(ASTERISK)) {
            counter++;
        }
        if (theInputFieldArray[theCurrentRow][theCurrentCol - 1].equals(ASTERISK)) {
            counter++;
        }
        if (theInputFieldArray[theCurrentRow][theCurrentCol + 1].equals(ASTERISK)) {
            counter++;
        }
        if (theInputFieldArray[theCurrentRow + 1][theCurrentCol - 1].equals(ASTERISK)) {
            counter++;
        }
        if (theInputFieldArray[theCurrentRow + 1][theCurrentCol].equals(ASTERISK)) {
            counter++;
        }
        if (theInputFieldArray[theCurrentRow + 1][theCurrentCol + 1].equals(ASTERISK)) {
            counter++;
        }
        return counter;
    }


    public final void generateHintedMineField( final String[][] theInputedMineField,
                                                final int theCurrentRow,
                                                final int theCurrentCol) throws IOException {
        System.out.println("\nField #" + myFieldNumber + ": ");
        for (int row = 1; row < (theCurrentRow - 1); row++) {
            for (int col = 1; col < (theCurrentCol - 1); col++) {
                if (theInputedMineField[row][col].equals(ASTERISK)) {
                    System.out.print(ASTERISK);
                } else {
                    int mineCount = hintCounter(row, col, theInputedMineField);
                    System.out.print(mineCount);
                }
            }
            System.out.println();
        }
        myFieldNumber++;
    }
}
