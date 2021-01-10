import java.util.Scanner;
import java.util.stream.Stream;

public class Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder string = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Finish")){
            String[] inputSplit = input.split("\\s+");
            String command = inputSplit[0];

            switch (command){
                case "Replace":
                    String currentChar = inputSplit[1];
                    String newChar = inputSplit[2];

                    string = new StringBuilder(string.toString().replaceAll(currentChar, newChar));
                    System.out.println(string);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(inputSplit[1]);
                    int endIndex = Integer.parseInt(inputSplit[2]);

                    if (startIndex >= 0 && startIndex < string.length()
                            && endIndex >= 0 && endIndex < string.length()){
                        string.delete(startIndex, endIndex + 1);
                        System.out.println(string);
                    }else{
                        System.out.println("Invalid indices!");
                    }
                    break;
                case "Make":
                    String upperOrLower = inputSplit[1];

                    if (upperOrLower.equals("Upper")){
                        string = new StringBuilder(string.toString().toUpperCase());
                    }else if(upperOrLower.equals("Lower")){
                        string = new StringBuilder(string.toString().toLowerCase());
                    }
                    System.out.println(string);
                    break;
                case "Check":
                    String checkingString = inputSplit[1];
                    if (string.toString().contains(checkingString)){
                        System.out.println("Message contains " + checkingString);
                    }else {
                        System.out.println("Message doesn't contain " + checkingString);
                    }
                    break;
                case "Sum":
                    int sumStartIndex = Integer.parseInt(inputSplit[1]);
                    int sumEndIndex = Integer.parseInt(inputSplit[2]);
                    if (sumStartIndex >= 0 && sumStartIndex < string.length()
                            && sumEndIndex >= 0 && sumEndIndex < string.length()){
                        String substring = string.substring(sumStartIndex, sumEndIndex+1);
                        int asciiSum = 0;

                        for (int i = 0; i < substring.length(); i++) {
                            asciiSum += substring.charAt(i);
                        }
                        System.out.println(asciiSum);
                    }else {
                        System.out.println("Invalid indices!");
                    }


            }

            input = scanner.nextLine();
        }
    }
}
