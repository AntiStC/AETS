package ru.sspk.ssdmd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sspk.ssdmd.dao.TestDao;
import ru.sspk.ssdmd.model.dto.TestDto;
import ru.sspk.ssdmd.model.mapper.TestMapper;
import ru.sspk.ssdmd.service.TestService;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private final TestDao dao;

    @Autowired
    public TestServiceImpl(TestDao dao) {
        this.dao = dao;
    }

    @Override
    public List<TestDto> findAll() {
        return TestMapper.toListTest(dao.findAll());
    }

    @Override
    public TestDto create(TestDto testDto) {
        return TestMapper.toDto(dao.save(TestMapper.toEntity(testDto)));
    }

}
