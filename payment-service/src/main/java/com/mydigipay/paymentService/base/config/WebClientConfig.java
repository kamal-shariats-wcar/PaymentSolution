package com.mydigipay.paymentService.base.config;

import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@Configuration
public class WebClientConfig {
    @Bean("sslDisabledWebClient")
    public WebClient createWebClient() throws SSLException {
        var sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
        var client = HttpClient.create().secure(t -> t.sslContext(sslContext));
        var connector = new ReactorClientHttpConnector(client);
        return WebClient.builder().clientConnector(connector).build();
    }




}
