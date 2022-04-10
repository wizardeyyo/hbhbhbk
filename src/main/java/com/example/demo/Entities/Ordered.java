package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ordered")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Ordered {

    @EmbeddedId
    private OrderProductId orderProductId;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "product_id")
    private Product product;

    private Double price;

    private Integer amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ordered ordered = (Ordered) o;
        return orderProductId != null && Objects.equals(orderProductId, ordered.orderProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderProductId);
    }
}
