package Home_work.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;

public class Married implements Serializable {
    private int id;
    private LocalDate startDate, endDate;
    private Human wife, husband;
    private static final int ageAdult = 18;
    private boolean isError = false;

    public Married(int id, LocalDate starDate, Human wife, Human husband) {
        this.id = id;
        this.startDate = starDate;
        if (wife == null || wife.getGender() != Gender.Female
                || wife.getBirthDate().plusYears(ageAdult).compareTo(this.startDate) > 0
                || wife.getMarried() != null) {
            isError = true;
            return;
        }
        if (husband == null || husband.getGender() != Gender.Male
                || husband.getBirthDate().plusYears(ageAdult).compareTo(this.startDate) > 0 // не достигнут возраст
                                                                                                // совершеннолетия
                || husband.getMarried() != null) {
            isError = true;
            return;
        }
        this.wife = wife;
        wife.setMarried(this);
        this.husband = husband;
        husband.setMarried(this);
    }

    public boolean getIsError() {
        return isError;
    }

    public int getId() {
        return id;
    }

    public boolean finish(LocalDate endDate) {
        if (endDate.compareTo(startDate) < 0)
            return false;
        this.endDate = endDate;
        wife.setMarried(null);
        husband.setMarried(null);
        return true;
    }
    public String getInfo(){
        return"{id: "+id
        +",startDate:" +startDate.toString()
        +", endDate:" +endDate.toString()
        +",\nСупруга: " + wife.getInfo()
        +",\nСупруг: " + husband.getInfo() 
        +"}";
    }

    @Override
    public String toString(){
        return getInfo();
    }
}
