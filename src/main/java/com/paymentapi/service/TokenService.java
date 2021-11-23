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

        String client_id = "sandbox-admin-279c9b";
        String client_secret = "30c34234-79ae-4ab3-99af-2887f19f5361";


        Client currentClient = Client.builder()
                .grant_type("client_credentials")
                .scope("payments")
                .client_id(client_id)
                .client_secret(client_secret)
                .build();

        log.info("Test Client provided");

        String TOKEN_URL = "https://auth.truelayer-sandbox.com/connect/token";
        Token token = restTemplate.postForObject(TOKEN_URL, currentClient, Token.class);

        log.info("True layer api consumed for token");


        return token;
    }

}
