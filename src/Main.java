import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *  This is the Main class method that houses the main method for starting an
 *  entryway for our program. THIS PROGRAM RUNS CORRECTLY!!
 *
 *  @author Hassan Bassam Farhat
 *  @version TCSS360 Summer 2023
 */
public final class Main {

    private Main() {
        // utility classes cannot have default constructors
    }

    public static void main(final String[] theArgs) throws IOException {
        final MinesweeperHintField mf = new MinesweeperHintField();
        Scanner scanner = new Scanner(System.in);
        if (theArgs.length == 1) {
            scanner = new Scanner(new File(theArgs[0]));
        }
        int currentRows;
        int currentCols;
        do {
            currentRows = scanner.nextInt() + 2;
            currentCols = scanner.nextInt() + 2;
            final String[][] inputArr = new String[currentRows][currentCols];
            mf.addBufferAroundMineField(inputArr, currentRows, currentCols, scanner);
            mf.generateHintedMineField(inputArr, currentRows, currentCols);
        } while (currentRows != 2 && currentCols != 2);
    }
}