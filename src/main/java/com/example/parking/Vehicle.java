package com.example.parking;

public class Vehicle {
    private final String plateNumber;
    private final VehicleSize size;

    public Vehicle(String plateNumber, VehicleSize size) {
        this.plateNumber = plateNumber;
        this.size = size;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public VehicleSize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return plateNumber + " (" + size + ")";
    }
}