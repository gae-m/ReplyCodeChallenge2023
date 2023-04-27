import java.util.LinkedList;

public class WormholeList extends LinkedList<Wormhole> {
    //A Sorted Linked List of Wormhole

    @Override
    public boolean add(Wormhole wormhole) {
        int i = 0;
        while(i < this.size() && this.get(i).getRank() > wormhole.getRank()) i++;
        super.add(i,wormhole);
        return true;
    }

    @Override
    public String toString() {
        String print = "";
        for(Wormhole c : this){
            print += "("+c.getX()+","+c.getY()+",s:"+c.getRank()+") - ";
        }
        return print;
    }
}
