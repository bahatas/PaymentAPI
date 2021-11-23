package com.paymentapi.controller;


import com.paymentapi.dto.*;
import com.paymentapi.service.PaymentService;
import com.paymentapi.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class AuthenticationController {

    /**
     * username:admin
     * password:admin
     */

    @Autowired
    TokenService tokenService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PaymentService paymentService;

    @GetMapping("/token")
    public ResultEnvelope<TokenResponse> getToken() {


        Token token = tokenService.generateToken();

        log.info("Token retrieved");

        assert token != null;
        return ResultEnvelope.ok(new TokenResponse(token.getAccess_token()));
    }

    @GetMapping("/makepayment")
    public ResponseEntity<ResponseWrapper> getPayment() {

        String pay_url="https://pay-api.truelayer-sandbox.com/single-immediate-payments";

        HttpEntity<Object> objectHttpEntity = paymentService.makePayment();

        PaymentResult paymentResult = restTemplate.postForObject(pay_url, objectHttpEntity, PaymentResult.class);

        log.info("payment completed");

        return ResponseEntity.ok(new ResponseWrapper("Payment completed successfully",paymentResult));
    }

    @GetMapping("/callback/{id}")
    public ResponseEntity<ResponseWrapper> paymentDetail(@PathVariable String id){

        return ResponseEntity.ok(new ResponseWrapper("Payment detail page",id));
    }
}
