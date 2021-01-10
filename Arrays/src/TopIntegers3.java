import java.util.Scanner;

public class TopIntegers3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int leftInt;
        int rightInt;

        for (int i = 0; i < input.length; i++) {
            boolean isTopInteger = true;
            leftInt = Integer.parseInt(input[i]);
            for (int j = i+1; j < input.length; j++) {
                rightInt = Integer.parseInt(input[j]);
                if (leftInt   <= rightInt){
                    isTopInteger = false;
                }
            }
            if (isTopInteger){
                System.out.print(leftInt + " ");
            }
        }
    }
}
