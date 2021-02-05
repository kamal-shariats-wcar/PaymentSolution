package com.mydigipay.paymentService.debtCardTransfer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class CardTransferResponse {

    @Builder.Default
    private boolean success= false;

    // chance of failure transaction is 1/3
    public CardTransferResponse() {
        this.success=((int) (Math.random() * 3)) != 0;
    }
}
