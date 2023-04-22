public class Snake {
    private int score;
    private int length;
    private String path;
    private int headX;
    private int headY;

    public Snake(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        String print = new String();
        print += "Snake: " + this.hashCode();
        print += "\n\tLength: " + length;
        return print;
    }
}
