package ru.sspk.ssdmd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sspk.ssdmd.dao.QuestionDao;
import ru.sspk.ssdmd.model.dto.QuestionDto;
import ru.sspk.ssdmd.model.entity.Question;
import ru.sspk.ssdmd.model.mapper.QuestionMapper;
import ru.sspk.ssdmd.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    @Autowired
    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public QuestionDto save(QuestionDto questionDto) {
        Question question = QuestionMapper.toEntity(questionDto);
        question = questionDao.save(question);
        questionDto = QuestionMapper.toDto(question);
        return questionDto;
    }

    @Override
    public QuestionDto findById(int id) {
        Question question = questionDao.findById(id);
        QuestionDto questionDto = null;
        if (null != question) return questionDto = QuestionMapper.toDto(question);
        return questionDto;
    }
}
