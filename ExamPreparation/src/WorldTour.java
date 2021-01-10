import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder travelPlan = new StringBuilder(scanner.nextLine());
        String[] inputCommand = scanner.nextLine().split(":");
        String command = inputCommand[0];
        while (!command.equals("Travel")){
            if (command.equals("Add Stop")){
                int indexToAdd = Integer.parseInt(inputCommand[1]);
                if (isItValidIndex(travelPlan, indexToAdd)){
                    travelPlan.insert(indexToAdd, inputCommand[2]);
                }
            }else if(command.equals("Remove Stop")){
                int indexToRemStart = Integer.parseInt(inputCommand[1]);
                int indexToRemEnd = Integer.parseInt(inputCommand[2]);

                if (isItValidIndex(travelPlan, indexToRemStart) && isItValidIndex(travelPlan, indexToRemStart)){
//                    travelPlan.delete(indexToRemStart, indexToRemEnd+1);
                    travelPlan.replace(indexToRemStart, indexToRemEnd+1, "");
                }

            }else if(command.equals("Switch")){
                String oldString = inputCommand[1];
                String newString = inputCommand[2];
                //int indexOfOld = travelPlan.indexOf(oldString);
                //int lastIndexOfOld = indexOfOld + oldString.length();

                //travelPlan.replace(indexOfOld, lastIndexOfOld, newString);
                travelPlan = new StringBuilder(travelPlan.toString().replace(oldString, newString));
            }
            System.out.println(travelPlan);
            inputCommand = scanner.nextLine().split(":");
            command = inputCommand[0];
        }
        System.out.println("Ready for world tour! Planned stops: "+travelPlan);

    }

    private static boolean isItValidIndex(StringBuilder travelPlan, int index) {
        return index < travelPlan.length() && index >= 0;
    }
}
