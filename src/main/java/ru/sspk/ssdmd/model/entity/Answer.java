package ru.sspk.ssdmd.model.entity;


import javax.persistence.*;
import java.util.Objects;

@Table(name = "answer", schema = "public", catalog = "sspk_aets")
@Entity
public class Answer {

    @Column(name = "id_answer")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text_answer")
    private String textAnswer;
    @Column(name = "current")
    private Boolean current;

    public Answer() {
    }

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

        public Answer build() {
            return new Answer(this);
        }
    }

    private Answer(Builder builder) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return textAnswer.equals(answer.textAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textAnswer);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", textAnswer='" + textAnswer + '\'' +
                ", current=" + current +
                '}';
    }
}
