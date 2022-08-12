package ru.sspk.ssdmd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sspk.ssdmd.dao.AnswerDao;
import ru.sspk.ssdmd.model.dto.AnswerDto;
import ru.sspk.ssdmd.model.entity.Answer;
import ru.sspk.ssdmd.model.mapper.AnswerMapper;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerDao answerDao;

    @Autowired
    public AnswerServiceImpl(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Override
    public AnswerDto save(AnswerDto answerDto) {
        Answer answer = AnswerMapper.toEntity(answerDto);
        answer = answerDao.save(answer);
        answerDto = AnswerMapper.toDto(answer);
        return answerDto;
    }

}
