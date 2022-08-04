package ru.sspk.ssdmd.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "question", catalog = "public", schema = "sspk_aets")
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

    //TODO builder, getter, setter, construction, toString
}
