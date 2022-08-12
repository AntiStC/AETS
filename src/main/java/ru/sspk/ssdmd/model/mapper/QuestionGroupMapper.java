package ru.sspk.ssdmd.model.mapper;

import ru.sspk.ssdmd.model.dto.QuestionDto;
import ru.sspk.ssdmd.model.dto.QuestionGroupDto;
import ru.sspk.ssdmd.model.entity.Question;
import ru.sspk.ssdmd.model.entity.QuestionGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionGroupMapper {

    public static QuestionGroupDto toDto(QuestionGroup questionGroup) {

        List<QuestionDto> questionDtoList = null;
        if (questionGroup.getQuestionList() != null) {
            questionDtoList = questionGroup.getQuestionList()
                    .stream().map(QuestionMapper::toDto).toList();
        }

        QuestionGroupDto questionGroupDto = new QuestionGroupDto.Builder()
                .setId(questionGroup.getId())
                .setName(questionGroup.getName())
                .setQuestionList(questionDtoList)
                .build();

        return questionGroupDto;
    }

    public static QuestionGroup toEntity(QuestionGroupDto questionGroupDto) {

        List<Question> questionList = null;
        if (questionGroupDto.getQuestionDtoList() != null) {
            questionList = questionGroupDto.getQuestionDtoList()
                    .stream().map(QuestionMapper::toEntity).toList();
        }

        QuestionGroup questionGroup = new QuestionGroup.Builder()
                .setId(questionGroupDto.getId())
                .setName(questionGroupDto.getName())
                .setQuestionList(questionList)
                .build();

        return questionGroup;
    }

    public static List<QuestionGroupDto> toListQuestionGroup
            (List<QuestionGroup> questionGroupList) {

        return new ArrayList<>((questionGroupList).stream()
                .map(QuestionGroupMapper::toDto).collect(Collectors.toList()));
    }
}
