import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayWithText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringInput = new StringBuilder(scanner.nextLine());
        int explosionIndex = -1;
        int explosionPower = 0;
        boolean didHeFound = false;
        while (stringInput.lastIndexOf(">") != explosionIndex) {
            explosionIndex = stringInput.indexOf(">", explosionIndex + 1);
            explosionPower = Integer.parseInt(String.valueOf(stringInput.charAt(explosionIndex + 1)));
            String tempString = stringInput.substring(explosionIndex+1, explosionIndex + explosionPower + 1);
            if (tempString.contains(">")) {
                System.out.println(tempString);
                tempString = stringInput.substring(explosionIndex+1, explosionIndex + explosionPower + 2);
                int innerPower = Character.getNumericValue(tempString.charAt(tempString.indexOf(">") + 1));
                explosionPower += innerPower+1;
            }
            stringInput.replace(explosionIndex + 1, explosionIndex + explosionPower + 1, "");
        }
        System.out.println(stringInput);
    }

}
