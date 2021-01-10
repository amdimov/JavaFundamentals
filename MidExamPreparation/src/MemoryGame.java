import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    //https://judge.softuni.bg/Contests/Practice/Index/2517#2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Object::toString).collect(Collectors.toList());
        String[] inputCommands = scanner.nextLine().split("\\s+");
        int steps = 0;
        while (!inputCommands[0].equals("end")){
            //TODO
            steps++;
            int firstIndex = Integer.parseInt(inputCommands[0]);
            int secondIndex = Integer.parseInt(inputCommands[1]);
            boolean indexIsInBounders = firstIndex >= 0 && firstIndex <= inputList.size()-1
                    && secondIndex >= 0 && secondIndex <= inputList.size()-1;
            boolean indexIsNotDuplicated = firstIndex != secondIndex;
            if (indexIsInBounders && indexIsNotDuplicated){
                if (inputList.get(firstIndex).equals(inputList.get(secondIndex))){
                    System.out.printf("Congrats! You have found matching elements - %s!%n", inputList.get(firstIndex));
                    if(firstIndex > secondIndex){
                        inputList.remove(firstIndex);
                        inputList.remove(secondIndex);
                    }else{
                        inputList.remove(secondIndex);
                        inputList.remove(firstIndex);
                    }
                    if (inputList.size() == 0){
                        break;
                    }
                }else{
                    //TODO "Try again"
                    System.out.println("Try again!");
                }
                    //printListOfStrings(inputList, " ");
            }else{
                //TODO
                System.out.println("Invalid input! Adding additional elements to the board");
                int middleIndexOfList = inputList.size()/2;
                String penaltyElement = "-"+steps+"a";
                inputList.add(middleIndexOfList, penaltyElement);
                inputList.add(middleIndexOfList+1, penaltyElement);
                //printListOfStrings(inputList, " ");
            }

            inputCommands = scanner.nextLine().split("\\s+");
        }
        if (inputList.size() == 0) {
            System.out.printf("You have won in %d turns!%n", steps);
        }else{
            System.out.println("Sorry you lose :(");
            printListOfStrings(inputList, " ");
        }

    }



    public static void printListOfStrings(List<String> arrayList, String delimiter){
        for (String n :
                arrayList) {
            System.out.print(n + delimiter);
        }
        System.out.println();
    }
}
