import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char currentChar = text.charAt(0);
        result.append(currentChar);
        for (int i = 0; i < text.length(); i++) {
            if (currentChar != text.charAt(i)){
             result.append(text.charAt(i));
            }
            currentChar = text.charAt(i);
        }
        System.out.println(result);

    }
}
