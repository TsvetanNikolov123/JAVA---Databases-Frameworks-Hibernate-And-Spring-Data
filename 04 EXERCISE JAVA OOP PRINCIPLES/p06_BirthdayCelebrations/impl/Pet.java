package p06_BirthdayCelebrations.impl;

import p06_BirthdayCelebrations.interfaces.Birthable;
import p06_BirthdayCelebrations.interfaces.Nameable;

public class Pet implements Nameable, Birthable {

    private final String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getName() {
        return name;
    }
}
