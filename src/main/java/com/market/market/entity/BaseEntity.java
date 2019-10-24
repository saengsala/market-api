package com.market.market.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @NotNull(message = "createdBy can't null!")
    @NotBlank(message = "createdBy can't empty!")
    @Column(name = "created_by")
    private String createdBy ;

    @Column(name = "created_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreatedDate
    private Date createdDate ;

    @Column(name = "updated_by")
    private String updatedBy ;

    @Column(name = "updated_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @LastModifiedDate
    private Date updatedDate ;

}
