package com.knoldus.assignmentmanagementsystem.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 The ApiResponse class represents a generic response object that is used to encapsulate the response data
 and metadata returned by an API.
 */
public class ApiResponse {

    /**
     * A message that describes the response.
     */
    private String message;

    /**
     * A boolean value indicating whether the operation was successful.
     */
    private boolean success;


    /**
     * An HTTP status code that describes the result of the operation.
     */
    private HttpStatus status;
}
