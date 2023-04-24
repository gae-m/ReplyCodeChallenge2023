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

            map.setField( readStringMatrix(rows, columns, scanner) );

            scanner.close();
            return map;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    public Snake[] readSnakes(Map map) {
        try {
            Scanner scanner = getScanner();
            int nSnake,tmp = 0;
            scanner.next();
            scanner.next();
            nSnake = Integer.parseInt(scanner.next());
            Snake[] snakes = new Snake[nSnake];

            int id = 0;
            for(int length : readIntArray(nSnake,scanner)){
                snakes[tmp++] = new Snake(id,length,map);
                id++;
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
