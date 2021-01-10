import java.util.Scanner;

public class PrintPartOfAscii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        char intToChar;
        for (int i = first; i <= second; i++) {
            intToChar = (char)i;
            System.out.print(intToChar + " ");
        }

    }
}
