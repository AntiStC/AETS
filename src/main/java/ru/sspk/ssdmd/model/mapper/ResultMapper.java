package ru.sspk.ssdmd.model.mapper;

import ru.sspk.ssdmd.model.dto.PersonDto;
import ru.sspk.ssdmd.model.dto.ResultDto;
import ru.sspk.ssdmd.model.dto.TestDto;
import ru.sspk.ssdmd.model.entity.Person;
import ru.sspk.ssdmd.model.entity.Result;
import ru.sspk.ssdmd.model.entity.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultMapper {

    public static ResultDto toDto(Result result) {

        List<TestDto> testDtoList = null;
        if (result.getTestList() != null) {
            testDtoList = result.getTestList().stream()
                    .map(TestMapper::toDto).toList();
        }

        List<PersonDto> personDtoList = null;
        if (result.getPersonList() != null) {
            personDtoList = result.getPersonList().stream()
                    .map(PersonMapper::toDto).toList();
        }

        ResultDto resultDto = new ResultDto.Builder()
                .setId(result.getId())
                .setTestResult(result.getTestResult())
                .setTimeAt(result.getTimeAt())
                .setTestList(testDtoList)
                .setPersonList(personDtoList)
                .build();

        return resultDto;
    }

    public static Result toEntity(ResultDto resultDto) {

        List<Test> testList = null;
        if (resultDto.getTestList() != null) {
            testList = resultDto.getTestList().stream()
                    .map(TestMapper::toEntity).toList();
        }

        List<Person> personList = null;
        if (resultDto.getPersonList() != null) {
            personList = resultDto.getPersonList().stream()
                    .map(PersonMapper::toEntity).toList();
        }

        Result result = new Result.Builder()
                .setId(resultDto.getId())
                .setTestResult(resultDto.getTestResult())
                .setTimeAt(resultDto.getTimeAt())
                .setTestList(testList)
                .setPersonList(personList)
                .build();

        return result;
    }

    public static List<ResultDto> toListResult(List<Result> resultList) {

        return new ArrayList<>((resultList).stream().map(ResultMapper::toDto)
                .collect(Collectors.toList()));
    }
}
