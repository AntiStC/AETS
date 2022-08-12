package ru.sspk.ssdmd.service;

import ru.sspk.ssdmd.model.dto.PersonDto;
import ru.sspk.ssdmd.model.dto.ResultDto;
import ru.sspk.ssdmd.model.dto.TestDto;

import java.util.List;

public interface ResultService {
    ResultDto generateResult(TestDto testDto, PersonDto personDto);
    ResultDto saveResult(ResultDto resultDto);
    List<ResultDto> getByPersonListUsersLogin(String login);
}
