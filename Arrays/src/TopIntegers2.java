import java.util.Scanner;

public class TopIntegers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int bestNumOfRights = Integer.MIN_VALUE;
        int leftInt;
        int rightInt;
        boolean isTheLeftGreater = false;
        for (int i = 0; i < input.length; i++) {
            leftInt = Integer.parseInt(input[i]);
            for (int j = i+1; j < input.length; j++) {
                rightInt = Integer.parseInt(input[j]);
                if (rightInt > bestNumOfRights){
                    bestNumOfRights = rightInt;
                }
            }
            if (leftInt > bestNumOfRights){
                System.out.print(leftInt + " ");
            }
            bestNumOfRights = Integer.MIN_VALUE;
        }
    }
}
