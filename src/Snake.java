import java.util.LinkedList;

public class Snake {
    private int score;
    private final int length;
    private LinkedList<Cell> body;
    private int headX;
    private int headY;

    public void place(int x, int y){

    }

    public Snake(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Snake: " + this.hashCode() + "\n\tLength: " + length;
    }
}
