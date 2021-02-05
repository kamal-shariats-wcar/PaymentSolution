package com.mydigipay.paymentService.debtCardTransfer.web.dto;

import com.mydigipay.paymentService.annotation.Length;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class CardTransferDTO {
    @NotNull
    private Integer cardId;
    @Length(min = 4)
    private String pin;
    @Length(min = 3,max = 4)
    private String cvv2;
    @NotNull
    @Max(10000000)
    private Long amount;
    @Length(min = 16,max = 16)
    private String destination;

}
