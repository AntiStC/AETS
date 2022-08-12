package ru.sspk.ssdmd.service;

import ru.sspk.ssdmd.model.dto.TestDto;

import java.security.Principal;
import java.util.List;

public interface TestService {
    List<TestDto> findAll();
    TestDto findByName(String testName);
    TestDto create(TestDto testDto);
    TestDto generate(String testName);
    TestDto findById(Long id);
    TestDto save (TestDto testDto);
    void deleteById(Long id);
    List<TestDto> findListOfTestForUser(Principal principal);

}
