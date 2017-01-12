package com.bowns.productselection.exception;

/**
 * @author Jacob Alexander Bowns
 *
 * As per the specification this Exception will be used
 * to handle errors when retrieving customer information.
 *
 */
public class FailureException extends Exception {

    /**
     * FailureException Constructor
     * @param message
     */
    public FailureException(final String message) {
        super(message);
    }

}
