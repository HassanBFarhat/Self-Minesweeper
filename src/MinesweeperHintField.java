import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MinesweeperHintField {

    private int myFieldNumber;

    private  static final String ASTERISK = "*";

    MinesweeperHintField() {
        myFieldNumber = 1;
    }


    public final void addBufferToInputMineField(final String[][] theArray,
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


    public final void generatorHintedMineField( final String[][] theInputedMineField,
                                                final int theCurrentRow,
                                                final int theCurrentCol) throws IOException {
        final FileWriter fw =
                new FileWriter("team_minesweeper_output.txt", true);
        final PrintWriter printWriter = new PrintWriter(fw);
        final StringBuilder sb = new StringBuilder();
        printWriter.println("Field #" + myFieldNumber + ": ");
        for (int row = 1; row < (theCurrentRow - 1); row++) {
            for (int col = 1; col < (theCurrentCol - 1); col++) {
                if (theInputedMineField[row][col].equals(ASTERISK)) {
                    sb.append(ASTERISK);
                } else {
                    int mineCount = hintCounter(row, col, theInputedMineField);
                    sb.append(mineCount);
                }
            }
            printWriter.println(sb.toString());
            sb.setLength(0);
        }
        printWriter.println();
        printWriter.close();
        myFieldNumber++;
    }

}
