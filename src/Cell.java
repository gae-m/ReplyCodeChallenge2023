public class Cell implements Comparable<Cell>{
    private final int x;
    private final int y;
    private int score;
    private boolean isOccupied = false;

    public Cell(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
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

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
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
        return this.getClass() == Wormhole.class;
    }
}
