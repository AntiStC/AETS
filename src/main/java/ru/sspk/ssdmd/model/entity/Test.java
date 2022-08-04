package ru.sspk.ssdmd.model.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "test", catalog = "public", schema = "sspk_aets")

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

    //TODO builder, getter, setter, construction, toString
}
