import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(vowelCounter(input));
    }

    public static int vowelCounter(String word){
        word = word.toLowerCase();
        int vowels = 0;
        for (int i = 0; i < word.length(); i++) {
            if (checkCharForVowel(word.charAt(i))){
                vowels++;
            }
        }
        return vowels;
    }

    public static boolean checkCharForVowel(char charToCheck){
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == charToCheck){
                return true;
            }
        }
        return false;
    }
}



