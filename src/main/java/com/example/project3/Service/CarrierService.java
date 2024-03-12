package com.example.project3.Service;

import com.example.project3.dto.CarrierDto;

import java.util.List;

public interface CarrierService {

    List<CarrierDto> getAllCarriers();

    void updateCarrier(Long carrierId,CarrierDto carrierDto);

    void addCarrier(CarrierDto carrierDto) throws Exception;

    void deleteCarrier(Long CarrierId);

}
