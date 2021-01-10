import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next();
        String secondWord = scanner.next();

        int sum = sumCharsOfString(firstWord, secondWord);
        System.out.println(sum);
    }
    //Other solution could be to make a for loop with Math.min(firstWord.length, secondWord.length)
    //sum the multiplied value until the smaller word length still has a character
    //then compare the length of the two words
    //if the first word is longer, then start a for loop,
    //starting at the smaller word length to the end of the longer
    private static int sumCharsOfString(String firstWord, String secondWord) {
        int sum = 0;
        int index = 0;
        while (firstWord.length() > index || secondWord.length() > index){
            int firstWordValue;
            int secondWordValue;
            if (firstWord.length() > index) {
                firstWordValue = firstWord.charAt(index);
            }else {
                firstWordValue = 1;
            }
            if (secondWord.length() > index) {
                secondWordValue = secondWord.charAt(index);
            }else {
                secondWordValue = 1;
            }
            sum += firstWordValue * secondWordValue;
            index++;
        }
        return sum;
    }
}
