import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        MinesweeperHintField mf = new MinesweeperHintField();
        final Scanner scanner = new Scanner(new File("team_minesweeper_input.txt"));
        int currentRows;
        int currentCols;
        do {
            currentRows = scanner.nextInt() + 2;
            currentCols = scanner.nextInt() + 2;
            if (currentRows == 2 && currentCols == 2) {
                break;
            }
            String[][] inputArr = new String[currentRows][currentCols];
            mf.addBufferToInputMineField(inputArr, currentRows, currentCols, scanner);
            mf.generatorHintedMineField(inputArr, currentRows, currentCols);
        } while (currentRows != 2 && currentCols != 2);
    }
}