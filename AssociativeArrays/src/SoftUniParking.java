import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> carMap = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String user = input[1];
            String registeredUserPlate = carMap.get(user);
            if(command.equals("register")){
                String plateNumber = input[2];
                if (registeredUserPlate == null){
                    carMap.put(user, plateNumber);
                    System.out.printf("%s registered %s successfully%n", user, plateNumber);
                }else{
                    System.out.printf("ERROR: already registered with plate number %s%n", registeredUserPlate);
                }
            }else if(command.equals("unregister")){
                if (registeredUserPlate == null){
                    System.out.printf("ERROR: user %s not found%n", user);
                }else {
                    System.out.printf("%s unregistered successfully%n", user);
                    carMap.remove(user);
                }
            }

        }

        carMap.entrySet().forEach(e -> System.out.println(e.getKey()+" => "+e.getValue()));
    }
}
