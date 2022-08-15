package ru.sspk.ssdmd.controller.responsebody;

public class ResponseAddNewQuestion {

    private String id;

    private String bodyQuestion;

    public String getBodyQuestion() {
        return bodyQuestion;
    }

    public void setBodyQuestion(String bodyQuestion) {
        this.bodyQuestion = bodyQuestion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
