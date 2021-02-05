package com.mydigipay.notificationService.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface SmsEventBinder {
    String channelName = "sms-channel";

    @Input(SmsEventBinder.channelName)
    SubscribableChannel input();

    @Output(SmsEventBinder.channelName)
    MessageChannel output();
}
