package softuni.judgesystem.entities;

import softuni.judgesystem.entities.base.BaseEntity;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "strategies")
public class Strategy extends BaseEntity {
    private String name;
    private Set<Contest> contests;

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(
            name = "strategies_contests",
            joinColumns =
            @JoinColumn(
                    name = "strategy_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns =
            @JoinColumn(
                    name = "contest_id",
                    referencedColumnName = "id"
            )
    )
    public Set<Contest> getContests() {
        return contests;
    }

    public void setContests(Set<Contest> contests) {
        this.contests = contests;
    }
}
