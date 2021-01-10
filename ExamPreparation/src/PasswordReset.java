import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();


        while (!input.equals("Done")){
            String[] inputSplit = input.split("\\s+");
            String command = inputSplit[0];

            switch (command){
                case "TakeOdd":
                    for (int i = password.length()-1; i >= 0; i--) {
                        if (i % 2 == 0){
                            password.deleteCharAt(i);
                        }
                    }
                    System.out.println(password);
                    break;
                case "Cut":
                    int indexStart = Integer.parseInt(inputSplit[1]);
                    int lengthOfCut = Integer.parseInt(inputSplit[2]);

                    String subPassword = password.substring(indexStart, indexStart+lengthOfCut);
                    //TODO@Keep in mind that operation in case there is no need of substring validation
                    if (password.toString().contains(subPassword)){
                        password = new StringBuilder(password.toString().replaceFirst(subPassword, ""));
                        System.out.println(password);
                    }
                    break;
                case "Substitute":
                    String substring = inputSplit[1];
                    String newSubToReplace = inputSplit[2];

                    if (password.toString().contains(substring)){
                        password = new StringBuilder(password.toString().replaceAll(substring, newSubToReplace));
                        System.out.println(password);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("Your password is: " + password);
    }
}
