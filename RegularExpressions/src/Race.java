import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexExtractName = "[A-Za-z]+";
        String regexExtractPoints = "\\d";
        String[] names = scanner.nextLine().split("\\, ");
        String text = scanner.nextLine();
        Pattern patternName = Pattern.compile(regexExtractName);
        Matcher matcherName = patternName.matcher(text);
        Pattern patternPoints = Pattern.compile(regexExtractPoints);
        Matcher matcherPoints = patternPoints.matcher(text);
        Map<String, Integer> racersMap = new LinkedHashMap<>();
        int points = 0;
        for (String n : names) {
            racersMap.put(n, points);
        }
        StringBuilder word = new StringBuilder();
        while (!text.equals("end of race")) {
            while (matcherName.find()) {
                word.append(matcherName.group());
            }
            while (matcherPoints.find()) {
                points += Integer.parseInt(matcherPoints.group());
            }
            Integer namePoints = racersMap.get(word.toString());
            int newPoints = points;
            if (namePoints != null) {
                racersMap.put(word.toString(), namePoints + newPoints);
            }
            text = scanner.nextLine();
            matcherName = patternName.matcher(text);
            matcherPoints = patternPoints.matcher(text);
            points = 0;
            word = new StringBuilder();
        }

        List<String> winnersList =
                racersMap.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .limit(3)
                        .map(Map.Entry::getKey)
                .collect(Collectors.toList());
       int i = 0;
        for (String winners :
             winnersList) {
            if (i == 0){
                System.out.println("1st place: " + winners);
            }else if(i == 1){
                System.out.println("2nd place: " + winners);
            }else {
                System.out.println("3rd place: " + winners);
            }
            i++;
        }
    }
}
