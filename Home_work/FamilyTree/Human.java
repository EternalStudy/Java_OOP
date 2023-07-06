package Home_work.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Human implements Serializable {
    private int id;
    private String name;
    private LocalDate dateBirth, dateDeath;
    private Gender gender;
    private Human mother, father;
    private List<Human> children;
    private Married married; // супружество
    private LocalDate age =  LocalDate.now().minusDays(dateBirth.getYear());

    private static final int minParentAge = 17;

    public Human(int id, String name, LocalDate dateBirth, Gender gender) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.gender = gender;
        children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return dateBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public boolean setMother(Human mother) {
        if (this.mother != null
                || mother.getGender() != Gender.Female
                || mother.getBirthDate().plusYears(minParentAge).compareTo(this.dateBirth) > 0) 
                                                                                                
            return false;
        this.mother = mother;
        return true;
    }

    public Human getFather() {
        return father;
    }

    public boolean setFather(Human father) {
        if (this.father != null 
                || father.getGender() != Gender.Male
                || father.getBirthDate().plusYears(minParentAge).compareTo(this.dateBirth) > 0) 
                                                                                                
            return false;
        this.father = father;
        return true;
    }

    public List<Human> getChildren() {
        return children;
    }

    public boolean addChild(Human child) {
        if (this.gender == Gender.Male) {
            if (!child.setFather(this))
                return false;
        } else {
            if (!child.setMother(this))
                return false;
        }
        children.add(child);
        return true;
    }

    public Married getMarried() {
        return married;
    }

    public void setMarried(Married married) {
        this.married = married;
    }

    public String getInfo() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append(String.format("Имя: %s, ", name));
        result.append(String.format("Дата рождения: %s, ", dateBirth.toString()));
        result.append(String.format("Пол: %s, ", gender == Gender.Male ? "мужской" : "женский"));
        result.append(String.format("Отец: %s, ", (father == null ? "Нет данных" : father.getName())));
        result.append(String.format("Мать: %s, ", (mother == null ? "Нет данных" : mother.getName())));
        if (children.isEmpty()) {
            result.append("Дети: нет, ");
        } else {
            List<String> childrenNames = new ArrayList<>();
            for (Human child : children)
                childrenNames.add(child.getName());
            result.append(String.format("Дети: %s, ", String.join(",", childrenNames)));
        }
        if (this.married == null) {
            result.append(String.format("Семейное положение: %s", gender == Gender.Male ? "не женат" : "не замужем"));
        } else {
            result.append(String.format("Семейное положение: %s (idMarried: %d)",
                    (gender == Gender.Male ? "женат" : "замужем"), this.married.getId()));
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public LocalDate getAge() {
        return age;
    }
}