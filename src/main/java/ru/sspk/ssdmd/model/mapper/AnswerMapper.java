package ru.sspk.ssdmd.model.mapper;

import ru.sspk.ssdmd.model.dto.AnswerDto;
import ru.sspk.ssdmd.model.entity.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerMapper {

    public static AnswerDto toDto(Answer answer) {

        AnswerDto answerDto = new AnswerDto.Builder()
                .setId(answer.getId())
                .setTextAnswer(answer.getTextAnswer())
                .setCurrent(answer.getCurrent())
                .build();

        return answerDto;
    }

    public static Answer toEntity(AnswerDto answerDto) {

        Answer answer = new Answer.Builder()
                .setId(answerDto.getId())
                .setTextAnswer(answerDto.getTextAnswer())
                .setCurrent(answerDto.getCurrent())
                .build();

        return answer;
    }

    public static List<AnswerDto> toListAnswer(List<Answer> answers) {

        return new ArrayList<>((answers).stream().map(AnswerMapper::toDto)
                .collect(Collectors.toList()));
    }
}
