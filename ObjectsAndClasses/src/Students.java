import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class StudentsData{
        String firstName;
        String secondName;
        double grade;

        StudentsData(String firstName, String secondName, double grade){
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public double getGrade() {
            return grade;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StudentsData> studentsDataList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            StudentsData students = new StudentsData(input[0], input[1], Double.parseDouble(input[2]));
            studentsDataList.add(students);
        }

        studentsDataList.stream().sorted(Comparator.comparingDouble(StudentsData::getGrade).reversed())
                .forEach(e -> System.out.printf("%s %s: %.2f%n", e.getFirstName(), e.getSecondName(), e.getGrade()));

    }
}
