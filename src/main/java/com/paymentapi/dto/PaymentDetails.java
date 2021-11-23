package com.paymentapi.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDetails {

    private int amount;
    private String currency;
    private String beneficiary_name;
    private String beneficiary_reference;
    private int beneficiary_sort_code;
    private int beneficiary_account_number;
    private String remitter_reference;
    private String redirect_uri;
}
