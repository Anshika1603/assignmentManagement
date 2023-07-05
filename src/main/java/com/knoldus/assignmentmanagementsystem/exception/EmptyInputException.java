package com.knoldus.assignmentmanagementsystem.exception;


/**
 The EmptyInputException class is a custom exception
 that is thrown when an empty input is encountered.
 */
public class EmptyInputException extends RuntimeException{

    /**
     Constructs a new EmptyInputException with
     the specified error message.
     @param message The error message describing
     the cause of the exception.
     */
    public EmptyInputException(String message){
        super(message);
    }

    /**
     Constructs a new EmptyInputException with the
     default error message "Input is Empty".
     */
    public EmptyInputException(){
        super("Input is Empty");
    }
}
