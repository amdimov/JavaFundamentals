import java.awt.image.ImageFilter;
import java.util.*;

public class ArraysPlay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> covidMap = new TreeMap<>();

//        String[] input = scanner.nextLine().split("\\s+");
//
//        while (!input[0].equals("end")) {
//            int newValue = Integer.parseInt(input[1]);
//            Integer currentValue = covidMap.get(input[0]);
//            if (currentValue == null){
//                currentValue = 0;
//            }
//            covidMap.put(input[0], newValue + currentValue);
//            input = scanner.nextLine().split("\\s+");
//        }
//        covidMap.put("Bestt", 23);
//        System.out.println(covidMap.get("Best"));
//
//        for (Map.Entry<String, Integer> entry:
//             covidMap.entrySet()) {
//            System.out.println(entry.getKey() + "-->" + entry.getValue());
//        }

        System.out.println("------");
//        String[] input = scanner.nextLine().split("\\s++");
////        int sumItems = 0;
////        for (int i = 0; i < input.length; i++) {
////            if (i % 2 == 0){
////                System.out.println(Integer.parseInt(input[i]));
////                sumItems += Integer.parseInt(input[i]);
////            }else {
////                System.out.println(input[i]);
////            }
////        }
////
////        System.out.println("Sum: " + sumItems);

        Map<String, List<String>> testMapList = new HashMap<>();
        List<String> words = new ArrayList<>();
        words.add("firstListValue");
        testMapList.put("firstList", words);
        words.add("secondListValue");
        testMapList.put("secondList", words);

        for (Map.Entry<String, List<String>> n :
                testMapList.entrySet()) {
            System.out.println(n.getKey() + " -> " + n.getValue());
        }



    }
}
