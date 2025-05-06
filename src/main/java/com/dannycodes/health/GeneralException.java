package com.dannycodes.health;



public class GeneralException extends RuntimeException {

    private String message;

    public GeneralException(String errorMessage, Throwable err) {
        super(errorMessage,err);
    }

    public GeneralException(String message) {
        super(message);
    }

    public GeneralException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public GeneralException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public GeneralException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public GeneralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }



}
