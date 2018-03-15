package p06_BirthdayCelebrations;

public class CitizenImpl implements Citizen {
    private String id;
    private String name;
    private int age;
    private String birthday;

    public CitizenImpl(String id, String name, int age, String birthday) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
        this.setBirthday(birthday);
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
