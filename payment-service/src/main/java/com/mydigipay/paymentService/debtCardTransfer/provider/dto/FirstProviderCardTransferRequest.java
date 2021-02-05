package com.mydigipay.paymentService.debtCardTransfer.provider.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class FirstProviderCardTransferRequest {

    private String source;
    private String dest;
    private String cvv2;
    private Long amount;
    private String expDate;
    private String pin;


}