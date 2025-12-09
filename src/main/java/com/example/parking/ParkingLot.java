package com.example.parking;

import com.example.parking.Vehicle;
import com.example.parking.VehicleSize;
import java.util.*;

public class ParkingLot {

    private final List<ParkingSlot> slots = new ArrayList<>();
    // Quick lookup from plate to slot
    private final Map<String, ParkingSlot> occupiedByPlate = new HashMap<>();

    public ParkingLot(int smallCount, int largeCount, int oversizeCount) {
        int id = 1;

        for (int i = 0; i < smallCount; i++) {
            slots.add(new ParkingSlot(id++, VehicleSize.SMALL));
        }
        for (int i = 0; i < largeCount; i++) {
            slots.add(new ParkingSlot(id++, VehicleSize.LARGE));
        }
        for (int i = 0; i < oversizeCount; i++) {
            slots.add(new ParkingSlot(id++, VehicleSize.OVERSIZE));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (occupiedByPlate.containsKey(vehicle.getPlateNumber())) {
            System.out.println("Vehicle already parked.");
            return false;
        }

        for (ParkingSlot slot : slots) {
            if (slot.isFree() && canFit(vehicle.getSize(), slot.getSize())) {
                slot.park(vehicle);
                occupiedByPlate.put(vehicle.getPlateNumber(), slot);
                System.out.println("Parked " + vehicle + " in slot " + slot.getId());
                return true;
            }
        }
        System.out.println("No suitable slot available for " + vehicle);
        return false;
    }

    private boolean canFit(VehicleSize vehicleSize, VehicleSize slotSize) {
        switch (vehicleSize) {
            case SMALL:
                // can park anywhere
                return true;
            case LARGE:
                return slotSize == VehicleSize.LARGE || slotSize == VehicleSize.OVERSIZE;
            case OVERSIZE:
                return slotSize == VehicleSize.OVERSIZE;
            default:
                return false;
        }
    }

    public boolean exitVehicle(String plateNumber) {
        ParkingSlot slot = occupiedByPlate.get(plateNumber);
        if (slot == null) {
            System.out.println("Vehicle not found.");
            return false;
        }
        slot.leave();
        occupiedByPlate.remove(plateNumber);
        System.out.println("Vehicle " + plateNumber + " left slot " + slot.getId());
        return true;
    }

    public void printStatus() {
        System.out.println("=== Parking Lot Status ===");
        for (ParkingSlot slot : slots) {
            String status = slot.isFree()
                    ? "FREE"
                    : "OCCUPIED by " + slot.getParkedVehicle().getPlateNumber();
            System.out.println("Slot " + slot.getId() + " [" + slot.getSize() + "] - " + status);
        }
        System.out.println("==========================");
    }
}