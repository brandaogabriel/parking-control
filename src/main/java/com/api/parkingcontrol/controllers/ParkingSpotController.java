package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/parking-spot")
public class ParkingSpotController {

    private final ParkingSpotService service;

    public ParkingSpotController(ParkingSpotService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto request) {
        if (service.existsByLicensePlateCar(request.getLicensePlateCar())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Unprocessable Entity: License Plate Car is already in use!");
        }
        if (service.existsByParkingSpotNumber(request.getParkingSpotNumber())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Unprocessable Entity: Parking spot is already in use!");
        }
        if (service.existsByApartmentAndBlock(request.getApartment(), request.getBlock())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Unprocessable Entity: Parking Spot registered for this apartment/block!");
        }

        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(request, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(parkingSpotModel));
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
}
