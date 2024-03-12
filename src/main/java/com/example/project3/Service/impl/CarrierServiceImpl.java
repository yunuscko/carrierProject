package com.example.project3.Service.impl;

import com.example.project3.Repository.CarrierRepository;
import com.example.project3.Service.CarrierService;
import com.example.project3.dto.CarrierDto;
import com.example.project3.entity.Carrier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarrierServiceImpl implements CarrierService {

    @Autowired
    private CarrierRepository carrierRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CarrierDto> getAllCarriers() {
        List<Carrier> carrierList=carrierRepository.findAll();

        return carrierList.stream()
                .map(carrier -> modelMapper.map(carrier,CarrierDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateCarrier(Long carrierId, CarrierDto carrierDto) {
        Optional<Carrier> optionalCarrier=carrierRepository.findById(carrierId);
        Carrier carrier1=modelMapper.map(carrierDto,Carrier.class);
        if(optionalCarrier.isPresent()){
            Carrier carrier2=optionalCarrier.get();

            carrier2.setCarrierId(carrier1.getCarrierId());
            carrier2.setCarrierConfigurationId(carrier1.getCarrierConfigurationId());
            carrier2.setCarrierConfigurations(carrier1.getCarrierConfigurations());
            carrier2.setCarrierName(carrier1.getCarrierName());
            carrier2.setCarrierIsActive(carrier1.getCarrierIsActive());
            carrier2.setCarrierPlusDesiCost(carrier1.getCarrierPlusDesiCost());
            carrier2.setOrders(carrier1.getOrders());

            carrierRepository.save(carrier2);
        }else {
            System.out.println("Error: Carrier to be updated not found.");
        }
    }

    @Override
    public void addCarrier(CarrierDto carrierDto) throws Exception {

        Optional<Carrier>optionalCarrier=carrierRepository.getCarrierByCarrierName(carrierDto.getCarrierName());
        if(optionalCarrier.isPresent()){
            throw new Exception("carrier is not found");
        }
        Carrier carrier=modelMapper.map(carrierDto,Carrier.class);
        carrierRepository.save(carrier);
    }

    @Override
    public void deleteCarrier(Long CarrierId) {
        carrierRepository.deleteById(CarrierId);

    }
}
