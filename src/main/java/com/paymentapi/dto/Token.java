package com.paymentapi.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {

    private String access_token;
    private String expires_in;
    private String token_type;
    private String scope;

}
