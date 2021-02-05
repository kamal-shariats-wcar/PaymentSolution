package com.mydigipay.paymentService.debtCardTransfer.repository.vm;

import lombok.Data;

@Data
public class RecordCountVM {
    private Long success;
    private Long failed;

    public RecordCountVM(Long success, Long failed) {
        this.success = success;
        this.failed = failed;
    }
}
