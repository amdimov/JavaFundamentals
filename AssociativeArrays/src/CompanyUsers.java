import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyMap = new TreeMap<>();

        String[] input = scanner.nextLine().split(" -> ");

        String companyName = input[0];

        while (!companyName.equals("End")){
            //TODO
            String id = input[1];
            List<String> getIdFromMap = companyMap.get(companyName);
            if (getIdFromMap == null){
                getIdFromMap = new ArrayList<>();
                companyMap.put(companyName, getIdFromMap);
            }
            if (!getIdFromMap.contains(id)) {
                getIdFromMap.add(id);
            }
            input = scanner.nextLine().split(" -> ");
            companyName = input[0];
        }

        companyMap.entrySet().stream()

                .forEach(e ->
                {
                    System.out.println(e.getKey());
                    e.getValue()
                            .stream()
                            .forEach(b -> System.out.println("-- " + b));
                });
//        for (Map.Entry<String, List<String>> n :
//                companyMap.entrySet()) {
//            System.out.println(n.getKey() + " -> " + String.join(", ", n.getValue()));
//        }
    }
}
