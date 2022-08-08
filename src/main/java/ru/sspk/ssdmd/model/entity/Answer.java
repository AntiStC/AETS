package ru.sspk.ssdmd.model.entity;


import javax.persistence.*;
import java.util.Objects;

@Table(name = "answer", catalog = "public", schema = "sspk_aets")
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
    @Column(name = "qwestion_fk")
    @OneToMany
    private Question question;

    public static class Builder {

        private Long id;
        private String textAnswer;
        private Boolean current;
        private Question question;

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

        public Builder setQuestion(Question question) {
            this.question = question;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
                ", question=" + question +
                '}';
    }
}
