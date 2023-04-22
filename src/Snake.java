public class Snake {
    private int score;
    private final int length;
    private String path;
    private int headX;
    private int headY;

    public Snake(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Snake: " + this.hashCode() + "\n\tLength: " + length;
    }
}
