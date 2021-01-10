import javax.swing.*;
        import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double input;
        double studentsPerHour = 0;
        double hours = 0;
        for (int i = 0; i < 3; i++) {
            input = Double.parseDouble(scanner.nextLine());
            studentsPerHour+=input;
        }
        int studentsToAnswer = Integer.parseInt(scanner.nextLine());
        double answeredStudents = 0;

        while (answeredStudents < studentsToAnswer){
            answeredStudents += studentsPerHour ;
            hours++;
            if (hours % 4 == 0){
                hours++;
            }
        }
        System.out.printf("Time needed: %.0fh.", hours);
    }
}
