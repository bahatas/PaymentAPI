package com.paymentapi.entity;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.data.auditing.AuditingHandler;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Component
public class BaseEntityListener extends AuditingEntityListener {

   @PrePersist
    private void onPrePersist(BaseEntity baseEntity){
       baseEntity.insertDateTime = LocalDateTime.now();
       baseEntity.lastUpdateDateTime = LocalDateTime.now();
   }

   @PreUpdate
   private void onPreUpdate(BaseEntity baseEntity) {


       baseEntity.lastUpdateDateTime = LocalDateTime.now();
   }
}
