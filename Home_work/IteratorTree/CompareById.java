package Home_work.IteratorTree;
import java.util.Comparator;

import Home_work.FamilyTree.Human;

public class CompareById implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getId(),o2.getId());
    }
    
}
