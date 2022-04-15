package com.example.demo.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class OrderProductId implements Serializable {

    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "product_id")
    private Long product_id;
}
