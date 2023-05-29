import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Wormhole extends Cell implements PropertyChangeListener {
    private final static int WORMHOLE_RANK_RANGE = 2;
    private int rank;
    private Map map;

    public Wormhole(int x, int y, Map map) {
        super(x, y, 0);
        this.rank = 0;
        this.map = map;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.updateRank();
    }

    public int getRank() {
        return rank;
    }

//    public void setRank(int rank) {
//        this.rank = rank;
//    }

    public int compareTo(Wormhole b){
        //descending order
        return b.getRank() - this.rank;
    }

    @Override
    public String toString() {
       return "("+this.getX()+","+this.getY()+",r: "+this.getRank()+")";
    }

    @Override
    public void setOccupied(boolean occupied) {
    }

//    @Override
//    public void setScore(int score) {
//    }

    public void updateRank(){
        int newRank = 0;
        ArrayList<Couple> indexCouples = new ArrayList<>(2*(WORMHOLE_RANK_RANGE+1)*WORMHOLE_RANK_RANGE);
        for(int k = 0; k < WORMHOLE_RANK_RANGE; k++){
            int range = WORMHOLE_RANK_RANGE - k;
            for(int i = 0; i <= range; i++){
                int j = range - i;
                indexCouples.add(new Couple(i,j));
                if( i != 0) indexCouples.add(new Couple(-i,j));
                if(i != 0 && j != 0) indexCouples.add(new Couple(-i,-j));
                if(j != 0) indexCouples.add(new Couple(i,-j));
            }
        }

        for(Couple index: indexCouples){
            Cell x = map.getCell(this.getX()+ index.getJ(), this.getY()+index.getI());
            x.removeListener(this);
            if(!x.isOccupied() && !x.isWormhole()) {
                newRank += x.getScore();
                x.addListener(this);
            }
        }
        int oldRank = this.rank;
        this.rank = newRank;
        pcs.firePropertyChange("Rank",oldRank,newRank);
    }
}

class Couple{
    private final int i;
    private final int j;

    public Couple(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public String toString() {
        return "(" + i + "," + j + ")";
    }
}
