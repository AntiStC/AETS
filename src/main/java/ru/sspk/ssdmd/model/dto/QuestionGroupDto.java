package ru.sspk.ssdmd.model.dto;


import java.util.List;

public class QuestionGroupDto {

    private Long id;
    private String name;
    private List<QuestionDto> questionList;

    public QuestionGroupDto() {
    }

    public static class Builder {

        private Long id;
        private String name;
        private List<QuestionDto> questionList;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setQuestionList(List<QuestionDto> questionList) {
            this.questionList = questionList;
            return this;
        }

        public QuestionGroupDto build() {
            return new QuestionGroupDto(this);
        }
    }

    private QuestionGroupDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
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

    public List<QuestionDto> getQuestionDtoList() {
        return questionList;
    }

    public void setQuestionDtoList(List<QuestionDto> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "QuestionGroupDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}
