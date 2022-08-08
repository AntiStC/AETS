package ru.sspk.ssdmd.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Table(name = "question", schema = "public", catalog = "sspk_aets")
@Entity
public class Question {

    @Column(name = "id_question")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text_question")
    private String bodyQuestion;
    @Column(name = "create_at")
    private Timestamp createAt;
    @Column(name = "modify_at")
    private Timestamp modifyAt;
    @OneToMany
    private List<Answer> answers;

    public Question() {
    }

    public static class Builder {

        private Long id;
        private String bodyQuestion;
        private Timestamp createAt;
        private Timestamp modifyAt;
        private List<Answer> answers;

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

        public Builder setAnswers(List<Answer> answers) {
            this.answers = answers;
            return this;
        }

        public Question build() {
            return new Question(this);
        }
    }

    private Question(Builder builder) {
        this.id = builder.id;
        this.bodyQuestion = builder.bodyQuestion;
        this.createAt = builder.createAt;
        this.modifyAt = builder.modifyAt;
        this.answers = builder.answers;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return bodyQuestion.equals(question.bodyQuestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodyQuestion);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", bodyQuestion='" + bodyQuestion + '\'' +
                ", createAt=" + createAt +
                ", modifyAt=" + modifyAt +
                ", answers=" + answers +
                '}';
    }
}
