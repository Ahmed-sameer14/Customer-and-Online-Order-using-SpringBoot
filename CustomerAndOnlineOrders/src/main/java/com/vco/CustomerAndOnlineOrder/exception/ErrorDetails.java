package com.vco.CustomerAndOnlineOrder.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;				//printing the time in postman 
    private String message;				//perticler type of message will print in the postman
    private String details;				//it's also displaying the details of exception

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
