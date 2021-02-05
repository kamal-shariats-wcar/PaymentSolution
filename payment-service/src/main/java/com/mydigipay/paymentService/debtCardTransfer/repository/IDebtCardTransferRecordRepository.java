package com.mydigipay.paymentService.debtCardTransfer.repository;


import com.mydigipay.paymentService.debtCardTransfer.model.DebtCardTransferRecord;
import com.mydigipay.paymentService.debtCardTransfer.repository.vm.RecordCountVM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IDebtCardTransferRecordRepository extends JpaRepository<DebtCardTransferRecord, Long> {

    @Query("select new com.mydigipay.paymentService.debtCardTransfer.repository.vm.RecordCountVM( sum (case when d.successful=true THEN 1 ELSE 0 END ), " +
            "sum (case when d.successful=false THEN 1 ELSE 0 END ))" +
            " from  DebtCardTransferRecord d" +
            " where d.createdDate between ?1 and ?2 and d.debtCard.id=?3")
    RecordCountVM getReport(Date from, Date to, Integer debtCardId);
}
