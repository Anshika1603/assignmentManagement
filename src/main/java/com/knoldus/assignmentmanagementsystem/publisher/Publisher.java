package com.knoldus.assignmentmanagementsystem.publisher;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.springframework.stereotype.Component;

/**

 The Publisher class is responsible for publishing messages to a Service Bus topic.
 */
@Component
public class Publisher {

    // The connection string to the Service Bus namespace
    static final String connectionString = "Endpoint=sb://assignmentmanagement.servicebus.windows.net/;SharedAccessKeyName=trigger;SharedAccessKey=jCp9zydh2NpdaigVjJiX+eDmIsxBWcEWa+ASbFXDJvU=";

    // The name of the topic
    static final String topicName = "assignment";


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

        ServiceBusMessage message = new ServiceBusMessage("Assignment has been created successfully");
        sender.sendMessage(message);

        System.out.printf("A message has been published to the topic.");

        // Close the sender
        sender.close();

    }
}

