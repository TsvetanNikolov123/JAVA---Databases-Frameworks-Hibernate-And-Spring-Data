package p02_MultipleImplementation;

public class Citizen implements Person, Birthable, Identifiable {
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
    public String birthdate() {
        return this.birthdate;
    }

    @Override
    public String id() {
        return this.id;
    }
}
