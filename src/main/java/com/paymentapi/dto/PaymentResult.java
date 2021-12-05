package com.paymentapi.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResult {

    public String status;
    public List<Results> results;

    static class Results{
        public String simp_id;
        public String auth_uri;
        public Date created_at;
        public Integer amount;
        public String currency;
        public String beneficiary_name;
        public String beneficiary_sort_code;
        public String beneficiary_account_number;
        public String beneficiary_reference;
        public String remitter_reference;
        public String redirect_uri;
        public String webhook_uri;
        public String status;
    }

}
