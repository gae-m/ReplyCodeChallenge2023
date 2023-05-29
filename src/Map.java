import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Map {
    private final int rows;
    private final int columns;
    private final Cell[][] field;
    private WormholeList wormholeList;

    public Map(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.field = new Cell[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public WormholeList getWormholeList() {
        return wormholeList;
    }

    public Cell getInitialCell(){
        //placeholder: random cell
        Cell res;
        do{
            res = field[ThreadLocalRandom.current().nextInt(this.rows)]
                    [ThreadLocalRandom.current().nextInt(this.columns)];
        }while(res.isWormhole() || res.isOccupied());
        return res;
    }

    public Cell getCell(int x, int y){
        x = normalizeX(x);
        y = normalizeY(y);
        return field[y][x];
    }

    public int normalizeX(int x){
        while(x < 0) x += columns;
        return x % columns;
    }

    public int normalizeY(int y){
        while(y < 0) y += rows;
        return y % rows;
    }

    public ArrayList<Cell> getAvailableNeighbours(Cell src){
        ArrayList<Cell> availableNeighbours = new ArrayList<>();
        //right cell
        Cell x = getCell(src.getX() + 1,src.getY());
        if(!x.isOccupied()) availableNeighbours.add(x);
        //left cell
        x = getCell(src.getX()-1,src.getY());
        if(!x.isOccupied()) availableNeighbours.add(x);
        //up cell
        x = getCell(src.getX(),src.getY()+1);
        if(!x.isOccupied()) availableNeighbours.add(x);
        //down cell
        x = getCell(src.getX(),src.getY()-1);
        if(!x.isOccupied()) availableNeighbours.add(x);

        return availableNeighbours;
    }
    @Override
    public String toString() {
        String print = "";
        for(Cell[] row : field) {
            for (Cell x : row)
                print += x + " ";
            print += "\n";
        }
        return print;
    }

    public void setField(String[][] stringField){
        LinkedList<Wormhole> wormholes = new LinkedList<>();
        if(stringField.length == this.rows && stringField[0].length == this.columns){
            for(int i = 0; i < this.rows; i++){
                for(int j = 0; j < this.columns; j++){
                    if(stringField[i][j].equals("*")){
                        Wormhole w = new Wormhole(j,i,this);
                        this.field[i][j] = w;
                        wormholes.add(w);
                    }
                    else{
                        this.field[i][j] = new Cell(j,i,Integer.parseInt(stringField[i][j]));
                    }
                }
            }
            this.wormholeList = new WormholeList(wormholes);
        }
    }
}


