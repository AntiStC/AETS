package ru.sspk.ssdmd.controller.requestbody;

public class RequestAddNewQuestion {
    String name;
    String testId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

}
