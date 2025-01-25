package dev.netanelbcn.ivrcall.Models;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private CallDetails data;

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public ApiResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public CallDetails getData() {
        return data;
    }

    public ApiResponse setData(CallDetails data) {
        this.data = data;
        return this;
    }
}

