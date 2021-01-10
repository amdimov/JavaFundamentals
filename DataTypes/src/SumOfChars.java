import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());
        int charSum = 0;
        for (int i = 0; i < numOfLines; i++) {
            char inputChar = scanner.next().charAt(0);
            int charValue = (int)inputChar;
            charSum += charValue;
        }

        System.out.println("The sum equals: " + charSum);
    }
}
