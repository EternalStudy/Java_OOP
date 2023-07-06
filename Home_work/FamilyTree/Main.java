package Home_work.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;

import Home_work.Serialization.FileHandler;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int humanId = 0;
        FamilyTree tree = new FamilyTree();

        Human anton = new Human(humanId++, "Антон", LocalDate.of(1990, 10, 16), Gender.Male);
        Human helen = new Human(humanId++, "Елена", LocalDate.of(1993, 04, 01), Gender.Female);
        Human andrew = new Human(humanId++, "Андрей", LocalDate.of(2012, 12, 31), Gender.Male);
        tree.addHuman(anton);
        tree.addHuman(helen);
        tree.addHuman(andrew);

        //Добавляем связи "родители-дети"
        anton.addChild(andrew);
        helen.addChild(andrew);

        // Регистрируем брак
        Married m = tree.addMarried(LocalDate.of(2011, 10, 16), helen, anton);

        //Андрей развелся с Еленой и женился на Маше
        m.finish(LocalDate.of(2015, 1, 16));
        Human masha = new Human(humanId++, "Маша", LocalDate.of(1994, 11, 5), Gender.Female);
        tree.addHuman(masha);
        tree.addMarried(LocalDate.of(2016, 1, 1), masha, anton);

        System.out.println(String.format("tree info: \n%s", tree.toString()));

        //Выполняем запись в файл и последующее чтение
        FileHandler filehandler = new FileHandler();
        filehandler.SaveTo(tree, new String[] {"tree.txt"});

        FamilyTree treeOut = (FamilyTree)filehandler.LoadFrom(new String[] {"tree.txt"});
        //Дублируем вывод:
        System.out.println(String.format("treeOut info: \n%s", treeOut.toString()));
    }
}