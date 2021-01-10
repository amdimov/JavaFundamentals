import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCommands = Integer.parseInt(scanner.nextLine());

        List<String> goingToParty = new ArrayList<>();
        String input = "";

        for (int i = 0; i < numOfCommands; i++) {
            input = scanner.nextLine();
            String[] inputToArray = input.split("\\s+");
            String name = inputToArray[0];

            if (inputToArray[2].equals("going!")){
                if (!goingToParty.contains(name)) {
                    goingToParty.add(name);
                }else {
                    System.out.printf("%s is already in the list!%n", name);
                }
            }else if(inputToArray[2].equals("not")){
                if (goingToParty.contains(name)) {
                    while (goingToParty.contains(name)) {
                        goingToParty.remove(name);
                    }
                }else {
                    System.out.println(name + " is not in the list!");
                }
            }
        }

        for (String people :
                goingToParty) {
            System.out.println(people);
        }
    }
}
