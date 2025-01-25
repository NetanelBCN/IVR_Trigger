package dev.netanelbcn.ivrcall.Models;

public class CallPreferences {
    private String record_template;
    private String phone_number;

    // Empty constructor
    public CallPreferences() {}

    // Constructor with parameters
    public CallPreferences(String record_template, String phone_number) {
        this.record_template = record_template;
        this.phone_number = phone_number;
    }

    // Builder for setters
    public CallPreferences setRecordTemplate(String record_template) {
        this.record_template = record_template;
        return this;
    }

    public CallPreferences setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
        return this;
    }

    // Getters
    public String getRecordTemplate() {
        return record_template;
    }

    public String getPhoneNumber() {
        return phone_number;
    }
}
