package p05_BorderControl.impl;

public class Robot extends AbstractIdentable {
    private final String model;

    public Robot(String id, String model) {
        super(id);
        this.model = model;
    }
}
