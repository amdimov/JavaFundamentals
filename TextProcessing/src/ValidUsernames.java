import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        List<String> validWords = new ArrayList<>();
        boolean isItValid = true;

        for (int i = 0; i < input.length; i++) {
            if (input[i].length() < 3 || input[i].length() > 16){
                continue;
            }
            for (int j = 0; j < input[i].length(); j++) {
                char currentChar = input[i].charAt(j);
                if (!((currentChar >= 48 && currentChar <= 57) || (currentChar >= 65 && currentChar <= 90)
                        || (currentChar >= 97 && currentChar <= 122)) && currentChar != '-' && currentChar != '_'){
                    isItValid = false;
                    break;
                }
            }
            if (isItValid){
                validWords.add(input[i]);
            }
            isItValid = true;
        }

        for (String n:
                validWords) {
            System.out.println(n);
        }

    }
}
