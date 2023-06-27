import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinesweeperMatrixBoarderBuffer {

    private String[][] myInputFieldArray;

    MinesweeperMatrixBoarderBuffer(final File theFile) throws FileNotFoundException {
        final Scanner scanner = new Scanner(theFile);
        int currentRows;
        int currentCols;
        do {
            currentRows = scanner.nextInt() + 2;
            currentCols = scanner.nextInt() + 2;
            myInputFieldArray = new String[currentRows][currentCols];
            for (int row = 0; row < currentRows; row++) {
                int lastRow = row + 1;
                for (int col = 0; col < currentCols; col++) {
                    int lastCol = col + 1;
                    if (row == 0 || lastRow == currentRows
                            || col == 0 || lastCol == currentCols) {
                        myInputFieldArray[row][col] = "9";
                    } else {
                        myInputFieldArray[row][col] = scanner.next();
                    }
                }
                if (lastRow == currentRows) {
                    // skip here if true, don't want to go to next line yet.
                } else {
                    scanner.nextLine();
                }
            }
        } while (currentRows == 2 && currentCols == 2);
    }


    public final String[][] getBufferedMineField() {
        return myInputFieldArray;
    }

}
