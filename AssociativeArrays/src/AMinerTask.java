import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resourceInput = scanner.nextLine();
        int resourceQuantity = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> resourcesMap = new LinkedHashMap<>();

        while (!resourceInput.equals("stop")){
            //TODO
            Integer currentValue = resourcesMap.get(resourceInput);
            if (currentValue == null){
                currentValue = 0;
            }
            resourcesMap.put(resourceInput, currentValue + resourceQuantity);

            resourceInput = scanner.nextLine();
            if (!resourceInput.equals("stop"))
            resourceQuantity = Integer.parseInt(scanner.nextLine());
        }

        resourcesMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
