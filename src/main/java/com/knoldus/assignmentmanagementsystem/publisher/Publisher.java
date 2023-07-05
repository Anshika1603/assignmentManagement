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

    public void meaagesender() {
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
