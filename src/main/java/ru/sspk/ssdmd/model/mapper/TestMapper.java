package ru.sspk.ssdmd.model.mapper;

import ru.sspk.ssdmd.model.dto.QuestionDto;
import ru.sspk.ssdmd.model.dto.TestDto;
import ru.sspk.ssdmd.model.entity.Question;
import ru.sspk.ssdmd.model.entity.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestMapper {

    public static TestDto toDto(Test test) {

        List<QuestionDto> questionDtoList = null;
        if (test.getQuestionList() != null) {
            questionDtoList = test.getQuestionList().stream()
                    .map(QuestionMapper::toDto).toList();
        }

        TestDto testDto = new TestDto.Builder()
                .setId(test.getId())
                .setName(test.getName())
                .setNumWrongAns(test.getNumWrongAns())
                .setCountQuest(test.getCountQuest())
                .setCreateAt(test.getCreateAt())
                .setQuestionList(questionDtoList)
                .build();

        return testDto;
    }

    public static Test toEntity(TestDto testDto) {

        List<Question> questionList = null;
        if (testDto.getQuestionList() != null) {
            questionList = testDto.getQuestionList().stream()
                    .map(QuestionMapper::toEntity).toList();
        }

        Test test = new Test.Builder()
                .setId(testDto.getId())
                .setName(testDto.getName())
                .setNumWrongAns(testDto.getNumWrongAns())
                .setCountQuest(testDto.getCountQuest())
                .setCreateAt(testDto.getCreateAt())
                .setQuestionList(questionList)
                .build();

        return test;
    }

    public static List<TestDto> toListTest(List<Test> testList) {

        return new ArrayList<>((testList).stream().map(TestMapper::toDto)
                .collect(Collectors.toList()));
    }
}
