package com.example.project3.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "carriers")
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CarrierId;

    private String carrierName;

    private Boolean CarrierIsActive;

    private int carrierPlusDesiCost;

    private int carrierConfigurationId;

    @OneToMany
    private List<Order> orders;

    @OneToMany
    private List<CarrierConfiguration> carrierConfigurations;

}
