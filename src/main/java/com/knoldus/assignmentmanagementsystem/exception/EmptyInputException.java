package com.knoldus.assignmentmanagementsystem.exception;

public class EmptyInputException extends RuntimeException{

    public EmptyInputException(String message){
        super(message);
    }

    public EmptyInputException(){
        super("Input is Empty");
    }
}
