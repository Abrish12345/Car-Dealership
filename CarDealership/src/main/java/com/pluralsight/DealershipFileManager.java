package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DealershipFileManager {

    private final String filepath;

    public DealershipFileManager(String filepath){
        this.filepath=filepath;
    }

    public Dealership getDealership() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String[] info = reader.readLine().split("\\|");
            List<Vehicle> vehicles = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                vehicles.add(new Vehicle(
                        Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        parts[2],
                        parts[3],
                        parts[4],
                        parts[5],
                        Integer.parseInt(parts[6]),
                        Double.parseDouble(parts[7])
                ));
            }
            return new Dealership(info[0], info[1], info[2], vehicles);
        } catch (IOException e) {
            System.out.println("File writer error: " + filepath);
            return null;
        }
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber());
            writer.newLine();

            for (Vehicle v : dealership.getInventories()) {
                writer.write(v.getVin() + "|" +
                        v.getYear() + "|" +
                        v.getMake() + "|" +
                        v.getModel() + "|" +
                        v.getType() + "|" +
                        v.getColor() + "|" +
                        v.getMileage() + "|" +
                        v.getPrice());
            }
        } catch (IOException e) {
            System.out.println("File writer error: " + filepath);
        }
    }

 
}
