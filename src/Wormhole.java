public class Wormhole extends Cell{
    private int rank;

    public Wormhole(int x, int y, int rank) {
        super(x, y, 0);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Cell b) {
        if(b.getClass() == Wormhole.class){
            return ((Wormhole) b).rank - this.rank;
        }
        else return super.compareTo(b);
    }
}
