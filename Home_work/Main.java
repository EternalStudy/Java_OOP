package Home_work;

import java.time.LocalDate;

public class Main {
    public static void main (String[] args){
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1999, 5, 10));
        Human nastya = new Human("Настя", Gender.Female, LocalDate.of(2000, 3, 19));
        tree.add(vasya);
        tree.add(nastya);
        tree.setWedding(vasya.getId(), nastya.getId());

        Human irina = new Human("Ирина", Gender.Female, LocalDate.of(2019, 1, 07), vasya, nastya);
        tree.add(irina);

        Human dmitry = new Human("Дмитрий", Gender.Male, LocalDate.of(1970, 11, 11));
        dmitry.addChild(vasya);

        System.out.println(tree);
    }
}
