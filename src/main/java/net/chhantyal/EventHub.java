package net.chhantyal;

/*
Send messages to Azure Event Hubs using AMQP protocol
*/

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.microsoft.azure.eventhubs.*;
import com.microsoft.azure.servicebus.*;


public class EventHub
{
    final String namespaceName = System.getenv("EVENTHUB_NAMESPACE");
    final String eventHubName = System.getenv("EVENTHUB_NAME");
    final String sasKeyName = System.getenv("SAS_KEY_NAME");
    final String sasKey = System.getenv("SAS_KEY");
    final ConnectionStringBuilder connStr = new ConnectionStringBuilder(namespaceName, eventHubName, sasKeyName, sasKey);

    public EventHubClient getClient()
            throws ServiceBusException, IOException
    {
        return EventHubClient.createFromConnectionStringSync(connStr.toString());
    }

    public void sendEvent(String message, EventHubClient client)
            throws ExecutionException, InterruptedException, IOException
    {
        byte[] payloadBytes = message.getBytes("UTF-8");
        EventData event = new EventData(payloadBytes);
        // long heapSize = Runtime.getRuntime().totalMemory()/1000000;
        // long heapMaxSize = Runtime.getRuntime().maxMemory()/1000000;
        // System.out.println(String.format("Mem total: %s  used: %s.", heapMaxSize, heapSize));
        client.send(event);
    }

    public static void main(String[] args)
    {
        System.out.println("EventHub main method!");
    }
}