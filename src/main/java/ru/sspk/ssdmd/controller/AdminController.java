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

import java.util.*;

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

    @GetMapping(value = "/admin")
    public String getAdmin(Model model) {
        List<TestDto> testDtoList = testService.findAll();
        model.addAttribute("testList", testDtoList);
        return "admin";
    }

    @DeleteMapping(value = "/admin/test/{id}")
    @ResponseBody
    public String testDelete(@PathVariable("id") int id, @RequestParam(required = true) String action) {
        String msg;
        switch (action) {
            case "delete":
                // TODO
                testService.deleteById(Integer.toUnsignedLong(id));
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
        resp.setName(testDto.getName());
        resp.setId(testDto.getId().toString());
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
        long id = Long.parseLong(requestAddNewQuestion.getTestId());
        TestDto testDto = testService.findById(id);
        List<QuestionDto> questionDtoList = new ArrayList<>(testDto.getQuestionList());
        if (null == questionDtoList) {
            questionDtoList = new ArrayList<>();
        }
        questionDtoList.add(questionDto);
        testDto.setQuestionList(questionDtoList);
        testService.save(testDto);
        // отправляем обратно id вопроса
        resp.setId(questionDto.getId().toString());
        resp.setBodyQuestion(questionDto.getBodyQuestion());
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
        long id = Long.parseLong(requestAddNewAnswer.getQuestionId());
        QuestionDto questionDto = questionService.findById(id);
        List<AnswerDto> answerDtoList = new ArrayList<>(questionDto.getAnswerDtos());
        if (null == answerDtoList) {
            answerDtoList = new ArrayList<>();
        }
        answerDtoList.add(answerDto);
        questionDto.setAnswerDtos(answerDtoList);
        questionService.save(questionDto);
        // отправляем обратно id вопроса
        resp.setId(answerDto.getId().toString());
        resp.setTextAnswer(answerDto.getCurrent() ? answerDto.getTextAnswer() + "(правильный ответ)" : answerDto.getTextAnswer());
        resp.setCurrent(answerDto.getCurrent());
        return resp;
    }

    @GetMapping("/admin/test/{id}")
    public String getTest(@PathVariable("id") int id, Model model) {
        // ищем сам тест
        long idTest = Integer.toUnsignedLong(id);
        TestDto testDto = null;
        try {
            testDto = testService.findById(idTest);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        if (null != testDto) {
            // получаем списко вопросов
            List<QuestionDto> questionDtoList = testDto.getQuestionList();
            // получаем спимок ответов к вопросам
            Map<Long, List<AnswerDto>> answerMap = new HashMap<>();
            for (QuestionDto question :
                    questionDtoList) {
                answerMap.put(question.getId(), question.getAnswerDtos());
            }
            model.addAttribute("answerMap", answerMap);
        }
        model.addAttribute("test", testDto);
        return "admin/test";
    }
}
