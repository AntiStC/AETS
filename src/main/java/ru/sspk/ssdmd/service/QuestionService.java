package ru.sspk.ssdmd.service;

import ru.sspk.ssdmd.model.dto.QuestionDto;

public interface QuestionService {

    QuestionDto save(QuestionDto questionDto);

    QuestionDto findById(long id);

}
