import java.util.*;

public class PlantDiscovery {
    static class Plant{
        String name;
        int rarity;
        int rating;
        int counterRate;
        double averageValue;

        public String getName() {
            return name;
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public int getCounterRate() {
            return counterRate;
        }

        public void setCounterRate(int counterRate) {
            this.counterRate = counterRate;
        }

        public double getAverageValue() {
            return averageValue;
        }

        public void updateCounterRate(){
            int current = getCounterRate();
            current++;
            setCounterRate(current);
        }
        public void updateRating(int newRating){
            int currentRating = getRating();
            this.rating = currentRating + newRating;
        }
        public void updateRarity(int newRarity){
            int currentRarity = getRarity();
            this.rarity = currentRarity + newRarity;
        }
        public void updateAverageValue(){
            if (this.counterRate != 0 && this.rating != 0){
                this.averageValue = (double)this.rating / this.counterRate;
            }else {
                this.averageValue = 0.0;
            }

        }

        Plant(String name, int rarity){
            this.name = name;
            this.rarity = rarity;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Plant> plantMap= new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("[\\s+]?<->[\\s+]?");
            String plantName = input[0].trim();
            int rarity = Integer.parseInt(input[1]);
            Plant getPlant = plantMap.get(plantName);

            if (getPlant == null){
                getPlant = new Plant(plantName, rarity);
                plantMap.put(plantName, getPlant);
            }else {
                getPlant.updateRarity(rarity);
            }
        }

        String[] input = scanner.nextLine().split(":\\s+");
        String command = input[0];
        while (!command.equals("Exhibition")){
            String[] commandSeparator = input[1].split("\\s+[-]\\s+");

            if (command.equals("Rate")){
                String plantsName = commandSeparator[0].trim();
                int currentRating = Integer.parseInt(commandSeparator[1]);
                Plant plant = plantMap.get(plantsName);
                if (plant != null){
                    plant.updateRating(currentRating);
                    plant.updateCounterRate();
                    plant.updateAverageValue();

                }else {
                    System.out.println("error");
                }
            }else if (command.equals("Update")){
                String plantsName = commandSeparator[0].trim();
                int currentRarity = Integer.parseInt(commandSeparator[1]);
                Plant plant = plantMap.get(plantsName);
                if (plant != null){
                    plant.setRarity(currentRarity);
                }else {
                    System.out.println("error");
                }
            }else if (command.equals("Reset")){
                String plantsName = commandSeparator[0].trim();
                Plant plant = plantMap.get(plantsName);
                if (plant != null){
                    plant.setRating(0);
                    plant.updateAverageValue();
                }else {
                    System.out.println("error");
                }
            }else{
                System.out.println("error");
            }
            input = scanner.nextLine().split(": ");
            command = input[0];
        }

        System.out.println("Plants for the exhibition:");
        plantMap.entrySet().stream().sorted((a, b) -> {
            if (a.getValue().getRarity() != b.getValue().getRarity()) {
                return Integer.compare(b.getValue().getRarity(), a.getValue().getRarity());
            }else {
                return Double.compare(b.getValue().getAverageValue(), a.getValue().getAverageValue());
            }
        }).forEach(e -> {
                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getValue().getName(), e.getValue().getRarity(),
                            e.getValue().getAverageValue());
                });
    }
}
