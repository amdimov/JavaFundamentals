import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(element ->Integer.parseInt(element)).toArray();
        int sumLeft = 0;
        int sumRight = 0;
        boolean areTheyEqual = false;
        boolean zeroTest = false;
        if (input.length > 1){
            for (int i = 0; i < input.length; i++) {
                //leftSum
                for (int j = 0; j < i; j++) {
                    sumLeft += input[j];
                }
                //rightSum
                for (int j = i+1; j < input.length; j++) {
                    sumRight += input[j];
                }
                if (sumLeft == sumRight){
                    System.out.println(i);
                    areTheyEqual = true;
                    break;
                }else {
                    sumLeft = 0;
                    sumRight = 0;
                }
            }
        }else {
            System.out.println(0);
            zeroTest = true;
        }
        if (!areTheyEqual && !zeroTest){
            System.out.println("no");
        }

    }
}
