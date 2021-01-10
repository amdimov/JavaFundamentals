import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        Map<String, Integer> emojiMap = new LinkedHashMap<>();
        long coolNumber = 1;
        //Regex101 - https://regex101.com/r/9XVrh4/2
        String emojiRegex = "([\\:\\:]{2}|[\\*\\*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        //TODO
        Pattern coolThresholdEngine = Pattern.compile("\\d");
        Matcher digitsMatcher = coolThresholdEngine.matcher(inputText);

        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Matcher emojiMatcher = emojiPattern.matcher(inputText);

        while (emojiMatcher.find()){
            String currentEmoji = emojiMatcher.group().trim();
            Integer getValue = emojiMap.get(currentEmoji);
            int charValue = 0;
            if (getValue == null){
                for (int i = 0; i < currentEmoji.length(); i++) {
                    if (currentEmoji.charAt(i) != '*' && currentEmoji.charAt(i) != ':') {
                        charValue += currentEmoji.charAt(i);
                    }
                }
                getValue = 0;
            }
            emojiMap.put(currentEmoji, charValue + getValue);
        }
        while (digitsMatcher.find()){
            coolNumber *= Integer.parseInt(digitsMatcher.group());
        }
        System.out.println("Cool threshold: " + coolNumber);
        System.out.println(emojiMap.size() + " emojis found in the text. The cool ones are:");
        long finalCoolNumber = coolNumber;
        emojiMap.entrySet().stream().filter(e -> e.getValue() >= finalCoolNumber)
                .forEach(e -> System.out.println(e.getKey()));


        //emojiList.stream().forEach(System.out::println);

    }
}
