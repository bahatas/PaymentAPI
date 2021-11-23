package com.paymentapi.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Component
@AllArgsConstructor
public class Client {

    private String client_id;
    private String client_secret;
    private String scope;
    private String grant_type;

    public Client(String client_id, String client_secret) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.scope = "payments";
        this.grant_type = "client_credentials";
    }

}
