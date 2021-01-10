import java.util.Scanner;

public class TripleOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char firstChar = 0;
        char secondChar = 0;
        char thirdChar = 0;
        for (int i = 0; i < n; i++) {
            firstChar = (char)('a'+ i);
            for (int j = 0; j < n; j++) {
                secondChar = (char)('a'+j);
                for (int k = 0; k < n; k++) {
                    thirdChar = (char)('a' + k);
                    System.out.printf("%s%s%s%n", firstChar,secondChar,thirdChar);
                }
            }
        }
    }
}
