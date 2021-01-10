import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char indexChar = scanner.next().charAt(0);
        char endingChar = scanner.next().charAt(0);

        getCharRange(indexChar, endingChar);

    }

    public static void getCharRange(char startingChar, char endChar){
        if(startingChar < endChar) {
            while (startingChar < endChar - 1) {
                startingChar++;
                System.out.printf("%c ", startingChar);
            }
        }else {
            while (startingChar > endChar + 1) {
                endChar++;
                System.out.printf("%c ", endChar);
            }
        }
    }

}
