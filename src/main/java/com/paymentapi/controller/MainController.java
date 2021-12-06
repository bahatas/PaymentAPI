package com.paymentapi.controller;


import com.paymentapi.dto.*;
import com.paymentapi.service.PaymentService;
import com.paymentapi.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.websocket.server.PathParam;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/api")
public class MainController {

    /**
     * "username":"admin",
     * "password":"admin"
     */

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    final String PAY_URL ="https://pay-api.truelayer-sandbox.com/single-immediate-payments";

    @GetMapping
    public String initialresponse(){

        return "WELCOME TO THE CYDEO-PAY API";
    }

    @GetMapping("/token")
    public ResultEnvelope<TokenResponse> getToken() {

        Token token = tokenService.generateToken();

        log.info("Token retrieved");

        assert token != null;
        return ResultEnvelope.ok(new TokenResponse(token.getAccess_token()));
    }

    @GetMapping("/makepayment")
    public ResultEnvelope<TokenResponse> getPayment() {

        HttpEntity<Object> objectHttpEntity = paymentService.makePayment();
        PaymentResult paymentResult = restTemplate.postForObject(PAY_URL, objectHttpEntity, PaymentResult.class);
        log.info("payment completed");

        return ResultEnvelope.ok(paymentResult);
    }


    @GetMapping("/post-amount/webclient/{amount}")
    public Mono<PaymentResult> makeTransaction(@PathVariable("amount") Integer amount){

        var objectHttpEntity = paymentService.postForPayment(amount);

        Mono<PaymentResult> paymentResultMono = webClientBuilder
                .baseUrl(PAY_URL)
                .build().post()
                .header("Authorization", "Bearer " ,tokenService.generateToken().getAccess_token())
                .bodyValue(objectHttpEntity)
//                .body(Mono.just(paymentDetails),PaymentDetails.class)
                .retrieve()
                .bodyToMono(PaymentResult.class);
        log.info("paymentResultMono.block().getStatus() "+ paymentResultMono.block().getStatus());
        return paymentResultMono;
    }

    @GetMapping("/post-amount/{amount}")
    public ResultEnvelope<PaymentResult> makeTransaction2(@PathVariable("amount") Integer amount){

        var objectHttpEntity = paymentService.postForPayment(amount);

        PaymentResult paymentResult = restTemplate.postForObject(PAY_URL, objectHttpEntity, PaymentResult.class);

        log.info("Payment Details retrieved Successfully");
        return ResultEnvelope.ok(paymentResult) ;
    }

    

}
