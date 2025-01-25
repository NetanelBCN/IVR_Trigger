package dev.netanelbcn.ivrcall.Models;


public class CallDetails {
    private String number;
    private String record_template;
    private IvrResponse ivr_response;

    @Override
    public String toString() {
        return "CallDetails{" +
                "number='" + number + '\'' +
                ", record_template='" + record_template + '\'' +
                ", ivr_response=" + ivr_response +
                '}';
    }

    // Empty constructor
    public CallDetails() {}

    // Builder for setters
    public CallDetails setNumber(String number) {
        this.number = number;
        return this;
    }

    public CallDetails setRecordTemplate(String record_template) {
        this.record_template = record_template;
        return this;
    }

    public CallDetails setIvrResponse(IvrResponse ivr_response) {
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
