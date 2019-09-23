package softuni.judgesystem.entities;

import softuni.judgesystem.entities.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "contests")
public class Contest extends BaseEntity {
    private String name;
    private Category category;
    private Set<Problem> problems;
    private Set<User> contestants;
    private Set<MaxResultForContest> maxResultsForContest;

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "contest")
    public Set<Problem> getProblems() {
        return problems;
    }

    public void setProblems(Set<Problem> problems) {
        this.problems = problems;
    }

    @ManyToMany(mappedBy = "contests")
    public Set<User> getContestants() {
        return contestants;
    }

    public void setContestants(Set<User> contestants) {
        this.contestants = contestants;
    }

    @OneToMany(mappedBy = "contest")
    public Set<MaxResultForContest> getMaxResultsForContest() {
        return maxResultsForContest;
    }

    public void setMaxResultsForContest(Set<MaxResultForContest> maxResultsForContest) {
        this.maxResultsForContest = maxResultsForContest;
    }
}
