package com.example.project3.Repository;

import com.example.project3.entity.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrierRepository extends JpaRepository<Carrier,Long> {

    Optional<Carrier>getCarrierByCarrierName(String carrierName);
}
