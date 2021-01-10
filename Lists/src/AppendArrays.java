import jdk.nashorn.api.tree.RegExpLiteralTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] inputArray = scanner.nextLine().toCharArray();
        List<Character> inputToList = new ArrayList<>();
        List<Character> resultList = new ArrayList<>();
        List<Character> holderList = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (!(inputArray[i] == ' ')){
                inputToList.add(inputArray[i]);
            }
        }
        int checkFirst = 0;
        for (int i = inputToList.size()-1; i >= 0; i--) {

            while (inputToList.contains('|')){
                int zeroOfArray = inputToList.indexOf(i);
                int j = 0;
                int endOfArray;
                int holder = 0;
                if (checkFirst == 0){
                    endOfArray = inputToList.size()-1;
                    checkFirst++;
                }else {
                    endOfArray = inputToList.indexOf(holder);
                }
//                while (j <= inputToList.size()-1 || inputToList.get(j) == '|'){
//                    resultList.add(inputToList.get(j));
//                    j++;
//                }
                for (int k = zeroOfArray; k < endOfArray; k++) {
                    if (k == endOfArray-1){
                        holder = k+1;
                    }
                    resultList.add(inputToList.get(j));
                    j++;
                }
            }
        }
//        int j = 0;
//        for (int i = inputToList.size()-1; i >= 0; i--) {
//            while (inputToList.get(i) != '|') {
//                resultList.add(j, inputToList.get(i));
//                j++;
//            }
//        }


        for (char n :
                resultList) {
            System.out.print(n + " ");
        }

    }
}
