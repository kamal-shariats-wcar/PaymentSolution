package com.mydigipay.paymentService.debtCardTransfer.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class GetCardHolderDTO {

    @NotNull
    private Integer cardId;
    @NotNull
    private String destination_pan;
}
