package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@BatchSize(size=20)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @BatchSize(size=20)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @BatchSize(size=20)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @BatchSize(size=20)
    private Product product;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate shippingDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;

    private String receiverName;

    private String status;

    private String receiverAddress;

    private Integer amount;
}
