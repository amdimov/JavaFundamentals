import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            List<Double> listOfGrades = studentsMap.get(name);
                if (listOfGrades == null){
                    listOfGrades = new ArrayList<>();
                    studentsMap.put(name, listOfGrades);
                }
            listOfGrades.add(grade);
        }
        Map<String, Double> avarageGrades = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> b :
             studentsMap.entrySet()) {
            String currentName = b.getKey();
            double avarageGrade = 0.0;
            double sum = 0.0;
            for (int i = 0; i < b.getValue().size(); i++) {
                sum+= b.getValue().get(i);
            }
            avarageGrade = sum / b.getValue().size();
            avarageGrades.put(currentName, avarageGrade);
            sum = 0.0;
            avarageGrade = 0.0;
        }

        avarageGrades.entrySet().stream().filter(e -> e.getValue() >= 4.50)
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));

    }
}
