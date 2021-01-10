import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String input = "";
        while (!input.equals("end")){
            String[] command = input.split("\\s+");

            if (command[0].equals("delete")){
                while (inputList.contains(Integer.parseInt(command[1]))){
                    inputList.remove(Integer.valueOf(command[1]));
                }
            }
            if (command[0].equals("insert")){
                if(Integer.parseInt(command[2]) >= 0 && Integer.parseInt(command[2]) < inputList.size())
                inputList.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
            }
            input = scanner.nextLine().toLowerCase();
        }

        for (int inputLists :
                inputList) {
            System.out.print(inputLists + " ");
        }
    }
}
