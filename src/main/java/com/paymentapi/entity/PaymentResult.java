package com.paymentapi.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentResult extends BaseEntity {

    public String simp_id;
    public String auth_uri;
    public Date created_at;
    public int amount;
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
