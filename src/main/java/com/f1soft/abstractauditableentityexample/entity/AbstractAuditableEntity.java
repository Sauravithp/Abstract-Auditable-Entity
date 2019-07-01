package com.f1soft.abstractauditableentityexample.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity<U,ID> extends AbstractPersistableEntity<ID>{
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    LocalDate createdDate;

    @LastModifiedDate
    LocalDate lastModifiedDate;

    @CreatedBy
    @Column(name = "created_by",updatable = false)
    U createdBy;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    U lastModifiedBy;
}
