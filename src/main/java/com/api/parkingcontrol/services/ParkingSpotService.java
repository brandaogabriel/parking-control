package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ParkingSpotService {

    private final ParkingSpotRepository repository;

    public ParkingSpotService(ParkingSpotRepository repository) {
        this.repository = repository;
    }


    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return repository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String license) {
        return repository.existsByLicensePlateCar(license);
    }

    public boolean existsByParkingSpotNumber(String number) {
        return repository.existsByParkingSpotNumber(number);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return repository.existsByApartmentAndBlock(apartment, block);
    }

    public List<ParkingSpotModel> findAll() {
        return repository.findAll();
    }
}
