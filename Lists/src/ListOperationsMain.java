import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperationsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList= Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String[] input = scanner.nextLine().toLowerCase().split("\\s+");

        while (!input[0].equals("end")){
            String command = input[0];
            switch (command){
                case "add":
                    int numToAdd = Integer.parseInt(input[1]);
                    //addElement(inputList, numToAdd);
                    inputList.add(numToAdd);
                    break;
                case "remove":
                    int indexToRem = Integer.parseInt(input[1]);
                    if (indexToRem <= inputList.size()-1 && indexToRem >= 0) {
                        inputList.remove(indexToRem);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "shift":
                    String direction = input[1];
                    int steps = Integer.parseInt(input[2]);
                    shift(inputList, steps, direction);
                    break;
                case "insert":
                    int number = Integer.parseInt(input[1]);
                    int index = Integer.parseInt(input[2]);
                    if (index <= inputList.size()-1 && index >= 0) {
                        inputList.add(index, number);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;
                default:
                    break;
            }
            for (int n :
                    inputList) {
                System.out.print(n + " ");
            }
            System.out.println();
            input = scanner.nextLine().toLowerCase().split("\\s++");
        }
        for (int i = 0; i < inputList.size(); i++) {
            if (i != inputList.size()-1){
                System.out.print(inputList.get(i) + " ");
            }else {
                System.out.print(inputList.get(i));
            }
        }
    }

    public static List<Integer> shift(List<Integer> list, int steps, String direction){
        if (direction.equals("right")){
            for (int j = 0; j < steps; j++) {
                int lastIndexRight = list.get(list.size()-1);
                for (int i = list.size() - 1; i > 0; i--) {
                    list.set(i, list.get(i-1));
                }
                list.set(0, lastIndexRight);
            }
        }else {
            for (int j = 0; j < steps; j++) {
                int firstIndexLeft = list.get(0);
                for (int i = 0; i < list.size()-1; i++) {
                    list.set(i, list.get(i+1));
                }
                list.set(list.size()-1, firstIndexLeft);
            }
        }
        return list;
    }

}
