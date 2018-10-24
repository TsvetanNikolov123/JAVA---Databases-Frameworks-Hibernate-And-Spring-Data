package p10_GroupByGroup;

import java.util.Map;

public class Person {
    private String name;
    private Integer group;

    public Person(String name, Integer group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public Integer getGroup() {
        return group;
    }
}
