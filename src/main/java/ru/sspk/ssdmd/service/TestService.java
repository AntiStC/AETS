package ru.sspk.ssdmd.service;

import ru.sspk.ssdmd.model.dto.TestDto;

import java.util.List;

public interface TestService {
    List<TestDto> findAll();

}
