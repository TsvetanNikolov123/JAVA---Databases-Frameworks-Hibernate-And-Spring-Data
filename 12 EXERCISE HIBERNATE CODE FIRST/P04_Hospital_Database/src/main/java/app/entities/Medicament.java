package app.entities;

import javax.persistence.*;

@Entity
@Table(name = "medicaments")
public class Medicament {

    private Long id;
    private String name;
    private Patient patient;

    public Medicament() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicament_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "medicament_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id", foreignKey = @ForeignKey(name = "fk_medicaments_patients"))
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
