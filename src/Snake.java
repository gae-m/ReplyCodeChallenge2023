import java.util.ArrayList;
import java.util.LinkedList;

public class Snake {
    private Cell initialCell;   //debug
    private final int id;
    private int score = 0;
    private final int length;
    private LinkedList<Cell> body;
    private final Map map;

    public int getScore(){
        return this.score;
    }

    public int getLength() {
        return length;
    }

    public LinkedList<Cell> getBody() {
        return new LinkedList<Cell>(body);
    }

    public void place(){
        body = new LinkedList<>();
        Cell firstCell = map.getInitialCell();
        for(int i = 0; i < length; i++) {body.add(firstCell); }
        firstCell.setOccupied(true);
        this.score += length * firstCell.getScore();
        this.initialCell = firstCell;   //debug

        for(int i = 0; i < length-1; i++){
            slither(discovery(body.getFirst()));
        }
    }

    private Cell discovery(Cell head){
        ArrayList<Cell> availableNeighbours = map.getAvailableNeighbours(head);
        availableNeighbours.sort(null);

        //first approach: avoid wormhole
        while(availableNeighbours.get(0).isWormhole()) availableNeighbours.remove(0);
        return availableNeighbours.get(0);
    }

    private void slither(Cell target){
        assert target != null;
        body.addFirst(target);
        score += target.getScore();
        target.setOccupied(true);

        body.getLast().setOccupied(false);
        score -= body.getLast().getScore();
        body.removeLast();
    }

    public String getPath(){
        String path = new String();
        Cell prevSegment = null;
        for(Cell currSegment : body){
            if(body.indexOf(currSegment) == 0){
                path += currSegment.getX() + " " + currSegment.getY()+ " ";
            }else{
                if(currSegment.getX() == map.normalizeX(prevSegment.getX()+1)) path += "R ";
                if(currSegment.getX() == map.normalizeX(prevSegment.getX()-1)) path += "L ";
                if(currSegment.getY() == map.normalizeY(prevSegment.getY()+1)) path += "U ";
                if(currSegment.getY() == map.normalizeY(prevSegment.getY()-1)) path += "D ";
            }
            prevSegment = currSegment;
        }
        return path;
    }

    public Snake(int id, int length, Map map) {
        this.id = id;
        this.length = length;
        this.map = map;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String print = "Snake " + this.id + ":" +
                "\n\tLength: " + length +
                "\n\tPath: " + getPath() +
                "\n\tScore: " + score +
                "\n\tBody: ";

        for(Cell c : body){
            if(body.indexOf(c) != 0) print += "-";
            print += "("+c.getX()+","+c.getY()+")";
        }

        print += "\n\tInitial Cell: "+"("+initialCell.getX()+","+initialCell.getY()+")";
        return print;
    }
}
