package com.mydigipay.paymentService.debtCardTransfer.service;

import com.mydigipay.paymentService.debtCardTransfer.repository.vm.RecordCountVM;
import com.mydigipay.paymentService.debtCardTransfer.web.dto.CardTransferDTO;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface TransferService {
    Mono<ResponseEntity<Boolean>> transfer(CardTransferDTO dto);

    RecordCountVM getReport(Date from, Date to, Integer debtCardId);

}
