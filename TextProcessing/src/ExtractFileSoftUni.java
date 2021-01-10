import java.util.Date;
import java.util.Scanner;

public class ExtractFileSoftUni {
    public static void main(String[] args) {
        Date timeStart = new Date();
        long start = timeStart.getTime();

        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        String file = path.substring(path.lastIndexOf('\\')+1);
        String fileName = file.substring(0, file.lastIndexOf('.'));
        String fileExtension = file.substring(file.lastIndexOf('.')+1);
        //System.out.println(file);
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " +fileExtension);

        Date timeEnd = new Date();
        long end = timeEnd.getTime();

        System.out.println(end - start);


    }
}
