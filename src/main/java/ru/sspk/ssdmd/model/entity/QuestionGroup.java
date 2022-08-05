package ru.sspk.ssdmd.model.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "question_group", catalog = "public", schema = "sspk_aets")
@Entity
public class QuestionGroup {

    @Column(name = "id_group")
    @Id
    private Long id;
    @Column(name = "name_group")
    private String name;
    @OneToMany
    private List<Question> questionList;

    public static class Builder {

        private Long id;
        private String name;
        private List<Question> questionList;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setQuestionList(List<Question> questionList) {
            this.questionList = questionList;
            return this;
        }

        public QuestionGroup build() {
            return new QuestionGroup(this);
        }
    }

    private QuestionGroup(Builder builder) {
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

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionGroup that = (QuestionGroup) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "QuestionGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}
