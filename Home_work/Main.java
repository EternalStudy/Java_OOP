package Home_work;
public class Main{
    public static void main(String[] args) {
        Persona per1 = new Persona("N1", "S1", Persona.Sex.Male, null);
        Persona per2 = new Persona("N2", "S2", Persona.Sex.Male, per1);
        Persona per3 = new Persona("N3", "S3", Persona.Sex.Female, per2);
        Persona per4 = new Persona("N4", "S4", Persona.Sex.Male, per3);
        Persona per5 = new Persona("N5", "S5", Persona.Sex.Female, per3);
        Persona per6 = new Persona("N6", "S6", Persona.Sex.Female, per5);

        System.out.println("Parent('s): ");
        for (Persona person : per2.getParents()) {
            System.out.println(person.getNameData());
        }

        System.out.println("Children are: ");
        for (Persona person : per3.getChildren()) {
            System.out.println(person.getNameData());
        }

        System.out.println("Subparents are: ");
        for (Persona person : per3.getSubParents()) {
            System.out.println(person.getNameData());
        }

        System.out.println("Subchildren are: ");
        for (Persona person : per3.getSubChildren()) {
            System.out.println(person.getNameData());
        }
    }
}