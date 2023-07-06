package Home_work.IteratorTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import Home_work.FamilyTree.FamilyTree;
import Home_work.FamilyTree.Human;

public class PersonIterator implements Iterator<Human> {

    private Iterator<Human> iterator;
    private HashMap<String, Human> map;
    private ArrayList<Human> listPerson;

    public PersonIterator(HashMap<String, Human> map) {
        this.map = map;
        listPerson = (ArrayList<Human>) map.values();
    }

    public void sortById() {
        listPerson.sort(new CompareById());
        iterator = listPerson.iterator();
    }

    public void sortByName() {
        listPerson.sort(new CompareByName());
        iterator = listPerson.iterator();
    }

    public void sortByAge() {
        listPerson.sort(new CompareByAge());
        iterator = listPerson.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Human next() {
        return map.get(iterator.next());
    }
}