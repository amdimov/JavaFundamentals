import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String inputString = "";

        while (!inputString.equals("end")){

            String[] inputStringToArray = scanner.nextLine().toLowerCase().split("\\s+");
            String command = inputStringToArray[0];
            String shitCommand = inputStringToArray[1];
            if (shitCommand.equals("left")){
//                for (int i = listInput.size()-1; i >= 0; i--) {
//
//                }
            }

            inputString = scanner.nextLine();
        }
    }
    public static List<Integer> shift(List<Integer> listToShift, int steps, String leftOrRight){
        List<Integer> outputList = new ArrayList<>();
        int current;
        int next;
        if (leftOrRight.equals("left")){
            for (int i = 0; i < steps; i++) {
                for (int j = 0; j < listToShift.size(); j++) {
                    current = listToShift.get(i);
                    next = listToShift.get(i+1);
                    if (i < listToShift.size()-1){
                        listToShift.set(i, current);
                    }else {
                        listToShift.set(i, current);
                    }
                }
            }
        }
        return listToShift;
    }
}
