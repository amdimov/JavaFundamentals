import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        // Collections.sort(arraylist, Collections.reverseOrder()); //TODO Sort in descending order
        Scanner scanner = new Scanner(System.in);
        double averageValue;
        double sum = 0;
        List<Integer> inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> topNumbers = new ArrayList<>();
        for (int n :
                inputNumbers) {
            sum+=n;
        }
        averageValue = sum/inputNumbers.size();

        int j = 0;
        for (int i = 0; i < inputNumbers.size(); i++) {
            if (inputNumbers.get(i) > averageValue){
                topNumbers.add(j, inputNumbers.get(i));
                j++;
            }
        }
        //TODO find top 5 numbers from topNumbers
        Collections.sort(topNumbers, Collections.reverseOrder());
        for (int i = topNumbers.size()-1; i >= 0; i--) {
            if (i > 4){
                topNumbers.remove(i);
            }
        }

        if (topNumbers.size() != 0) {
            for (int n :
                    topNumbers) {
                System.out.print(n + " ");
            }
        }else {
            System.out.println("No");
        }
//        System.out.println();
//        System.out.println(averageValue);

    }
}
