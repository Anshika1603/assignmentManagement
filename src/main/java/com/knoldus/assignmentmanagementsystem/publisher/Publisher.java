package com.knoldus.assignmentmanagementsystem.publisher;

import com.azure.core.amqp.AmqpRetryMode;
import com.azure.core.amqp.AmqpRetryOptions;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusException;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.springframework.stereotype.Component;
import java.time.Duration;

/**
 The Publisher class is responsible for publishing
 messages to a Service Bus topic.
 */
@Component
public class Publisher {


    /**
     The connection string used to connect to the assignment
     management service bus.
     It includes the necessary authentication information.
     */
    static final String CONNECGION_STRING = "Endpoint"
            + "=sb://assignmentmanagement."
            + "servicebus.windows.net/;SharedAccessKeyName=trigger;"
            + "SharedAccessKey=jCp9zydh2NpdaigVjJiX+eDmIsxBWcEWa+ASbFXDJvU=";



    /**
     The name of the topic used in the assignment system.
     */
    static final String TOPIC_NAME = "assignment";



    /**
     The duration of an activity in hours.
     */
    // Maximum allowed value
    static final Integer MAX_DURATION = 3;


    /**
     The maximum timeout duration for a retry attempt.
     */
    static final Integer MAX_TRY_TIMEOUT = 5;



    /**

     The number of retries for a particular operation.
     */
    static final Integer MAX_NUMBER_OF_TRIES = 3;


    /**
     * Sends a batch of messages to the Service Bus topic.
     */
    public void messageSender() {
        ServiceBusSenderClient sender = new ServiceBusClientBuilder()
                .connectionString(CONNECGION_STRING)
                .retryOptions(new AmqpRetryOptions()
                        .setTryTimeout(Duration.ofSeconds(MAX_TRY_TIMEOUT))
                        .setDelay(Duration.ofSeconds(MAX_DURATION))
                        .setMaxRetries(MAX_NUMBER_OF_TRIES)
                        .setMaxDelay(Duration.ofSeconds(MAX_DURATION))
                        .setMode(AmqpRetryMode.EXPONENTIAL))
                .sender()
                .topicName(TOPIC_NAME)
                .buildClient();

        ServiceBusMessage message = new ServiceBusMessage(
                "Assignment has been created successfully");

        try {
            // Send the message with retry policy
            sender.sendMessage(message);
            System.out.println("A message has been published to the topic.");
        } catch (ServiceBusException exception) {
            System.out.println("An error occurred while sending the message: "
                    + exception.getMessage());
        } finally {
            sender.close();
        }
    }
}

