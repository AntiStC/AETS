package ru.sspk.ssdmd.model.dto;


public class AnswerDto {

    private Long id;
    private String textAnswer;
    private Boolean current;

    public static class Builder {

        private Long id;
        private String textAnswer;
        private Boolean current;

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

        public AnswerDto build() {
            return new AnswerDto(this);
        }
    }

    private AnswerDto(Builder builder) {
        this.id = builder.id;
        this.textAnswer = builder.textAnswer;
        this.current = builder.current;
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

    @Override
    public String toString() {
        return "AnswerDto{" +
                "id=" + id +
                ", textAnswer='" + textAnswer + '\'' +
                ", current=" + current +
                '}';
    }
}
