package dev.netanelbcn.ivrcall.Models;

public class IvrResponse {
    private int http_code;
    private String response;

    // Empty constructor
    public IvrResponse() {}

    // Builder for setters
    public IvrResponse setHttpCode(int http_code) {
        this.http_code = http_code;
        return this;
    }

    public IvrResponse setResponse(String response) {
        this.response = response;
        return this;
    }

    // Getters
    public int getHttpCode() {
        return http_code;
    }

    public String getResponse() {
        return response;
    }
}