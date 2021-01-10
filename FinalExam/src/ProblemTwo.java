import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String passwordUsernameRegex = "^(U\\${1})(?<username>[A-Z][a-z]{2,})\\1(P@\\${1})(?<password>[a-zA-Z]{5,}[0-9]+)\\3$";
        Pattern passwordPattern = Pattern.compile(passwordUsernameRegex);

        int n = Integer.parseInt(scanner.nextLine());
        int successCounter = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = passwordPattern.matcher(input);
            if (matcher.find()){
                System.out.println("Registration was successful");
                System.out.println("Username: " + matcher.group("username") + ", " + "Password: " + matcher.group("password"));
                successCounter++;
            }else{
                System.out.println("Invalid username or password");
            }
        }

        System.out.println("Successful registrations: " + successCounter);


    }
}
