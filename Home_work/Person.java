package Home_work;

import java.util.ArrayList;
import java.util.List;

public class Person {
    protected List<Person> children = new ArrayList<>(null);

    static protected List<Person> persons;

    public static Object Sex;
    protected Person parent = null;
    protected String firstname = null;
    protected String secondname = null;

    static {
        persons = new ArrayList<>(null);
    }

    public Person(String secondname, String firstname) {
        this.secondname = secondname;
        this.firstname = firstname;
        this.addPerson(this);
    }

    public Person(String secondname, String firstname, Person parent){
        this.secondname = secondname;
        this.firstname = firstname;
        this.parent = parent;
        parent.addChild(this);
        this.addPerson(this);
    }
    public void addPerson(Person person){
        persons.add(person);
    }
    public static List<Person> getPersons(){
        return persons;
    }
    public List<Person> getChildren(){
        return children;
    }
    public void setParent(Person parent){
        this.parent = parent;
        parent.addChild(this);
    }
    public Person getParent(){
        return this.parent;
    }
    public void addChild(Person child){
        this.children.add(child);
    }
    public String getFirstName(){
        return this.firstname;
    }
    public String getSecondName(){
        return this.secondname;
    }
    public void setFirstName(String firstname){
        this.firstname = firstname;
    }
    public void setSecondName(String secondname){
        this.secondname = secondname;
    }
     @Override
    public String toString(){
        return (firstname + " " + secondname);
    }
}