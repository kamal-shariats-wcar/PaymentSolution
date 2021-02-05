package com.mydigipay.paymentService.debtCardTransfer.service.impl;

import com.mydigipay.paymentService.base.service.GenericServiceImpl;
import com.mydigipay.paymentService.debtCardTransfer.model.DebtCardTransferRecord;
import com.mydigipay.paymentService.debtCardTransfer.repository.IDebtCardTransferRecordRepository;
import com.mydigipay.paymentService.debtCardTransfer.repository.vm.RecordCountVM;
import com.mydigipay.paymentService.debtCardTransfer.service.IDebtCardTransferRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Log4j2
@RequiredArgsConstructor
public class DebtCardTransferRecordServiceImpl extends GenericServiceImpl<DebtCardTransferRecord, Long> implements IDebtCardTransferRecordService {
    private final IDebtCardTransferRecordRepository repository;

    @Override
    public JpaRepository<DebtCardTransferRecord, Long> getRepositoryBean() {
        return repository;
    }

    @Override
    public RecordCountVM getReport(Date from, Date to, Integer debtCardId) {

        return repository.getReport(from, to,debtCardId);
    }
}
