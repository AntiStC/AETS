package ru.sspk.ssdmd.model.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "result", schema = "public", catalog = "sspk_aets")
public class Result {

    @Column(name = "id_result")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test_result")
    private Boolean testResult;

    @Column(name = "time_at")
    private Timestamp timeAt;

    @ManyToMany
    private List<Test> testList;

    @ManyToMany
    private List<Person> personList;

    public Result() {
    }

    public static class Builder {

        private Long id;
        private Boolean testResult;
        private Timestamp timeAt;
        private List<Test> testList;
        private List<Person> personList;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setTestResult(Boolean testResult) {
            this.testResult = testResult;
            return this;
        }

        public Builder setTimeAt(Timestamp timeAt) {
            this.timeAt = timeAt;
            return this;
        }

        public Builder setTestList(List<Test> testList) {
            this.testList = testList;
            return this;
        }

        public Builder setPersonList(List<Person> personList) {
            this.personList = personList;
            return this;
        }

        public Result build() {
            return new Result(this);
        }
    }

    public Result(Builder builder) {
        this.id = builder.id;
        this.testResult = builder.testResult;
        this.timeAt = builder.timeAt;
        this.testList = builder.testList;
        this.personList = builder.personList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getTestResult() {
        return testResult;
    }

    public void setTestResult(Boolean testResult) {
        this.testResult = testResult;
    }

    public Timestamp getTimeAt() {
        return timeAt;
    }

    public void setTimeAt(Timestamp timeAt) {
        this.timeAt = timeAt;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return testResult.equals(result.testResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testResult);
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", testResult=" + testResult +
                ", timeAt=" + timeAt +
                ", testList=" + testList +
                ", personList=" + personList +
                '}';
    }
}
