package com.example.project3.controller;

import com.example.project3.Service.CarrierConfigurationService;
import com.example.project3.dto.CarrierConfigurationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrierConfiguration")
public class CarrierConfigurationController {

    @Autowired
    private CarrierConfigurationService configurationService;

    @GetMapping("/getAllConfiguration")
    public ResponseEntity getAllConfiguration(){

        try {
            return new ResponseEntity<>(configurationService.getAllCarrierConfigurations(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addConfiguration")
    public ResponseEntity addConfiguration(@RequestBody CarrierConfigurationDto carrierConfigurationDto){
        try {
            configurationService.addCarrierConfiguration(carrierConfigurationDto);
            return new ResponseEntity<>("carrier configuration successfully added",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateConfiguration/{configurationId}")
    public ResponseEntity updateConfiguration(@PathVariable Long configurationId,@RequestBody CarrierConfigurationDto carrierConfigurationDto){
        try {
            configurationService.updateCarrierConfiguration(configurationId,carrierConfigurationDto);
            return new ResponseEntity("configuration successfully updated",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteConfiguration/{configurationId}")
    public ResponseEntity deleteConfiguration(@PathVariable Long configurationId){
        try {
            configurationService.deleteCarrierConfiguration(configurationId);
            return new ResponseEntity<>("configuration successfully deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
