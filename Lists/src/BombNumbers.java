import jdk.nashorn.api.tree.IfTree;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String[] input = scanner.nextLine().split("\\s+");
        int specialBomb = Integer.parseInt(input[0]);
        int bombPower = Integer.parseInt(input[1]);

        while(inputList.contains(specialBomb)){
            int leftIndex = Math.max(0, inputList.indexOf(specialBomb) - bombPower);
            int rightIndex = Math.min(inputList.size()-1, inputList.indexOf(specialBomb) + bombPower);

            for (int i = rightIndex; i >= leftIndex; i--) {
                inputList.remove(i);
            }
            //1 2 2 4 2 2 2 9
            //0 1 2 3 4 5 6 7
        }
        int sum = 0;
        for (int n :
                inputList) {
            sum += n;
        }
        System.out.print(sum);
    }
}
