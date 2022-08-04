package ru.sspk.ssdmd.model.entity;


import javax.persistence.*;

@Table(name = "answer", catalog = "public",schema = "sspk_aets")
@Entity
public class Answer {

    @Column(name = "id_answer")
    @Id
    private Long id;
    @Column(name = "text_answer")
    private String textAnswer;
    @Column(name = "current")
    private Boolean current;
    @Column(name = "qwestion_fk")
    @OneToMany
    private Question question;

    //TODO builder, getter, setter, construction, toString
}
