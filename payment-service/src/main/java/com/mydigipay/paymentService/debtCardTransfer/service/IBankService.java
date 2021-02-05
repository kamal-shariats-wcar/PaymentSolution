package com.mydigipay.paymentService.debtCardTransfer.service;


import com.mydigipay.paymentService.debtCardTransfer.dto.CardTransferResponse;
import com.mydigipay.paymentService.debtCardTransfer.web.dto.CardTransferDTO;
import com.mydigipay.paymentService.user.model.DebtCard;
import reactor.core.publisher.Mono;


public interface IBankService {
    Mono<CardTransferResponse> transfer(CardTransferDTO dto, DebtCard debtCard);
}
