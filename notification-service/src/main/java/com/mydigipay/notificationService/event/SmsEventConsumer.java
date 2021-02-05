package com.mydigipay.notificationService.event;


import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@EnableBinding(SmsEventBinder.class)
@Component
@Log4j2
public class SmsEventConsumer {

    // private final SmsService smsService;

    @StreamListener(target = SmsEventBinder.channelName)
    public void consumeSendingMessage(SmsRequest request) {
       log.info("request{}",request);
       // smsService.send(request);
    }
}
