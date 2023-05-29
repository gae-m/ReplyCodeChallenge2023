import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.LinkedList;

public class WormholeList extends LinkedList<Wormhole> implements PropertyChangeListener {
    //A Sorted Linked List of Wormhole
    public WormholeList(LinkedList<Wormhole> wormholes){
        for(Wormhole w : wormholes){
            w.updateRank();
            this.add(w);
            w.addListener(this);
        }
    }

    @Override
    public boolean add(Wormhole wormhole) {
        int i = 0;
        Iterator<Wormhole> iter = this.iterator();
        while(iter.hasNext() && iter.next().getRank() > wormhole.getRank()) i++;
//        while(i < this.size() && this.get(i).getRank() > wormhole.getRank()) i++;
        super.add(i,wormhole);
        return true;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object src = evt.getSource();
        if(src instanceof Wormhole){
            Wormhole w = (Wormhole) src;
            this.remove(w);
            this.add(w);
        }
    }

    @Override
    public String toString() {
        String print = "";

        for(Wormhole w: this){
            print += w + " - ";
        }

        return print;
    }
}
