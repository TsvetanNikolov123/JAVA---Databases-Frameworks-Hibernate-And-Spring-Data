package app.entities;

import app.annotations.Column;
import app.annotations.Entity;
import app.annotations.Id;

@Entity(name = "example_entities")
public class ExampleEntity {
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "town")
    private String town;

    public ExampleEntity(String fullName, String town){
        this.fullName = fullName;
        this.town = town;
    }
}
