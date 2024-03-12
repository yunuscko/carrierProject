package com.example.project3.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderId;

    private int carrierId;

    private int orderDesi;

    private LocalDate orderDate;

    private BigDecimal orderCarrierCost;

    @ManyToOne
    private Carrier carrier;

}
