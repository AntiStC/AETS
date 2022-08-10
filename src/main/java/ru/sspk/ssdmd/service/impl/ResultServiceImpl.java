package ru.sspk.ssdmd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sspk.ssdmd.dao.ResultDao;
import ru.sspk.ssdmd.dao.TestDao;
import ru.sspk.ssdmd.model.dto.PersonDto;
import ru.sspk.ssdmd.model.dto.ResultDto;
import ru.sspk.ssdmd.model.dto.TestDto;
import ru.sspk.ssdmd.model.entity.Result;
import ru.sspk.ssdmd.model.mapper.ResultMapper;
import ru.sspk.ssdmd.model.mapper.TestMapper;
import ru.sspk.ssdmd.service.ResultService;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;

@Service
public class ResultServiceImpl implements ResultService {
    private final ResultDao resultDao;
    private final TestDao testDao;

    @Autowired
    public ResultServiceImpl(ResultDao resultDao, TestDao testDao) {
        this.resultDao = resultDao;
        this.testDao = testDao;
    }

    @Override
    public ResultDto generateResult(TestDto testDto, PersonDto personDto) {
        Result result = ResultMapper.toEntity(
                new ResultDto.Builder()
                        .setTestResult(testDto.getNumWrongAns() > 0)
                        .setTimeAt(new Timestamp(new Date().getTime()))
                        .setPersonList(Collections.singletonList(personDto))
                        .setTestList(Collections.singletonList(TestMapper.toDto(testDao.getById(testDto.getId()))))
                        .build());

        return ResultMapper.toDto(resultDao.save(result));
    }

    @Override
    public ResultDto saveResult(ResultDto resultDto) {
        return ResultMapper.toDto(resultDao.save(ResultMapper.toEntity(resultDto)));
    }
}
