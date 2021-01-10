import java.util.Scanner;

public class SameAsMineWithSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder travelPlan = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Travel")){
            String[] command = input.split(":");
            switch (command[0]) {
                case "Add Stop":
                    int indexToAdd = Integer.parseInt(command[1]);
                    String insertString = command[2];
                    if (isItValidIndex(travelPlan, indexToAdd)) {
                        travelPlan.insert(indexToAdd, insertString);
                    }
                    break;
                case "Remove Stop":
                    int indexToRemStart = Integer.parseInt(command[1]);
                    int indexToRemEnd = Integer.parseInt(command[2]);
                    if (isItValidIndex(travelPlan, indexToRemStart) && isItValidIndex(travelPlan, indexToRemEnd)) {
                        travelPlan.replace(indexToRemStart, indexToRemEnd + 1, "");
                    }
                    break;
                case "Switch":
                    String oldString = command[1];
                    String newString = command[2];
                    travelPlan = new StringBuilder(travelPlan.toString().replace(oldString, newString));
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
            System.out.println(travelPlan);
            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: "+travelPlan);
    }
    private static boolean isItValidIndex(StringBuilder travelPlan, int index) {
        return index < travelPlan.length() && index >= 0;
    }
}
