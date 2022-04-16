package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "suppliers")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@BatchSize(size=20)
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String name;
    private String position;
    private String address;
    private String phone;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Supplier supplier = (Supplier) o;
        return id != null && Objects.equals(id, supplier.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
