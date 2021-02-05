package com.mydigipay.paymentService.debtCardTransfer.provider.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SecondProviderCardTransferRequest {

    private String source;
    private String target;
    private String cvv2;
    private Long amount;
    private String expire;
    private String pin2;


    public SecondProviderCardTransferRequest(String source, String target, String cvv2, Long amount, String expire, String pin2) {
        this.source = source;
        this.target = target;
        this.cvv2 = cvv2;
        this.amount = amount;
        this.expire = expire.substring(0, 2) + "/" + expire.substring(2);
        this.pin2 = pin2;
    }
}
