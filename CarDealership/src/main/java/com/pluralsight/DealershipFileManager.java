package com.pluralsight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class DealershipFileManager {
    private String filepath;

    public DealershipFileManager(String filepath) {
        this.filepath=filepath;
    }

public Dealership getDealership(){
    try(Scanner scanner = new Scanner(new File(filepath))) {
        String[] info = scanner.nextLine().split("\\|");
        List<Vehicle> vehicles = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split("\\|");
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
        return new Dealership(info[0], info[1],info[2], vehicles);
    }catch (IOException e) {
        System.out.println("File writer error: " + filepath);
        return null;
        }
    }
        public void saveDealership(Dealership dealership){
            try(PrintWriter writer= new PrintWriter(filepath)){
            writer.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber());
            for (Vehicle v : dealership.getInventories()){
                writer.println(v.getVin() + "|" +
                        v.getYear() + "|" +
                    v.getMake() + "|" +
                    v.getModel() + "|" +
                    v.getType() + "|" +
                    v.getColor() + "|" +
                    v.getMileage()+ "|" +
                    v.getPrice());
            }
            }catch(IOException e) {
            System.out.println("File writer error: " + filepath);
            }
        }


}
