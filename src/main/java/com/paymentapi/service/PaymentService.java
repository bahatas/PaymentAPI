package com.paymentapi.service;


import com.paymentapi.dto.PaymentDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    TokenService tokenService;

    @Autowired
    RestTemplate restTemplate;

    public HttpEntity<Object> makePayment() {

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .amount(2)
                .currency("GBP")
                .beneficiary_name("Scan To Tip")
                .beneficiary_reference("pm benef ref")
                .beneficiary_sort_code(123456)
                .beneficiary_account_number(12345678)
                .remitter_reference("pm remit ref")
                .redirect_uri("https://scantotip.com").build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json; charset=UTF-8");
        headers.set("Authorization", "Bearer " + tokenService.generateToken().getAccess_token());

        return new HttpEntity<>(paymentDetails, headers);

    }

}
