package ru.sspk.ssdmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sspk.ssdmd.controller.requestbody.RequestAddNewAnswer;
import ru.sspk.ssdmd.controller.requestbody.RequestAddNewQuestion;
import ru.sspk.ssdmd.controller.requestbody.RequestAddNewTest;
import ru.sspk.ssdmd.controller.responsebody.ResponseAddNewAnswer;
import ru.sspk.ssdmd.controller.responsebody.ResponseAddNewQuestion;
import ru.sspk.ssdmd.controller.responsebody.ResponseAddNewTest;
import ru.sspk.ssdmd.model.dto.AnswerDto;
import ru.sspk.ssdmd.model.dto.QuestionDto;
import ru.sspk.ssdmd.model.dto.TestDto;
import ru.sspk.ssdmd.service.AnswerService;
import ru.sspk.ssdmd.service.QuestionService;
import ru.sspk.ssdmd.service.TestService;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private TestService testService;

    private AnswerService answerService;

    private QuestionService questionService;

    @Autowired
    public AdminController(TestService testService, AnswerService answerService, QuestionService questionService) {
        this.testService = testService;
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @Autowired


    @GetMapping(value = "/admin")
    public String getAdmin(Model model) {
        List<TestDto> testDtoList = testService.findAll();
        model.addAttribute("testList", testDtoList);
        return "admin";
    }

    @GetMapping(value = "/admin/test/{id}")
    @ResponseBody
    public String testDelete(@PathVariable("id") int id, @RequestParam(required = true) String action) {
        String msg;
        switch (action) {
            case "delete":
                // TODO
//                testService.delete(id);
                msg = "Test id: " + id + " is deleted";
                break;
            default: msg = "Error! Action is wrong!";
        }
        return msg;
    }

    @PostMapping(value = "/admin/test/add")
    @ResponseBody
    public ResponseAddNewTest addNewTest(@RequestBody RequestAddNewTest requestAddNewTest) {
        TestDto testDto = new TestDto.Builder().setName(requestAddNewTest.getName()).build();
        testDto = testService.save(testDto);
        ResponseAddNewTest resp = new ResponseAddNewTest();
        resp.setName(requestAddNewTest.getName());
        resp.setId(requestAddNewTest.getId());
        return resp;
    }

    @GetMapping(value = "/admin/test/add")
    public String addNewTest() {
        return "admin/testAdd";
    }


    @PostMapping(value = "/admin/test/question/add")
    @ResponseBody
    public ResponseAddNewQuestion addNewQuestion(@RequestBody RequestAddNewQuestion requestAddNewQuestion) {
        ResponseAddNewQuestion resp = new ResponseAddNewQuestion();
        // Записываем в БД данные о новом вопросе
        QuestionDto questionDto = new QuestionDto.Builder().setBodyQuestion(requestAddNewQuestion.getName()).build();
        questionDto = questionService.save(questionDto);
        // находим тест по переданному id и добавляем в него вопрос
        TestDto testDto = testService.findById(requestAddNewQuestion.getTestId());
        List<QuestionDto> questionDtoList = testDto.getQuestionList();
        if (null == questionDtoList) {
            questionDtoList = new ArrayList<>();
        }
        questionDtoList.add(questionDto);
        testDto.setQuestionList(questionDtoList);
        testService.save(testDto);
        // отправляем обратно id вопроса
        resp.setId(questionDto.getId().toString());
        return resp;
    }

    @PostMapping(value = "/admin/test/question/answer/add")
    @ResponseBody
    public ResponseAddNewAnswer addNewAnswer(@RequestBody RequestAddNewAnswer requestAddNewAnswer) {
        ResponseAddNewAnswer resp = new ResponseAddNewAnswer();
        // Записываем в БД данные о новом ответе
        AnswerDto answerDto = new AnswerDto.Builder().setTextAnswer(requestAddNewAnswer.getTextAnswer()).setCurrent(requestAddNewAnswer.isCurrent()).build();
        answerDto = answerService.save(answerDto);
        // находим вопрос по переданному id и добавляем в него ответ
        int id = Integer.getInteger(requestAddNewAnswer.getQuestionId());
        QuestionDto questionDto = questionService.findById(id);
        List<AnswerDto> answerDtoList = questionDto.getAnswerDtos();
        if (null == answerDtoList) {
            answerDtoList = new ArrayList<>();
        }
        answerDtoList.add(answerDto);
        questionDto.setAnswerDtos(answerDtoList);
        questionService.save(questionDto);
        // отправляем обратно id вопроса
        resp.setId(answerDto.getId().toString());
        resp.setTextAnswer(answerDto.getTextAnswer());
        return resp;
    }
}
