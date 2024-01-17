package com.jawa.demo.controller;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.models.QueueMessageItem;
import com.azure.storage.queue.models.SendMessageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("queue")
@ConditionalOnProperty(prefix = "azure", name = "queue")
public class QueueController {

    private final static Logger logger = LoggerFactory.getLogger(QueueController.class);

    private QueueClient queueClient;

    @Autowired
    public QueueController(QueueClient queueClient){
        this.queueClient=queueClient;
    }

    @GetMapping("/get/{count}")
    public List<String> getQueueitems(@PathVariable Integer count) {
        queueClient.create();
        PagedIterable<QueueMessageItem> queueMessageItems = queueClient.receiveMessages(count);
        return queueMessageItems.stream().map(item -> {
            String message = new String(item.getBody().toBytes());
            logger.info("message is : {} ", message);
            return message;
        }).collect(Collectors.toList());

    }

    @PostMapping("/postMessage")
    public String postMessageToQueue(@RequestBody  String message) {
        logger.info("inside post message");
        queueClient.create();
        SendMessageResult sendMessageResult = queueClient.sendMessage(message);
        return "message sent and the id is : " + sendMessageResult.getMessageId();
    }
}
