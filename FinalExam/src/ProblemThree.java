import java.util.*;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> usersMap = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Statistics")){
            String[] inputSplit = input.split("->");
            String command = inputSplit[0];
            String username = inputSplit[1];
            List<String> user = usersMap.get(username);
            switch (command){
                case "Add":
                    if (user == null){
                        user = new ArrayList<>();
                        usersMap.put(username, user);
                    }else {
                        System.out.println(username + " is already registered");
                    }
                    break;
                case "Send":
                    String emailContent = inputSplit[2];
                    if (user != null){
                        user.add(emailContent);
                    }
                    break;
                case "Delete":
                    if(user != null){
                        usersMap.remove(username, user);
                    }else {
                        System.out.println(username + " not found!");
                    }
                    break;

            }
            input = scanner.nextLine().trim();
        }

        System.out.println("Users count: " + usersMap.size());

        usersMap.entrySet().stream().sorted((a, b) ->{
            if (a.getValue().size() != b.getValue().size()){
                return Integer.compare(b.getValue().size(), a.getValue().size());
            }else {
                return a.getKey().compareTo(b.getKey());
            }
        }).forEach(e ->{
            System.out.println(e.getKey());
            e.getValue().forEach(c ->{
                System.out.println(" - " + c);
            });
        });

        //usersMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "--->" + String.join(" | ", e.getValue())));
    }
}
