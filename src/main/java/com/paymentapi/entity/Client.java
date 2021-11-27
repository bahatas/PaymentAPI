package com.paymentapi.entity;


import lombok.*;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client extends BaseEntity{
    private String client_id;
    private String client_secret;
    private String scope;
    private String grant_type;
}
