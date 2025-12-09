package com.example.parking;

import com.example.parking.Vehicle;
import com.example.parking.VehicleSize;
import com.example.parking.ParkingSlot;
import com.example.parking.ParkingLot;
import java.util.Scanner;

public class ParkingLotApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Parking Lot Management!");

        System.out.print("Enter number of SMALL slots: ");
        int small = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter number of LARGE slots: ");
        int large = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter number of OVERSIZE slots: ");
        int oversize = Integer.parseInt(scanner.nextLine());

        ParkingLot parkingLot = new ParkingLot(small, large, oversize);

        printHelp();

        while (true) {
            System.out.print("\nEnter command: ");
            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase("QUIT")) {
                System.out.println("Goodbye!");
                break;
            }

            if (line.equalsIgnoreCase("HELP")) {
                printHelp();
                continue;
            }

            if (line.equalsIgnoreCase("STATUS")) {
                parkingLot.printStatus();
                continue;
            }

            String[] parts = line.split("\\s+");
            if (parts.length == 0) continue;

            String cmd = parts[0].toUpperCase();

            switch (cmd) {
                case "PARK":
                    if (parts.length != 3) {
                        System.out.println("Usage: PARK <plate> <SMALL|LARGE|OVERSIZE>");
                        break;
                    }
                    String plate = parts[1];
                    try {
                        VehicleSize size = VehicleSize.valueOf(parts[2].toUpperCase());
                        Vehicle v = new Vehicle(plate, size);
                        parkingLot.parkVehicle(v);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid size. Use SMALL, LARGE or OVERSIZE.");
                    }
                    break;

                case "EXIT":
                    if (parts.length != 2) {
                        System.out.println("Usage: EXIT <plate>");
                        break;
                    }
                    parkingLot.exitVehicle(parts[1]);
                    break;

                default:
                    System.out.println("Unknown command. Type HELP.");
            }
        }

        scanner.close();
    }

    private static void printHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("  PARK <plate> <SMALL|LARGE|OVERSIZE>");
        System.out.println("  EXIT <plate>");
        System.out.println("  STATUS");
        System.out.println("  HELP");
        System.out.println("  QUIT");
    }
}