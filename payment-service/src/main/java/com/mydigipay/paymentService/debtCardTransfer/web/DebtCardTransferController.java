package com.mydigipay.paymentService.debtCardTransfer.web;


import com.mydigipay.paymentService.debtCardTransfer.repository.vm.RecordCountVM;
import com.mydigipay.paymentService.debtCardTransfer.service.TransferService;
import com.mydigipay.paymentService.debtCardTransfer.web.dto.CardTransferDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/v1/debt-card-transfer")
@RequiredArgsConstructor
public class DebtCardTransferController {

    private final TransferService service;


    @PostMapping
    public Mono<ResponseEntity<Boolean>> transfer(@RequestBody @Valid CardTransferDTO dto) {

        return service.transfer(dto);
    }

    @GetMapping("report")
    public ResponseEntity<RecordCountVM> getReport(@RequestParam("from") String from,
                                                   @RequestParam("to") String to,
                                                   @RequestParam("debtCardId") Integer debtCardId) {
        Date dateFrom = null;
        Date dateTo = null;
        try {
            dateFrom=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(from);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            dateTo=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(to);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(service.getReport(dateFrom, dateTo,debtCardId), HttpStatus.OK);
    }
}
