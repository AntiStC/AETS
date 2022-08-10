package ru.sspk.ssdmd.service;

import ru.sspk.ssdmd.model.dto.TestDto;

import java.util.List;

public interface TestService {
    List<TestDto> findAll();
    TestDto findByName(String testName);
    TestDto create(TestDto testDto);
    TestDto generate(String testName);

}
