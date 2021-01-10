import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        String fileName = "no file name";
        String fileExtension = "no extension found";
        StringBuilder words = new StringBuilder();

        for (int i = path.length()-1; i >= 0; i--) {
            char currentChar = path.charAt(i);
            if (currentChar == '.'){
                fileExtension = words.reverse().toString();
                words = new StringBuilder();
                continue;
            }
            if (currentChar == '\\'){
                fileName = words.reverse().toString();
                break;
            }
            words.append(currentChar);
        }
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);
    }
}
