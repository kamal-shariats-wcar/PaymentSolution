package com.mydigipay.paymentService.debtCardTransfer.service;


import com.mydigipay.paymentService.base.service.IGenericService;
import com.mydigipay.paymentService.debtCardTransfer.model.DebtCardTransferRecord;
import com.mydigipay.paymentService.debtCardTransfer.repository.vm.RecordCountVM;

import java.util.Date;

public interface IDebtCardTransferRecordService extends IGenericService<DebtCardTransferRecord,Long> {


    RecordCountVM getReport(Date from, Date to, Integer debtCardId);
}
