package com.paymentapi.service;

import com.paymentapi.dto.Client;
import com.paymentapi.dto.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class TokenService {

    @Autowired
    private RestTemplate restTemplate;


    /**
     *TRUELAYER API TEST ENVIRONMENT
     */
    public Token generateToken(){

        final String  CLIENT_ID = "sandbox-cydeoadmin-62a97f";
        final String CLIENT_SECRET = "f1799f13-8672-4b00-bb14-7b0faf353d7b";


        Client currentClient = Client.builder()
                .grant_type("client_credentials")
                .scope("payments")
                .client_id(CLIENT_ID)
                .client_secret(CLIENT_SECRET)
                .build();

        log.info("Test Client Provided");

        String TOKEN_URL = "https://auth.truelayer-sandbox.com/connect/token";
        Token token = restTemplate.postForObject(TOKEN_URL, currentClient, Token.class);

        log.info("True layer api consumed for token");


        return token;
    }

}
