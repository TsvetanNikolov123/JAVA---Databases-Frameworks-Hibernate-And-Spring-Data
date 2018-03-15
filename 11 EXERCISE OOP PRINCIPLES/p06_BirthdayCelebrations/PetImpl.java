package p06_BirthdayCelebrations;

public class PetImpl implements Pet{
    private String name;
    private String birthday;

    public PetImpl(String name, String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
