package Home_work.IteratorTree;
import java.time.LocalDate;
import java.util.Comparator;

import Home_work.FamilyTree.Human;

public class CompareByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
