import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListsExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        List<Integer> inputStream = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
        System.out.println(numbers.size());

        System.out.println("--------------------");
        //inputStream.add(50);
        for (int i = 0; i < inputStream.size(); i++) {
            System.out.print(inputStream.get(i) + " ");
        }
        System.out.println();
        //inputStream.set(2, inputStream.get(2) + 3);
//        while(inputStream.contains(4)){
//            inputStream.remove((Integer)4);
//        } it returns true until there is 4 in the ArrayList
        for (int i = 0; i < inputStream.size(); i++) {
            System.out.print(inputStream.get(i) + " ");
        }
        System.out.println();
        System.out.println(inputStream.size());
        System.out.println("++++++++++");
        //shift(inputStream, 3, "left");
        List<Integer> testShift = shift(inputStream, 1, "left");
        for (int i :
                testShift) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> shift(List<Integer> listToShift, int steps, String leftOrRight){
        List<Integer> outputList = new ArrayList<>();
        int lastIndexValue;
        if (leftOrRight.equals("left")){
            //for (int i = 0; i < steps; i++) {
            int current = listToShift.get(0);
                for (int j = 0; j < listToShift.size(); j++) {
                    // 1 2 3 4 5
                    // 5 1 2 3 4
                    int next = 0;
                    int last = listToShift.get(listToShift.size()-1);
                    if (j == listToShift.size()-1){
                        listToShift.set(0, last);
                        break;
                    }
                    //listToShift.get(j+1);
                    if (j == 0) {
                        listToShift.set(j + 1, current);
                    }else {
                        listToShift.set(j+1, next);
                    }
                    next = listToShift.get(j+1);
                }
            //}
        }
        return listToShift;
    }
}
