package ru.sspk.ssdmd.controller.responsebody;

public class ResponseAddNewAnswer {

    private String id;
    private String textAnswer;

    private Boolean current;

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }
}
