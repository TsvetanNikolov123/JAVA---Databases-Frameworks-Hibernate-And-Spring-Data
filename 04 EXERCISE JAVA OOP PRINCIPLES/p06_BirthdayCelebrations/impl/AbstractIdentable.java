package p06_BirthdayCelebrations.impl;

import p06_BirthdayCelebrations.interfaces.Identable;

public abstract class AbstractIdentable implements Identable {

    private final String id;

    public AbstractIdentable(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
