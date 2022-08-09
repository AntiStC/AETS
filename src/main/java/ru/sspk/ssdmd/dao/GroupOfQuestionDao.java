package ru.sspk.ssdmd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sspk.ssdmd.model.entity.QuestionGroup;

public interface GroupOfQuestionDao extends JpaRepository<QuestionGroup, Long> {
}
