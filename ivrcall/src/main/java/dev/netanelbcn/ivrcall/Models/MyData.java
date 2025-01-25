package dev.netanelbcn.ivrcall.Models;

class MyData {
    private String number;
    private String record_template;
    private IvrResponse ivr_response;

    // Empty constructor
    public MyData() {}

    // Builder for setters
    public MyData setNumber(String number) {
        this.number = number;
        return this;
    }

    public MyData setRecordTemplate(String record_template) {
        this.record_template = record_template;
        return this;
    }

    public MyData setIvrResponse(IvrResponse ivr_response) {
        this.ivr_response = ivr_response;
        return this;
    }

    // Getters
    public String getNumber() {
        return number;
    }

    public String getRecordTemplate() {
        return record_template;
    }

    public IvrResponse getIvrResponse() {
        return ivr_response;
    }
}