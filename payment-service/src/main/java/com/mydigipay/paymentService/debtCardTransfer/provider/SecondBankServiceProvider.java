package com.mydigipay.paymentService.debtCardTransfer.provider;

import com.mydigipay.paymentService.debtCardTransfer.dto.CardTransferResponse;
import com.mydigipay.paymentService.debtCardTransfer.service.IBankService;
import com.mydigipay.paymentService.debtCardTransfer.web.dto.CardTransferDTO;
import com.mydigipay.paymentService.user.model.DebtCard;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import com.mydigipay.paymentService.debtCardTransfer.provider.dto.*;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SecondBankServiceProvider implements IBankService {

    @Value("${bank-service-provider.second.scheme}")
    private String scheme;
    @Value("${bank-service-provider.second.host}")
    private String host;
    @Value("${bank-service-provider.second.path}")
    private String path;


    @Qualifier("sslDisabledWebClient")
    private final WebClient webClient;


    @Override
    public Mono<CardTransferResponse> transfer(CardTransferDTO dto, DebtCard debtCard) {
        SecondProviderCardTransferRequest request =new SecondProviderCardTransferRequest(debtCard.getCardNumber(),
                dto.getDestination(),dto.getCvv2(),dto.getAmount(),debtCard.getExpDate(),dto.getPin());


        return webClient.post()

                .uri(uriBuilder -> uriBuilder
                        .scheme(scheme)
                        .host(host)
                        .path(path)
                        .port(9091)
                        .build()
                ).body(BodyInserters.fromValue(request))
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(CardTransferResponse.class))
                .flatMap(Mono::just);

    }



}
