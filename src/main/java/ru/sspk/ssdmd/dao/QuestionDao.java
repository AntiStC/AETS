package ru.sspk.ssdmd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sspk.ssdmd.model.entity.Question;

public interface QuestionDao extends JpaRepository<Question, Long> {
    Question findById(long id);

}
