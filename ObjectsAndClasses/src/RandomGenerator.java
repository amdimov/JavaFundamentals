import java.util.Random;
import java.util.Scanner;

public class RandomGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = "Java C# PHP".split("\\s+");

        Random randomGenerator = new Random();

        for (int i = 0; i < words.length; i++) {
            int x = randomGenerator.nextInt(words.length);
            int y = randomGenerator.nextInt(words.length);
            String oldWord = words[x];
            words[x] = words[y];
            words[y] = oldWord;
        }
        System.out.println(String.join(System.lineSeparator(), words));

    }
}
