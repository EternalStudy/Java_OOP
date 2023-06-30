package Home_work;
public abstract class FamilyTree{
    private String name;
    private String surname;

    private FamilyTree parent;

    private FamilyTree child;

    public void getParent(){}

    public void setParent(){}
    
    public void getChild(){}

    public void setChild(){}

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getNameData(){
        return "Person is" + name + " " + surname;
    }
}