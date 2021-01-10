import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    static class Vehicle{
        String type;
        String model;
        String color;
        int horsePower;

        Vehicle(String type, String model, String color, int horsePower){
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }
        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLines = scanner.nextLine().split("\\s+");
        List<Vehicle> vehiclesList = new ArrayList<>();

        while (!inputLines[0].equals("End")){
            //TODO
            Vehicle vehicle = new Vehicle(inputLines[0], inputLines[1], inputLines[2], Integer.parseInt(inputLines[3]));
            vehiclesList.add(vehicle);
            //INPUT
            inputLines = scanner.nextLine().split("\\s+");
        }
        String inputModels = scanner.nextLine();

        while (!inputModels.equals("Close the Catalogue")){
            //TODO
            for (int i = 0; i < vehiclesList.size(); i++) {
                if (vehiclesList.get(i).getModel().equals(inputModels)){
                    System.out.println("Type: " + vehiclesList.get(i).getType()
                            .substring(0,1).toUpperCase()
                            +vehiclesList.get(i).getType().substring(1).toLowerCase());
                    System.out.println("Model: " + vehiclesList.get(i).getModel());
                    System.out.println("Color: " + vehiclesList.get(i).getColor());
                    System.out.println("Horsepower: " + vehiclesList.get(i).getHorsePower());
                }
            }
            //INPUT
            inputModels = scanner.nextLine();
        }

        int numbOfCars = 0;
        int numOfTrucks = 0;
        int sumOfCarsHP = 0;
        int sumOfTrucksHP = 0;
        for (Vehicle n :
                vehiclesList) {
            if (vehiclesList.size() == 0) {
                break;
            }
            if (n.getType().equals("car")) {
                numbOfCars ++;
                sumOfCarsHP += n.getHorsePower();
            }else if(n.getType().equals("truck")){
                numOfTrucks ++;
                sumOfTrucksHP += n.getHorsePower();
            }
        }
        double avrgCars = (double)sumOfCarsHP/numbOfCars;
        double avrgTrucks = (double)sumOfTrucksHP/numOfTrucks;
        if (vehiclesList.size() == 0){
            avrgCars = 0.0;
            avrgTrucks = 0.0;
        }
        if (numbOfCars == 0){
            avrgCars = 0.0;
        }else if (numOfTrucks == 0){
            avrgTrucks = 0.0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", avrgCars);
        System.out.printf("Trucks have average horsepower of: %.2f.", avrgTrucks);
    }
}
