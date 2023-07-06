package Home_work.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humans;
    private List<Married> marrieds;
    private int idMarriage=0;

    public FamilyTree(){
        humans = new ArrayList<>();
        marrieds = new ArrayList<>();
    }

    public void addHuman(Human h){
        humans.add(h);
    }

    // При нарушении условий заключения брака возвращаем null
    public Married addMarried(LocalDate startDate, Human wife, Human husband){
        Married marriage = new Married(idMarriage, startDate, wife, husband);
        if(marriage.getIsError()) return null;
        marrieds.add(marriage);
        idMarriage++;
        return marriage;
    }

    public String getInfoMembers(){
        List<String> familyMembers = new ArrayList<>();
        for (Human h : humans)
            familyMembers.add(h.getInfo());
        return String.join("\n", familyMembers);
    }

    public String getInfoMarrieds(){
        List<String> strings = new ArrayList<>();
        for (Married m : marrieds)
            strings.add(m.getInfo());
        return String.join("\n", strings);
    }

    public Human getHumanById(int id){
        for(Human h : humans)
            if(h.getId() == id)
                return h;
        return null;
    }

    public String getInfoAll(){
        return "{ members: \n"
                + getInfoMembers()
                + ",\nmarrieds: \n"
                + getInfoMarrieds()
                + "\n}";
    }

    @Override
    public String toString() {
        return getInfoAll();
    }
    
}