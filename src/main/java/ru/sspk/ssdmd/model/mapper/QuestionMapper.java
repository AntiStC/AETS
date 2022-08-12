package ru.sspk.ssdmd.model.mapper;

import ru.sspk.ssdmd.model.dto.AnswerDto;
import ru.sspk.ssdmd.model.dto.QuestionDto;
import ru.sspk.ssdmd.model.entity.Answer;
import ru.sspk.ssdmd.model.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionMapper {

    public static QuestionDto toDto(Question question) {

        List<AnswerDto> answerDtoList = null;
        if (question.getAnswers() != null) {
            answerDtoList = question.getAnswers().stream()
                    .map(AnswerMapper::toDto).toList();
        }

        QuestionDto questionDto = new QuestionDto.Builder()
                .setId(question.getId())
                .setBodyQuestion(question.getBodyQuestion())
                .setCreateAt(question.getCreateAt())
                .setModifyAt(question.getModifyAt())
                .setAnswerDtos(answerDtoList)
                .build();

        return questionDto;
    }

    public static Question toEntity(QuestionDto questionDto) {

        List<Answer> answerList = null;
        if (questionDto.getAnswerDtos() != null) {
            answerList = questionDto.getAnswerDtos().stream()
                    .map(AnswerMapper::toEntity).toList();
        }

        Question question = new Question.Builder()
                .setId(questionDto.getId())
                .setBodyQuestion(questionDto.getBodyQuestion())
                .setCreateAt(questionDto.getCreateAt())
                .setModifyAt(questionDto.getModifyAt())
                .setAnswers(answerList)
                .build();

        return question;
    }

    public static List<QuestionDto> toListQuestion(List<Question> questionList) {

        return new ArrayList<>((questionList).stream().map(QuestionMapper::toDto)
                .collect(Collectors.toList()));
    }
}
