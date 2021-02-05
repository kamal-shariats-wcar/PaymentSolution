package com.mydigipay.notificationService.event;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SmsEventProducer {
    @Autowired
    @Qualifier("sms-channel")
    private  MessageChannel channel;

    public void sendMessage(SmsRequest request) {

        Gson gson = new Gson();
        String json = gson.toJson(request);
        Message<String> payload = MessageBuilder.withPayload(json).build();
        this.channel.send(payload);
    }
}
