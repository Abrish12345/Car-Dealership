package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Vehicle> inventories;

//Constructor

    public Dealership(String name, String address, String phoneNumber, List<Vehicle> inventories) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventories = inventories;
    }

    //getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Vehicle> getInventories() {
        return inventories;
    }

    public void setInventories(List<Vehicle> inventories) {
        this.inventories = inventories;
    }

    //add a vehicle
    public void addVehicle(Vehicle vehicle) {
        inventories.add(vehicle);
    }

    //remove a vehicle by VIN
    public void removeVehicle(int vehicleVin) {
        inventories.removeIf(vehicle -> vehicle.getVin() == vehicleVin);

    }

    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        List<Vehicle> resultes = new ArrayList<>();
        for (Vehicle vehicle : inventories) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                resultes.add(vehicle);
            }
        }
        return resultes;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventories) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByMileageRange(double minMileage, double maxMileage) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventories) {
            if (vehicle.getMileage() >= minMileage && vehicle.getMileage() <= maxMileage) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventories) {
            if (vehicle.getType().equalsIgnoreCase(type)) {
                result.add(vehicle);
            }
        }
        return result;

    }

    public List<Vehicle> getVehiclesByMakeOrModel(String makeModel) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventories) {
            if (vehicle.getMake().equalsIgnoreCase(makeModel) || vehicle.getModel().equalsIgnoreCase(makeModel)) {
                result.add(vehicle);
            }
        }
        return result;

    }

    public List<Vehicle> getVehiclesByYearRange(int minYear, int maxYear) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventories) {
            int year = vehicle.getYear();

            if (year >= minYear && year <= maxYear) {
                result.add(vehicle);
            }
        }
        return result;

    }
}