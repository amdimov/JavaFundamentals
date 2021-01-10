import java.util.Scanner;

public class ArrivingInKathmandu {
    //https://judge.softuni.bg/Contests/Practice/Index/1516#0
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //TODO - change to System Scanner
        String inputNote = scanner.nextLine();
        char[] inputToCharArr = inputNote.toCharArray();
        boolean isItFound = false;
        String coordinates = "";
        while (!inputNote.equals("Last note")){
            if(validatePeakCode(inputToCharArr) && validateAndGetCodeNum(inputToCharArr) != -1){
               coordinates = getGeoHashCode(inputToCharArr);
               System.out.printf("Coordinates found! %s -> %s", extractPeakName(inputToCharArr), coordinates);
            }else {
                System.out.println("Nothing found!");
            }

            inputNote = scanner.nextLine();
            inputToCharArr = inputNote.toCharArray();
        }

//        String tests = String.valueOf(inputToCharArr);
//        System.out.println(tests);
//        System.out.println(tests.indexOf('x'));
        //        System.out.println(validatePeakCode(inputToCharArr));
//        System.out.println(validateAndGetCodeNum(inputToCharArr));
    }

    public static String getGeoHashCode(char[] charArray){
        String charArrayInString = String.valueOf(charArray);
        int indexOfBreakPoint = charArrayInString.indexOf('<');
        boolean valid = charArray[indexOfBreakPoint+1] == '<' && indexOfBreakPoint!= -1;
        String result = "";
        if (!valid){
            return result;
        }else {
            for (int i = indexOfBreakPoint + 2; i < charArray.length; i++) {
                result+=charArray[i];
            }
        }
        return result;
    }

    public static int validateAndGetCodeNum(char[] charArray){
        String number = "";
        String charArrayToString = String.valueOf(charArray);
        int indexStart = charArrayToString.indexOf('=');
        int indexEnd = charArrayToString.indexOf('<');
        int result = -1;
        if (indexStart == -1 || indexEnd == -1){
            return result;
        }else {
            for (int i = indexStart+1; i < indexEnd; i++) {
                if (charArray[i] < 48 || charArray[i] > 57){
                    return result;
                }else {
                    String currentValue = String.valueOf(charArray[i]);
                    number+=currentValue;
                }
            }
            result = Integer.parseInt(number);
            return result;
        }
    }

    public static boolean validatePeakCode(char[] charArray){
        boolean isItValid = true;
        String peakCode = "";

        for (int i = 0; i < charArray.length; i++) {
            if (i == charArray.length-1){
                return isItValid = false;
            }
            if (charArray[i] != '=') {
                peakCode += charArray[i];
            }else{
                break;
            }
        }
        if (peakCode.length() == 0){
            isItValid = false;
            return isItValid;
        }
        char currentChar;
        for (int i = 0; i < peakCode.length(); i++) {
            currentChar = peakCode.charAt(i);
            if (currentChar == '!' || currentChar == '@' || currentChar == '#'
                    || currentChar == '?' || currentChar == '$' || (currentChar >= 65 && currentChar <= 90)
                    || (currentChar >= 97 && currentChar <= 122)){
                isItValid = true;
            }else {
                isItValid = false;
                break;
            }
        }
        return isItValid;
    }
    //TODO
    public static String extractPeakName(char[] charArray){
        String peak = "";
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '=' || charArray[i] == '<') {
                break;
            }else {
                if ((charArray[i] >= 65 && charArray[i] <= 90)
                        || (charArray[i] >= 97 && charArray[i] <= 122))
                peak += String.valueOf(charArray[i]);
            }
        }
        return peak;
    }


}
