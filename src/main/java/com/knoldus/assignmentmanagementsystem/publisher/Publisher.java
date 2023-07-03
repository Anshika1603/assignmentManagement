package com.knoldus.assignmentmanagementsystem.publisher;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
@Component
public class Publisher {
    // The connection string to your Service Bus namespace
    static final String connectionString = "Endpoint=sb://assignmentmanagement.servicebus.windows.net/;SharedAccessKeyName=trigger;SharedAccessKey=jCp9zydh2NpdaigVjJiX+eDmIsxBWcEWa+ASbFXDJvU=";

    // The topic name
    static final String topicName = "assignment";

    // Number of messages to be sent to the topic
    static final int numOfMessages = 3;

    public void meaagesender(){
        ServiceBusSenderClient sender = new ServiceBusClientBuilder()
                .connectionString(connectionString)
                .sender()
                .topicName(topicName)
                .buildClient();

        AtomicInteger sequenceNumber = new AtomicInteger(1);

        for (int i = 0; i < numOfMessages; i++) {
            ServiceBusMessage message = new ServiceBusMessage("Message " + sequenceNumber.getAndIncrement());
            sender.sendMessage(message);
        }

        System.out.printf("A batch of %d messages has been published to the topic.%n", numOfMessages);

        // Close the sender
        sender.close();

        System.out.println("Press any key to end the application");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}
