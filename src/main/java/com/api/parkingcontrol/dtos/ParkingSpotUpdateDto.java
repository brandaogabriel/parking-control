package com.api.parkingcontrol.dtos;


import com.api.parkingcontrol.models.ParkingSpotModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotUpdateDto {

    @NotBlank
    private String parkingSpotNumber;

    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;

    @NotBlank
    private String brandCar;

    @NotBlank
    private String modelCar;

    @NotBlank
    private String colorCar;

    @NotBlank
    private String responsibleName;

    @NotBlank
    private String apartment;

    @NotBlank
    private String block;

    public ParkingSpotUpdateDto(){}

    public ParkingSpotModel toModel() {
        return new ParkingSpotModel(parkingSpotNumber, licensePlateCar, brandCar, modelCar, colorCar, responsibleName, apartment, block);
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
