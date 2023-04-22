import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class InputReader {
    private String filePath;

    public InputReader(String filePath) {
        this.filePath = filePath;
    }

    protected Scanner getScanner() throws FileNotFoundException {
        File inputFile = new File(this.filePath);
        return new Scanner(inputFile);
    }

    protected int[][] readIntMatrix(int rows, int columns, Scanner scanner){
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                matrix[i][j] = Integer.parseInt(scanner.next());

        return matrix;
    }

    protected String[][] readStringMatrix(int rows, int columns, Scanner scanner){
        String[][] matrix = new String[rows][columns];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                matrix[i][j] = scanner.next();

        return matrix;
    }

    protected int[] readIntArray(int size, Scanner scanner){
        int[] array = new int[size];
        for(int i = 0; i < size; i++) array[i] = Integer.parseInt(scanner.next());
        return array;
    }

    protected char[][] readCharMatrix(int rows, int columns, Scanner scanner){
        char[][] matrix = new char[rows][columns];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                matrix[i][j] = scanner.next().charAt(0);

        return matrix;
    }
}
