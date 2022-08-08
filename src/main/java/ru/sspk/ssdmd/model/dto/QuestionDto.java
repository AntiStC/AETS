package ru.sspk.ssdmd.model.dto;

import java.sql.Timestamp;

public class QuestionDto {

    private Long id;
    private String bodyQuestion;
    private Timestamp createAt;
    private Timestamp modifyAt;

    public QuestionDto() {
    }

    public static class Builder {

        private Long id;
        private String bodyQuestion;
        private Timestamp createAt;
        private Timestamp modifyAt;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setBodyQuestion(String bodyQuestion) {
            this.bodyQuestion = bodyQuestion;
            return this;
        }

        public Builder setCreateAt(Timestamp createAt) {
            this.createAt = createAt;
            return this;
        }

        public Builder setModifyAt(Timestamp modifyAt) {
            this.modifyAt = modifyAt;
            return this;
        }

        public QuestionDto build() {
            return new QuestionDto(this);
        }
    }

    private QuestionDto(Builder builder) {
        this.id = builder.id;
        this.bodyQuestion = builder.bodyQuestion;
        this.createAt = builder.createAt;
        this.modifyAt = builder.modifyAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBodyQuestion() {
        return bodyQuestion;
    }

    public void setBodyQuestion(String bodyQuestion) {
        this.bodyQuestion = bodyQuestion;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Timestamp modifyAt) {
        this.modifyAt = modifyAt;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "id=" + id +
                ", bodyQuestion='" + bodyQuestion + '\'' +
                ", createAt=" + createAt +
                ", modifyAt=" + modifyAt +
                '}';
    }
}
