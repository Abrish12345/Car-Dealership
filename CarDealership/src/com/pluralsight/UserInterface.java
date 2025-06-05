package com.pluralsight;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        UserInterface.display();
    }

    public static void printMenu(){

        System.out.println(" ---- Dealership Menu ----");
        System.out.println("1) Find vehicle within a price range ");
        System.out.println("2) Find vehicle by make/model");
        System.out.println("3) Find vehicle by year range ");
        System.out.println("4) Find vehicle by color ");
        System.out.println("5) Find vehicle by mileage range");
        System.out.println("6) Find vehicle by type");
        System.out.println("7) List all vehicle");
        System.out.println("8) Add a vehicle");
        System.out.println("9) Remove a vehicles");
        System.out.println("99) Quit");


    }
    public static void display (){
        Scanner scanner= new Scanner(System.in);
        com.pluralsight.DealershipFileManager fileManager =new com.pluralsight.DealershipFileManager("C:\\Users\\Student\\Pluralsight\\Car-Dealership\\CarDealership\\vehicle.csv");
        com.pluralsight.Dealership dealership = fileManager.getDealership(); //load vehicles from file
        int choice=0;

        while(choice != 99){
            printMenu();
            System.out.println(" What would you like to do?");
            choice = scanner.nextInt();
            scanner.nextLine(); //consume new line.

            switch (choice) {
                case 1:
                    System.out.println("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();
                    System.out.println("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();
                    scanner.nextLine(); //consume newline

                    for (Vehicle v : dealership.getVehiclesByPrice(minPrice, maxPrice)) {
                        System.out.println(v.vehicleInfo());
                    }
                    break;
                case 2:
                    System.out.println("Enter make or model: ");

                    String makeModel = scanner.nextLine();

                    for (Vehicle v : dealership.getVehiclesByMakeOrModel(makeModel)) {
                        System.out.println(v.vehicleInfo());
                    }
                    break;
                case 3:
                    System.out.println("Enter minimum year: ");
                    int minYear = scanner.nextInt();
                    System.out.println("Enter maximum year: ");
                    int maxYear = scanner.nextInt();
                    scanner.nextLine(); //consume newline

                    for (Vehicle v : dealership.getVehiclesByYearRange(minYear, maxYear)) {
                        System.out.println(v.vehicleInfo());
                    }
                    break;
                case 4:
                    System.out.println("Enter color: ");
                    String color = scanner.nextLine();

                    for (Vehicle v : dealership.getVehiclesByColor(color)) {
                        System.out.println(v.vehicleInfo());
                    }
                    break;
                case 5:
                    System.out.println("Enter minimum mileage: ");
                    double minMileage = scanner.nextDouble();
                    System.out.println("Enter maximum mileage: ");
                    double maxMileage = scanner.nextDouble();
                    scanner.nextLine(); //consume newline

                    for (Vehicle v : dealership.getVehiclesByMileageRange(minMileage, maxMileage)) {
                        System.out.println(v.vehicleInfo());
                    }
                    break;
                case 6:
                    System.out.println("Enter vehicle type: ");
                    String type = scanner.nextLine();

                    for (Vehicle v : dealership.getVehiclesByType(type)) {
                        System.out.println(v.vehicleInfo());
                    }
                    break;
                case 7:

                    for (Vehicle v : dealership.getInventories()) {
                        System.out.println(v.vehicleInfo());
                    }
                    break;
                case 8:
                    System.out.println("Enter vin: ");
                    int vin = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter make : ");
                    String newMake = scanner.nextLine();

                    System.out.println("Enter model : ");
                    String newModel = scanner.nextLine();


                    System.out.println("Enter year: ");
                    int newYear = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter color: ");
                    String newColor = scanner.nextLine();

                    System.out.println("Enter mileage: ");
                    int newMileage = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter type: ");
                    String newType = scanner.nextLine();

                    System.out.println("Enter price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();

                    Vehicle newVehicle = new Vehicle(vin, newYear, newMake, newModel, newType, newColor, newMileage, newPrice);
                    dealership.addVehicle(newVehicle);
                    fileManager.saveDealership(dealership);
                    System.out.println("Vehicle added.");
                    break;

                case 9:
                    System.out.println("Enter VIN of vehicle to remove: ");
                    int removeVin = scanner.nextInt();
                    scanner.nextLine();
                    dealership.removeVehicle(removeVin);
                    fileManager.saveDealership(dealership);
                    System.out.println("Vehicle removed ");
                    break;
                case 99:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        }
    }
}