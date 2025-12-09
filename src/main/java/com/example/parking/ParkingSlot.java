package com.example.parking;
import com.example.parking.Vehicle;
import com.example.parking.VehicleSize;
public class ParkingSlot {
    private final int id;
    private final VehicleSize size;
    private Vehicle parkedVehicle; // null if empty

    public ParkingSlot(int id, VehicleSize size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public VehicleSize getSize() {
        return size;
    }

    public boolean isFree() {
        return parkedVehicle == null;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }

    public void leave() {
        this.parkedVehicle = null;
    }
}