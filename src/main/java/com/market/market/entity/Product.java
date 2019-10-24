package com.market.market.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Data
@Entity
@NoArgsConstructor
@Table(name="product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private BigInteger id;

    @Column(name = "market_id", columnDefinition = "int")
    private Integer marketId;

    @Size(max = 255, message = "Name should not be greater than 255")
    @Column(name = "name", columnDefinition = "nvarchar(255)")
    private String name;

}
