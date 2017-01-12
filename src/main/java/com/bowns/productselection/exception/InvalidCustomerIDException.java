package com.bowns.productselection.exception;

/**
 * @author Jacob Alexander Bowns
 *
 * This exception is to clearly identify when an
 * invalid customer ID is detected.
 *
 */
public class InvalidCustomerIDException extends Exception {

    /**
     * InvalidCustomerIDException Constructor
     * @param message
     */
    public InvalidCustomerIDException(final String message){
        super(message);
    }

}
