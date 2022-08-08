package ru.sspk.ssdmd.model.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "test", schema = "public", catalog = "sspk_aets")

public class Test {

    @Column(name = "id_test")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "number_wrong_answer")
    private Integer numWrongAns;
    @Column(name = "count_question")
    private Integer countQuest;
    @Column(name = "create_at")
    private Timestamp createAt;
    @ManyToMany
    private List<Question> questionList;

    public Test() {
    }

    public static class Builder {

        private Long id;
        private String name;
        private Integer numWrongAns;
        private Integer countQuest;
        private Timestamp createAt;
        private List<Question> questionList;

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

        public Builder setQuestionList(List<Question> questionList) {
            this.questionList = questionList;
            return this;
        }

        public Test build() {
            return new Test(this);
        }
    }

    private Test(Builder builder) {
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
        Test test = (Test) o;
        return name.equals(test.getName());

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numWrongAns=" + numWrongAns +
                ", countQuest=" + countQuest +
                ", createAt=" + createAt +
                ", questionList=" + questionList +
                '}';
    }
}
