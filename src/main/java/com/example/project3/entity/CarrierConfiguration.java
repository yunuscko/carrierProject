package com.example.project3.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Data
@Table(name = "carrierConfigurations")
public class CarrierConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CarrierConfigurationId;

    private int carrierId;

    private int carrierMaxDesi;

    private int carrierMinDesi;

    private BigDecimal cost;

    @ManyToOne
    private Carrier carrier;
}
