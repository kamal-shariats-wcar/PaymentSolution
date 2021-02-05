package com.mydigipay.notificationService.event;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({SmsEventBinder.class})
public class EventConfiguration {
}
