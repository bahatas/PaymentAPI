package com.paymentapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,updatable = false)
    public LocalDateTime insertDateTime;
    @Column(nullable = false)
    public LocalDateTime lastUpdateDateTime;

    private Boolean isDeleted = false;
}
