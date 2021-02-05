package com.mydigipay.paymentService.feignClinet;

import com.mydigipay.paymentService.feignClinet.dto.SmsRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class NotificationServiceFallBack implements NotificationServiceFeignClient {
    @Override
    public void sendSmd(SmsRequest request) {
        log.error("request down {}",request);
    }
}