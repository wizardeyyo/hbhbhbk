package com.example.demo.entities;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProductStats {

    @Id
    private String category;

    private Double sum;

    private Double prc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductStats that = (ProductStats) o;
        return category != null && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
