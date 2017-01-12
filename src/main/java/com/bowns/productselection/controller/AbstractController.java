package com.bowns.productselection.controller;

import com.bowns.productselection.exception.FailureException;
import com.bowns.productselection.exception.InvalidCustomerIDException;
import com.bowns.productselection.model.ResponseMessage;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.Cookie;

/**
 * @author Jacob Alexander Bowns
 *
 * With extensibility in mind this super class is useful for
 * providing standardised exception handling, as well as common
 * helper methods such as retrieveCustomerID
 *
 */
public abstract class AbstractController {

    /**
     * Handles FailureExceptions
     * @param ex
     * @return
     */
    @ExceptionHandler(FailureException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseMessage handleFailureException(final Exception ex) {
        return new ResponseMessage(ex.getMessage());
    }

    /**
     * Handles InvalidCustomerIDExceptions
     * @param ex
     * @return
     */
    @ExceptionHandler(InvalidCustomerIDException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage handleInvalidCustomerIDException(final Exception ex) {
        return new ResponseMessage(ex.getMessage());
    }

    /**
     * Returns a validated customerID from the request header.
     * @param request
     * @return
     * @throws InvalidCustomerIDException
     */
    protected String retrieveCustomerID(final HttpServletRequest request) throws InvalidCustomerIDException {

        String customerID = "";
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("customerID")) {
                    customerID = cookie.getValue();
                    break;
                }
            }
        }

        if (customerID == null || customerID.isEmpty()) {
            throw new InvalidCustomerIDException("Invalid Customer ID");
        }

        return customerID;
    }

}
