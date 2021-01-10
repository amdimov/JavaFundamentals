

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int numOfRotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfRotations; i++) {
            String firstElement = input[0];
            for (int j = 0; j < input.length-1; j++) {
                input[j] = input[j+1];
            }
            input[input.length-1] = firstElement;
        }
        for (String i :
                input) {
            System.out.print(i + " ");
        }
    }
}
