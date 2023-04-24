import java.util.LinkedList;

public class WormholeList extends LinkedList<Cell> {
    @Override
    public boolean add(Cell cell) {
        int i = 0;
        while(i < this.size() && this.get(i).getScore() > cell.getScore()) i++;
        super.add(i,cell);
        return true;
    }

    @Override
    public String toString() {
        String print = "";
        for(Cell c : this){
            print += "("+c.getX()+","+c.getY()+",s:"+c.getScore()+") - ";
        }
        return print;
    }
}
