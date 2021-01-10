import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                Character currentChar = input[i].charAt(j);
                Integer occurance = charCountMap.get(currentChar);
                if (occurance == null){
                    occurance = 0;
                }
                charCountMap.put(currentChar, occurance + 1);
            }
        }

//        for (Map.Entry<Character, Integer> map :
////                charCountMap.entrySet()) {
////            System.out.println(map.getKey() + " -> " + map.getValue());
////        }
        charCountMap.forEach((key, value) -> System.out.println(key + " -> " + value));

    }
}
