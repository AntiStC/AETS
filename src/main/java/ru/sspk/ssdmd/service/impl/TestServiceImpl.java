package ru.sspk.ssdmd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sspk.ssdmd.dao.ResultDao;
import ru.sspk.ssdmd.dao.TestDao;
import ru.sspk.ssdmd.model.dto.QuestionDto;
import ru.sspk.ssdmd.model.dto.ResultDto;
import ru.sspk.ssdmd.model.dto.TestDto;
import ru.sspk.ssdmd.model.mapper.ResultMapper;
import ru.sspk.ssdmd.model.mapper.TestMapper;
import ru.sspk.ssdmd.service.TestService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TestServiceImpl implements TestService {
    private final TestDao testDao;
    private final ResultDao resultDao;

    @Value("${controller.testList.showAll}")
    private boolean showAll;

    @Autowired
    public TestServiceImpl(TestDao testDao, ResultDao resultDao) {
        this.testDao = testDao;
        this.resultDao = resultDao;
    }

    @Override
    public List<TestDto> findAll() {
        return TestMapper.toListTest(testDao.findAll());
    }

    @Override
    public TestDto findByName(String testName) {
        return TestMapper.toDto(testDao.findByName(testName));
    }

    @Override
    public TestDto create(TestDto testDto) {
        return TestMapper.toDto(testDao.save(TestMapper.toEntity(testDto)));
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

    @Override
    public TestDto findById(Long id) {
        return TestMapper.toDto(testDao.findById(id).get());
    }

    @Override
    public TestDto save(TestDto testDto) {
        return TestMapper.toDto(testDao.save(TestMapper.toEntity(testDto)));
    }

    @Override
    public void deleteById(Long id) {
        testDao.deleteById(id);
    }

    @Override
    public List<TestDto> findListOfTestForUser(Principal principal) {
        List<TestDto> allTests = TestMapper.toListTest(testDao.findAll());
        if(!(showAll)) {
            List<ResultDto> myResult = ResultMapper.toListResult(resultDao.getByPersonListUsersLogin(principal.getName()));
            List<TestDto> needDelete = new ArrayList<>();
            for (TestDto testDto : allTests) {
                for (ResultDto resultDto : myResult) {
                    if (testDto.getId().equals(resultDto.getTestList().get(0).getId()) && resultDto.getTestResult()) {
                        needDelete.add(testDto);
                    }
                }
            }
            for (TestDto testDto : needDelete) {
                allTests.remove(testDto);
            }
        }

        return allTests;
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
