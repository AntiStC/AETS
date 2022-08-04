package ru.sspk.ssdmd.model.entity;


import javax.persistence.*;
import java.util.List;

@Table(name = "question_group",catalog = "public",schema = "sspk_aets")
@Entity
public class QuestionGroup {

    @Column(name = "id_group")
    @Id
    private Long id;
    @Column(name = "name_group")
    private String name;
    @OneToMany
    private List<Question> questionList;

    //TODO builder, getter, setter, construction, toString
}
