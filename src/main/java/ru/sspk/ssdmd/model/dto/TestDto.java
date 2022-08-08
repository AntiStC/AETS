package ru.sspk.ssdmd.model.dto;


import java.sql.Timestamp;
import java.util.List;

public class TestDto {
    private Long id;
    private String name;
    private Integer numWrongAns;
    private Integer countQuest;
    private Timestamp createAt;
    private List<QuestionDto> questionList;

    public TestDto() {
    }

    public static class Builder {

        private Long id;
        private String name;
        private Integer numWrongAns;
        private Integer countQuest;
        private Timestamp createAt;
        private List<QuestionDto> questionList;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setNumWrongAns(Integer numWrongAns) {
            this.numWrongAns = numWrongAns;
            return this;
        }

        public Builder setCountQuest(Integer countQuest) {
            this.countQuest = countQuest;
            return this;
        }

        public Builder setCreateAt(Timestamp createAt) {
            this.createAt = createAt;
            return this;
        }

        public Builder setQuestionList(List<QuestionDto> questionList) {
            this.questionList = questionList;
            return this;
        }

        public TestDto build() {
            return new TestDto(this);
        }
    }

    private TestDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.numWrongAns = builder.numWrongAns;
        this.countQuest = builder.countQuest;
        this.createAt = builder.createAt;
        this.questionList = builder.questionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumWrongAns() {
        return numWrongAns;
    }

    public void setNumWrongAns(Integer numWrongAns) {
        this.numWrongAns = numWrongAns;
    }

    public Integer getCountQuest() {
        return countQuest;
    }

    public void setCountQuest(Integer countQuest) {
        this.countQuest = countQuest;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public List<QuestionDto> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionDto> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numWrongAns=" + numWrongAns +
                ", countQuest=" + countQuest +
                ", createAt=" + createAt +
                ", questionList=" + questionList +
                '}';
    }
}
