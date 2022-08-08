package ru.sspk.ssdmd.model.dto;


import java.util.List;

public class AnswerDto {

    private Long id;
    private String textAnswer;
    private Boolean current;
    private List<QuestionDto> question;

    public static class Builder {

        private Long id;
        private String textAnswer;
        private Boolean current;
        private List<QuestionDto> question;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setTextAnswer(String textAnswer) {
            this.textAnswer = textAnswer;
            return this;
        }

        public Builder setCurrent(Boolean current) {
            this.current = current;
            return this;
        }

        public Builder setQuestion(List<QuestionDto> question) {
            this.question = question;
            return this;
        }

        public AnswerDto build() {
            return new AnswerDto(this);
        }
    }

    private AnswerDto(Builder builder) {
        this.id = builder.id;
        this.textAnswer = builder.textAnswer;
        this.current = builder.current;
        this.question = builder.question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public List<QuestionDto> getQuestionDto() {
        return question;
    }

    public void setQuestionDto(List<QuestionDto> question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "AnswerDto{" +
                "id=" + id +
                ", textAnswer='" + textAnswer + '\'' +
                ", current=" + current +
                ", question=" + question +
                '}';
    }
}
