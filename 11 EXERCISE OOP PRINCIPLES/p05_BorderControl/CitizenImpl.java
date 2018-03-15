package p05_BorderControl;

public class CitizenImpl implements Citizen {
    private String id;
    private String name;
    private int age;

    public CitizenImpl(String id, String name, int age) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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
    public String getId() {
        return this.id;
    }
}
