import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Cell implements Comparable<Cell>{
    private final int x;
    private final int y;
    private final int score;
    private boolean isOccupied = false;

    protected PropertyChangeSupport pcs;

    public Cell(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
        pcs = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener pcl){
        pcs.addPropertyChangeListener(pcl);
    }

    public void removeListener(PropertyChangeListener pcl){
        pcs.removePropertyChangeListener(pcl);
    }

    @Override
    public String toString() {
        return Integer.toString(score);
    }

    @Override
    public int compareTo(Cell b) {
        //sort in descending order
        return b.getScore()-this.score;
    }

//    public void setScore(int score) {
//        this.score = score;
//    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        boolean oldValue = isOccupied;
        isOccupied = occupied;
        pcs.firePropertyChange("Occupied",oldValue,occupied);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScore() {
        return score;
    }

    public boolean isWormhole() {
        return this instanceof Wormhole;
    }
}
