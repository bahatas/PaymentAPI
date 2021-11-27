package com.paymentapi.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrePersist;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDetails extends BaseEntity {

    private int amount;
    private String currency;
    private String beneficiary_name;
    private String beneficiary_reference;
    private int beneficiary_sort_code;
    private int beneficiary_account_number;
    private String remitter_reference;
    private String redirect_uri;


}
