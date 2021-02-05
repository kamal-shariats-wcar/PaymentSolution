package com.mydigipay.paymentService.debtCardTransfer.provider;

import com.mydigipay.paymentService.debtCardTransfer.dto.CardTransferResponse;
import com.mydigipay.paymentService.debtCardTransfer.provider.dto.FirstProviderCardTransferRequest;
import com.mydigipay.paymentService.debtCardTransfer.service.IBankService;
import com.mydigipay.paymentService.debtCardTransfer.web.dto.CardTransferDTO;
import com.mydigipay.paymentService.user.model.DebtCard;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FirstBankServiceProvider implements IBankService {

    @Value("${bank-service-provider.first.scheme}")
    private String scheme;
    @Value("${bank-service-provider.first.host}")
    private String host;
    @Value("${bank-service-provider.first.path}")
    private String path;

    @Qualifier("sslDisabledWebClient")
    private final WebClient webClient;


    @Override
    public Mono<CardTransferResponse> transfer(CardTransferDTO dto, DebtCard debtCard) {


        FirstProviderCardTransferRequest request = FirstProviderCardTransferRequest.builder()
                .amount(dto.getAmount())
                .cvv2(dto.getCvv2())
                .expDate(debtCard.getExpDate())
                .pin(dto.getPin())
                .source(debtCard.getCardNumber())
                .dest(dto.getDestination())
                .build();

        return webClient.post()

                .uri(uriBuilder -> uriBuilder
                        .scheme(scheme)
                        .port(9091)
                        .host(host)
                        .path(path)
                        .build()
                ).body(BodyInserters.fromValue(request))
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(CardTransferResponse.class))
                .flatMap(Mono::just);

    }
}
