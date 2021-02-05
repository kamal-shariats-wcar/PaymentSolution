package com.mydigipay.paymentService.debtCardTransfer.util;


import com.mydigipay.paymentService.debtCardTransfer.provider.FirstBankServiceProvider;
import com.mydigipay.paymentService.debtCardTransfer.provider.SecondBankServiceProvider;
import com.mydigipay.paymentService.debtCardTransfer.service.IBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankServiceFactory {

    private final FirstBankServiceProvider provider1;
    private final SecondBankServiceProvider provider2;

    public IBankService getProvider(String firstFourNum) {
        switch (firstFourNum) {
            case "6037":
                return provider1;
            default:
                return provider2;
        }
    }
}
