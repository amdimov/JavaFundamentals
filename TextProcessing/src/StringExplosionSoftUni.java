import java.util.Scanner;

public class StringExplosionSoftUni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder("abv>1>1>2>2asdasd");
        int strength = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '>'){
                strength += Character.getNumericValue(input.charAt(i +1));
            }else if(strength > 0 && input.charAt(i) != '>'){
                input.deleteCharAt(i);
                strength--;
                i--;
            }
        }
        System.out.println(input);
    }
}
