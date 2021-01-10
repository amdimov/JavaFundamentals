import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfStudents = Integer.parseInt(scanner.nextLine());
        int numOfLectures = Integer.parseInt(scanner.nextLine());
        double additionalBonus = Integer.parseInt(scanner.nextLine());

        int studentAttendance;
        double currentStudentScore = 0;

        double bestStudentBonus = 0.0;
        int bestStudentAttendance = 0;
        for (int i = 0; i < numOfStudents; i++) {
            studentAttendance = Integer.parseInt(scanner.nextLine());
            currentStudentScore = ((double)studentAttendance/numOfLectures) * (5+additionalBonus);
            if (studentAttendance > bestStudentAttendance && currentStudentScore > bestStudentBonus){
                bestStudentAttendance = studentAttendance;
                bestStudentBonus = currentStudentScore;
            }
        }
        System.out.printf("Max Bonus: %.0f.", bestStudentBonus);
        System.out.println();
        System.out.printf("The student has attended %d lectures.", bestStudentAttendance);
    }
}
