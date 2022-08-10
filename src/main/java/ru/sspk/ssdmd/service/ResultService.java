package ru.sspk.ssdmd.service;

import ru.sspk.ssdmd.model.dto.PersonDto;
import ru.sspk.ssdmd.model.dto.ResultDto;
import ru.sspk.ssdmd.model.dto.TestDto;

public interface ResultService {
    ResultDto generateResult(TestDto testDto, PersonDto personDto);
    ResultDto saveResult(ResultDto resultDto);
}
