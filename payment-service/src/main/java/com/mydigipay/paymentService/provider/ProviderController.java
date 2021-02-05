package com.mydigipay.paymentService.provider;

import com.mydigipay.paymentService.debtCardTransfer.provider.dto.*;
import com.mydigipay.paymentService.debtCardTransfer.dto.CardTransferResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ProviderController {

    @PostMapping("first-payment-provider/payments/transfer")
    public Mono<CardTransferResponse> transfer(@RequestBody FirstProviderCardTransferRequest request) {
        return Mono.just(new CardTransferResponse());
    }

    @PostMapping("second-payment-provider/cards/pay")
    public Mono<CardTransferResponse> transfer(@RequestBody SecondProviderCardTransferRequest request) {
        return Mono.just(new CardTransferResponse());
    }
}
