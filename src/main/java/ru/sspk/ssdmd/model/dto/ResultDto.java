package ru.sspk.ssdmd.model.dto;


import javax.persistence.ManyToMany;
import java.sql.Timestamp;
import java.util.List;

public class ResultDto {

    private Long id;
    private Boolean testResult;
    private Timestamp timeAt;
    private List<TestDto> testList;

    @ManyToMany
    private List<PersonDto> personList;

    public ResultDto() {
    }

    public static class Builder {

        private Long id;
        private Boolean testResult;
        private Timestamp timeAt;
        private List<TestDto> testList;
        private List<PersonDto> personList;

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

        public Builder setTestList(List<TestDto> testList) {
            this.testList = testList;
            return this;
        }

        public Builder setPersonList(List<PersonDto> personList) {
            this.personList = personList;
            return this;
        }

        public ResultDto build() {
            return new ResultDto(this);
        }
    }

    public ResultDto(Builder builder) {
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

    public List<TestDto> getTestList() {
        return testList;
    }

    public void setTestList(List<TestDto> testList) {
        this.testList = testList;
    }

    public List<PersonDto> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonDto> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "id=" + id +
                ", testResult=" + testResult +
                ", timeAt=" + timeAt +
                ", testList=" + testList +
                ", personList=" + personList +
                '}';
    }
}
