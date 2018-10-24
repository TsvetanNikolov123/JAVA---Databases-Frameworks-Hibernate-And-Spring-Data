package p05_BorderControl;

public class RobotImpl implements Robot{
    private String id;
    private String name;

    public RobotImpl(String id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
