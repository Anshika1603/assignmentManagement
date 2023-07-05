package com.knoldus.assignmentmanagementsystem.publisher;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
/**

 The Publisher class is responsible for publishing messages to a Service Bus topic.
 */
@Component
public class Publisher {

    // The connection string to the Service Bus namespace
    static final String connectionString = "Endpoint=sb://assignmentmanagement.servicebus.windows.net/;SharedAccessKeyName=trigger;SharedAccessKey=jCp9zydh2NpdaigVjJiX+eDmIsxBWcEWa+ASbFXDJvU=";

    // The name of the topic
    static final String topicName = "assignment";

    // The number of messages to be sent to the topic
    static final int numOfMessages = 3;

    /**
     * Sends a batch of messages to the Service Bus topic.
     */
    public void messageSender() {

// Create a ServiceBusSenderClient using the connection string and topic name
        ServiceBusSenderClient sender = new ServiceBusClientBuilder()
                .connectionString(connectionString)
                .sender()
                .topicName(topicName)
                .buildClient();

// Create an AtomicInteger to track the sequence number of the messages
        AtomicInteger sequenceNumber = new AtomicInteger(1);

// Send a batch of messages to the topic
        for (int i = 0; i < numOfMessages; i++) {
            ServiceBusMessage message = new ServiceBusMessage("Message " + sequenceNumber.getAndIncrement());
            sender.sendMessage(message);
        }

// Close the sender
        sender.close();

        System.out.printf("A batch of %d messages has been published to the topic.%n", numOfMessages);

// Wait for user input before ending the application
        System.out.println("Press any key to end the application");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}