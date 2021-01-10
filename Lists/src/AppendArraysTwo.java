import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AppendArraysTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] inputArray = scanner.nextLine().toCharArray();
        List<Character> inputToList = new ArrayList<>();
        List<Character> resultToList = new ArrayList<>();

        for (int i = 0; i < inputArray.length; i++) {
            if (!(inputArray[i] == ' ')){
                if(inputArray[i+1] != ' ') {
                    inputToList.add(inputArray[i]);
                }else {
                    inputToList.add(inputArray[i]);
                    inputToList.add(inputArray[i+1]);
                    i++;
                }
            }
        }
        for (int i = 0; i < inputToList.size(); i++) {
            if (inputToList.get(i) == ' '){
                inputToList.remove(i);
            }
        }

//        for (char n :
//                inputToList) {
//            System.out.print(n);
//        }
//        System.out.println();
        for (int i = inputToList.size()-1; i >= 0; i--) {
            int zeroOfArray = 0;
            int boundOfArray = i;
            int resultArrayIndex = 0;
            for (int j = i-1; j >= 0; j--) {
                if (inputToList.get(j) == '|'){
                    zeroOfArray = j;
                    break;
                }
            }
            if (inputToList.get(i) == '|' || i == inputToList.size()-1){

//                System.out.println(zeroOfArray + "-" +boundOfArray);
                for (int j = zeroOfArray; j < boundOfArray+1; j++) {

                    if (inputToList.get(j) != '|')
                    resultToList.add(inputToList.get(j));
                }
            }


        }

//        System.out.println();
        for (char n :
                resultToList) {
            System.out.print(n + " ");
        }

    }
}
