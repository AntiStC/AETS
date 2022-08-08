package ru.sspk.ssdmd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sspk.ssdmd.model.entity.Answer;

public interface AnswerDao extends JpaRepository<Answer, Long> {
}
