package com.mydigipay.paymentService.debtCardTransfer.service.impl;

import com.mydigipay.paymentService.debtCardTransfer.model.DebtCardTransferRecord;
import com.mydigipay.paymentService.debtCardTransfer.repository.vm.RecordCountVM;
import com.mydigipay.paymentService.debtCardTransfer.service.IBankService;
import com.mydigipay.paymentService.debtCardTransfer.service.IDebtCardTransferRecordService;
import com.mydigipay.paymentService.debtCardTransfer.service.TransferService;
import com.mydigipay.paymentService.debtCardTransfer.util.BankServiceFactory;
import com.mydigipay.paymentService.debtCardTransfer.web.dto.CardTransferDTO;
import com.mydigipay.paymentService.feignClinet.NotificationServiceFeignClient;
import com.mydigipay.paymentService.feignClinet.dto.SmsRequest;
import com.mydigipay.paymentService.user.model.DebtCard;
import com.mydigipay.paymentService.user.service.IDebtCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class TransferServiceImpl implements TransferService {

    private final BankServiceFactory transferServiceFactory;
    private final IDebtCardService debtCardService;
    private final IDebtCardTransferRecordService transferRecordService;
    private final NotificationServiceFeignClient notificationServiceFeignClient;

    @Override
    public Mono<ResponseEntity<Boolean>> transfer(CardTransferDTO dto) {
        Optional<DebtCard> optionalDebtCard = debtCardService.find(dto.getCardId());
        String firstFourNum = dto.getDestination().substring(0, 4);
        IBankService bankService = transferServiceFactory.getProvider(firstFourNum);
        // not found on .get method handles in implementation of IDebtCardService
        return bankService.transfer(dto, optionalDebtCard.get())
                .flatMap(cardTransferResponse -> {

                    transferRecordService.save(new DebtCardTransferRecord(optionalDebtCard.get(),
                            dto.getDestination(), dto.getAmount(), cardTransferResponse.isSuccess()));

                    if (cardTransferResponse.isSuccess()) {
                        notificationServiceFeignClient.sendSmd(SmsRequest.builder()
                                .msg("transfer-successful")
                                .target(optionalDebtCard.get().getUser().getNumber())
                                .build());

                        return Mono.just(new ResponseEntity<>(true, HttpStatus.OK));
                    } else return Mono.just(new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR));

                });
    }

    @Override
    public RecordCountVM getReport(Date from, Date to, Integer debtCardId) {
        return transferRecordService.getReport(from, to,debtCardId);
    }
}
