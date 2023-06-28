import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class Main {

    private Main() {
        // utility classes cannot have default concsturcots
    }

    public static void main(final String[] theArgs) throws IOException {
        final MinesweeperHintField mf = new MinesweeperHintField();
        final Scanner scanner = new Scanner(new File("team_minesweeper_input.txt"));
        int currentRows;
        int currentCols;
        do {
            currentRows = scanner.nextInt() + 2;
            currentCols = scanner.nextInt() + 2;
            if (currentRows == 2 && currentCols == 2) {
                break;
            }
            final String[][] inputArr = new String[currentRows][currentCols];
            mf.addBufferAroundMineField(inputArr, currentRows, currentCols, scanner);
            mf.generateHintedMineField(inputArr, currentRows, currentCols);
        } while (currentRows != 2 && currentCols != 2);
    }
}