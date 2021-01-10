import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(getMiddleCharacter(input));

    }
    public static String getMiddleCharacter(String input){
        char result;
        String resultInString;
        if (input.length() % 2 == 1){
            resultInString = Character.toString(input.charAt((input.length()-1)/2));
        }else{
            resultInString = Character.toString(input.charAt((input.length()-1)/2)) + Character.toString(input.charAt((input.length())/2));
        }
        return resultInString;
    }
}
