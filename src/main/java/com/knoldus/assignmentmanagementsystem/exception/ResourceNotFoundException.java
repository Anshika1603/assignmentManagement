package com.knoldus.assignmentmanagementsystem.exception;

/**
 The ResourceNotFoundException class is a custom exception
 that is thrown when a requested resource is not found.
 */
public class ResourceNotFoundException extends RuntimeException{

    /**
     Constructs a new ResourceNotFoundException
     with the default error message "Resource not Found".
     */
    public ResourceNotFoundException(){
         super("Resource not Found");
     }

    /**
     * Constructs a ResourceNotFoundException with
     * the specified detail message.
     * @param message the detail message that provides
     * information about the resource that was not found.
     */
     public ResourceNotFoundException(String message){
         super(message);
     }
}
