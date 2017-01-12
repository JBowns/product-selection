package com.bowns.productselection.model;

/**
 * @author Jacob Alexander Bowns
 *
 * In an effort to ensure the API only returns JSON,
 * textual responses will be substitued for this class.
 *
 */
public class ResponseMessage {

    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
