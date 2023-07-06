package Home_work.IteratorTree;
import java.util.Comparator;

import Home_work.FamilyTree.Human;

public class CompareByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
