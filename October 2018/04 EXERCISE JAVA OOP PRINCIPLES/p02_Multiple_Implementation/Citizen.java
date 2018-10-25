package p02_Multiple_Implementation;

import p02_Multiple_Implementation.interfaces.Birthable;
import p02_Multiple_Implementation.interfaces.Identifiable;
import p02_Multiple_Implementation.interfaces.Person;

public class Citizen implements Person, Identifiable, Birthable {

    private String name;
    private int age;
    private String id;
    private String birthdate;

    public Citizen(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String id() {
        return this.id;
    }

    @Override
    public String birthdate() {
        return this.birthdate;
    }
}
