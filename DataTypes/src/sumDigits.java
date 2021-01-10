import java.util.Scanner;

public class sumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < inputNumber.length(); i++) {
            char digit = inputNumber.charAt(i);
            int number = Character.getNumericValue(digit);
            sum += number;
        }
        System.out.println(sum);
        
    }
}
