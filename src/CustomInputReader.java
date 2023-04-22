import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomInputReader extends InputReader{

    public CustomInputReader(String filePath){
        super(filePath);
    }

    public Map readMap(){
        try {
            Scanner scanner = getScanner();
            int columns, rows;
            columns = Integer.parseInt(scanner.next());
            rows = Integer.parseInt(scanner.next());
            Map map = new Map(rows,columns);

            scanner.nextLine();
            scanner.nextLine();

            String[][] stringMatrix = readStringMatrix(rows, columns, scanner);
            char[][] vacationMatrix = new char[rows][columns];
            int[][] scoreMatrix = new int[rows][columns];

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if(stringMatrix[i][j].equals("*")) vacationMatrix[i][j] = '*';  // * -> wormhole
                    else vacationMatrix[i][j] = '0';    // 0 -> free cell
                }
            }
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if(stringMatrix[i][j].equals("*")) scoreMatrix[i][j] = 0;
                    else scoreMatrix[i][j] = Integer.parseInt(stringMatrix[i][j]);
                }
            }

            map.setVacationMap(vacationMatrix);
            map.setScoreMap(scoreMatrix);

            scanner.close();
            return map;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    public Snake[] readSnakes() {
        try {
            Scanner scanner = getScanner();
            int nSnake,tmp = 0;
            scanner.next();
            scanner.next();
            nSnake = Integer.parseInt(scanner.next());
            Snake[] snakes = new Snake[nSnake];

            for(int i : readIntArray(nSnake,scanner)){
                snakes[tmp++] = new Snake(i);
            }

            scanner.close();
            return snakes;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
