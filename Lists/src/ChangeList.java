import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = parseLineToInt(scanner);

        while (true){
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("end")){
                break;
            }
            String[] inputToArray = input.split("\\s+");

            if (inputToArray[0].equals("delete")){
                int i = 0;
                while (i < inputList.size()){
                    if (inputList.get(i) == Integer.parseInt(inputToArray[1])){
                            inputList.remove(i);
                    }else{
                        i++;
                    }
                }
            }else if (inputToArray[0].equals("insert")){
                if (Integer.parseInt(inputToArray[2]) >= 0 && Integer.parseInt(inputToArray[2]) < inputList.size())
                    inputList.add(Integer.parseInt(inputToArray[2]), Integer.parseInt(inputToArray[1]));
            }
        }

        printListInLine(inputList);

    }

    public static void printListInLine(List<Integer> listToPrint){
        for (int i = 0; i < listToPrint.size(); i++) {
            System.out.print(listToPrint.get(i));
            if (i != listToPrint.size()-1){
                System.out.print(" ");
            }
        }
    }
    public static List<Integer> parseLineToInt(Scanner scanner){
        String input = scanner.nextLine();
        String[] inputToArray = input.split("\\s+");
        List<Integer> inputToList = new ArrayList<>();

        for (int i = 0; i < inputToArray.length; i++) {
            inputToList.add(Integer.parseInt(inputToArray[i]));
        }
        return inputToList;
    }
}
