package ru.sspk.ssdmd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sspk.ssdmd.dao.TestDao;
import ru.sspk.ssdmd.model.dto.QuestionDto;
import ru.sspk.ssdmd.model.dto.TestDto;
import ru.sspk.ssdmd.model.mapper.TestMapper;
import ru.sspk.ssdmd.service.TestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TestServiceImpl implements TestService {
    private final TestDao dao;

    @Autowired
    public TestServiceImpl(TestDao dao) {
        this.dao = dao;
    }

    @Override
    public List<TestDto> findAll() {
        return TestMapper.toListTest(dao.findAll());
    }

    @Override
    public TestDto findByName(String testName) {
        return TestMapper.toDto(dao.findByName(testName));
    }

    @Override
    public TestDto create(TestDto testDto) {
        return TestMapper.toDto(dao.save(TestMapper.toEntity(testDto)));
    }

    @Override
    public TestDto generate(String testName) {
        TestDto neededTest = findByName(testName);
        List<QuestionDto> listOfSelectedQuestions = new ArrayList<>();

        while (listOfSelectedQuestions.size() != neededTest.getCountQuest()) {
            int randomNumber = getRandomNumber(0, neededTest.getQuestionList().size());

            QuestionDto potentialQuestion = neededTest.getQuestionList().get(randomNumber);

            if(!(listOfSelectedQuestions.contains(potentialQuestion))) {
                listOfSelectedQuestions.add(potentialQuestion);
            }
        }
        neededTest.setQuestionList(listOfSelectedQuestions);

        return neededTest;
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
