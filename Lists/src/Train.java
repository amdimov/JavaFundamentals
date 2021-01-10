import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int capacity = Integer.parseInt(scanner.nextLine());
        while (true){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            }
            String[] inputToArray = input.split("\\s+");
            if(inputToArray[0].equals("Add")){
                addWagon(wagons, inputToArray[1]);
            }else{
                arrangePassangers(wagons, capacity, inputToArray[0]);
            }
        }

        for (int wagon :
                wagons) {
            System.out.print(wagon + " ");
        }
    }

    private static void addWagon(List<Integer> wagons, String s) {
        wagons.add(Integer.parseInt(s));
    }

    private static void arrangePassangers(List<Integer> wagons, int capacity, String s) {
        for (int i = 0; i < wagons.size(); i++) {
            int freeSpace = capacity - wagons.get(i);
            if (Integer.parseInt(s) <= freeSpace){
                wagons.set(i, Integer.parseInt(s) + wagons.get(i));
                break;
            }
        }
    }
}
