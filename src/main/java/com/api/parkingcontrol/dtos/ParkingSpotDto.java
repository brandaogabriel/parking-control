package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.validation.ExistsValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDto {

    @NotBlank
    @ExistsValue(domainClass = ParkingSpotModel.class, fieldName = "parking_spot_number")
    private String parkingSpotNumber;

    @NotBlank
    @Size(max = 7)
    @ExistsValue(domainClass = ParkingSpotModel.class, fieldName = "license_plate_car")
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

    @Deprecated
    public ParkingSpotDto() {}

    public ParkingSpotModel toModel() {
        return new ParkingSpotModel(parkingSpotNumber, licensePlateCar, brandCar, modelCar, colorCar, responsibleName, apartment, block);
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
