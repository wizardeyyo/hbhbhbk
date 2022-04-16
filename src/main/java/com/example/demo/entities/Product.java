package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@BatchSize(size=20)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    @BatchSize(size=20)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @BatchSize(size=20)
    private Type type;

    private String unit;

    private Double price;

    private Integer inStock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
