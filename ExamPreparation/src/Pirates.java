import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    static class Town
    {
        public String getTownName() {
            return townName;
        }

        public void setTownName(String townName) {
            this.townName = townName;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
        public int updateGold(int gold){
            return this.gold + gold;
        }
        public int updatePopulation(int population){
            return this.population + population;
        }
        String townName;
        int population;
        int gold;

        Town(String townName, int population, int gold){
            this.townName = townName;
            this.population = population;
            this.gold = gold;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();
        String[] inputSplit = input.split("\\|\\|");
        Map<String, Town> townMap = new LinkedHashMap<>();

        while (!input.equals("Sail")){
            String townName = inputSplit[0].trim();
            int popultaion = Integer.parseInt(inputSplit[1].trim());
            int gold = Integer.parseInt(inputSplit[2].trim());
            Town town = townMap.get(townName);

            if (town == null){
                Town newTown = new Town(townName, popultaion, gold);
                townMap.put(townName, newTown);
            }else {
                town.setGold(town.updateGold(gold));
                town.setPopulation(town.updatePopulation(popultaion));
            }
            input = scanner.nextLine().trim();
            inputSplit = input.split("\\|\\|");
        }

        input = scanner.nextLine();
        //inputSplit = input.split("=>");
        while (!input.equals("End")){
            inputSplit = input.split("=>");
            String command = inputSplit[0].trim();
            String townName = inputSplit[1].trim();
            Town getTown = townMap.get(townName);
            switch (command){
                case "Plunder":
                    int peopleKilled = Integer.parseInt(inputSplit[2].trim());
                    int gold = Integer.parseInt(inputSplit[3].trim());
                    if (getTown != null){
                        getTown.setPopulation(getTown.getPopulation() - peopleKilled);
                        getTown.setGold(getTown.getGold() - gold);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",
                        townName, gold, peopleKilled);
                        if (getTown.getGold() == 0 || getTown.getPopulation() == 0){
                            System.out.println(townName + " has been wiped off the map!");
                            townMap.remove(townName);
                        }
                    }
                    break;
                case "Prosper":
                    int prosperGold = Integer.parseInt(inputSplit[2].trim());
                    if (prosperGold >= 0){
                            getTown.setGold(getTown.getGold() + prosperGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                prosperGold, getTown.getTownName(), getTown.getGold());
                    }else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }

            input = scanner.nextLine().trim();

        }

        if (townMap.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", townMap.size());
            townMap.entrySet().stream()
                    .sorted((a, b) -> {
                        if (a.getValue().getGold() != b.getValue().getGold()) {
                            return Integer.compare(b.getValue().getGold(), a.getValue().getGold());
                        } else {
                            return a.getValue().getTownName().compareTo(b.getValue().getTownName());
                        }
                    })
                    .forEach(e -> {
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                                e.getValue().getTownName(), e.getValue().getPopulation(), e.getValue().getGold());
                    });
        }else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
