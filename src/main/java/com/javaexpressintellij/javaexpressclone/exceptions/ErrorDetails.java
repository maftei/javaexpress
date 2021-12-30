package com.javaexpressintellij.javaexpressclone.exceptions;

import java.time.LocalDate;
import java.util.List;

public class ErrorDetails {
    private LocalDate timestamp;
    private String message;
    private List<String> details;

    private String requestUri;


    public ErrorDetails(){

    }

    public ErrorDetails(LocalDate timestamp, String message, List<String> details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ErrorDetails(LocalDate timestamp, String message, List<String> details, String requestUri) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.requestUri = requestUri;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }
}
