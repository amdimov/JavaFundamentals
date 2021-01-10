import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> items = new HashMap<>();
        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);
        int currentValue = 0;
        String winner = "";
        boolean isItFound = false;
        while (items.get("shards") <= 250 && items.get("fragments") <= 250 && items.get("motes") <= 250){
            String[] input = scanner.nextLine().toLowerCase().split("\\s+");
            for (int i = 0; i < input.length; i++) {
                String item = "";
                if (i % 2 == 0){
                    currentValue = Integer.parseInt(input[i]);
                }else {
                    item = input[i];
                    Integer value = items.get(item);
                    if (value == null){
                        value = 0;
                    }
                    items.put(item, value + currentValue);
                    if (items.get("shards") >= 250 || items.get("fragments") >= 250 || items.get("motes") >= 250){
                        winner = item;
                        int temp = items.get(item);
                        items.put(item, temp - 250);
                        isItFound = true;
                        break;
                    }
                }
            }
            if (isItFound){
                break;
            }
        }
        if (winner.equals("shards")) {
            System.out.println("Shadowmourne" + " obtained!");
        }else if(winner.equals("fragments")){
            System.out.println("Valanyr" + " obtained!");
        }else {
            System.out.println("Dragonwrath" + " obtained!");
        }
        items.entrySet().stream().filter(e -> e.getKey().equals("fragments")
                || e.getKey().equals("shards") || e.getKey().equals("motes"))
                .sorted((a, b) -> {
                    if (a.getValue().compareTo(b.getValue()) != 0) {
                        return b.getValue().compareTo(a.getValue());
                    }else {
                        return a.getKey().compareTo(b.getKey());
                    }
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        items.entrySet().stream().filter(e -> !(e.getKey().equals("fragments")
                || e.getKey().equals("shards") || e.getKey().equals("motes")))
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));;
    }
}
