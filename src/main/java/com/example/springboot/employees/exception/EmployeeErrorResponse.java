package com.example.springboot.employees.exception;

public class EmployeeErrorResponse {
    private int status;

    private String message;

    private long timeStamp;

    public EmployeeErrorResponse() {/* No Args */}

    public EmployeeErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long gettimeStamp() {
        return timeStamp;
    }
}
