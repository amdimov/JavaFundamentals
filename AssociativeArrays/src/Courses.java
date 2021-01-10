import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" : ");
        Map<String, List<String>> coursesMap = new LinkedHashMap<>();

        while (!input[0].equals("end")){
            //TODO
            String course = input[0];
            String studentsName = input[1];
            List<String> students = coursesMap.get(course);
            if (students == null){
                students = new ArrayList<>();
                coursesMap.put(course, students);
            }
            students.add(studentsName);
            input = scanner.nextLine().split(" : ");
        }

        coursesMap.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(e ->{
                  System.out.println(e.getKey() + ": " + e.getValue().size());
                  e.getValue()
                          .stream()
                          .sorted((a, b) -> a.compareTo(b))
                          .forEach(c -> System.out.println("-- " + c));
                });
                //.forEach(e -> System.out.println(e.getKey() + " -> " + String.join(", ", e.getValue())));


    }
}
