import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printPalindromes(scanner);
    }

    private static void printPalindromes(Scanner scanner) {
        String input = scanner.nextLine();
        while (true){
            if (input.equals("END")){
                break;
            }
            System.out.println(checkIfPalindrome(input));
            input = scanner.nextLine();
        }
    }

    public static boolean checkIfPalindrome(String input){
        String rotate = new StringBuilder(input).reverse().toString();

        if (input.equals(rotate)){
            return true;
        }
        return false;
    }
}
