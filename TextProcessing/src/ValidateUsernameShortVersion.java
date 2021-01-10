import javax.print.DocFlavor;
import java.util.Scanner;

public class ValidateUsernameShortVersion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        for (String n :
                input) {
                if (isItValidUsername(n))
                System.out.println(n);

        }

    }

    public static boolean isItValidUsername(String username){
        if (username.length() < 3 || username.length() > 16){
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char currentChar = username.charAt(i);
            if (!Character.isLetterOrDigit(currentChar) && currentChar != '-' && currentChar != '_'){
                return false;
            }
        }
        return true;

    }
}
