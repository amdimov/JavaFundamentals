import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        passwordValidation(test);
    }

    public static void passwordValidation(String password){
        boolean validated = true;
        if (!passwordLength(password)){
            System.out.println("Password must be between 6 and 10 characters");
            validated = false;
        }
        if(!checkForLettersAndDigits(password)){
            System.out.println("Password must consist only of letters and digits");
            validated = false;
        }
        if(!checkForTwoDigits(password)){
            System.out.println("Password must have at least 2 digits");
            validated = false;
        }
        if(validated){
            System.out.println("Password is valid");
        }

    }
    public static boolean passwordLength(String password){
        return password.length() >= 6 && password.length() <= 10;
    }

    private static boolean checkForLettersAndDigits(String password){
        int charValue;
        boolean isLetterOrDigit = true;
        for (int i = 0; i < password.length(); i++) {
            charValue = (int) password.charAt(i);
            if (!(charValue >= 97 && charValue <= 172 || charValue >= 65 && charValue <= 90 || charValue >= 48 && charValue <=57)){
                isLetterOrDigit = false;
            }
        }
        return isLetterOrDigit;
    }

    private static boolean checkForTwoDigits(String password){
        int countDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            if ((int)password.charAt(i) >= 48 && (int)password.charAt(i) <= 57){
                countDigits++;
            }
        }
        if (countDigits >= 2){
            return true;
        }
        return false;
    }

}
