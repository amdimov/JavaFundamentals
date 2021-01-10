import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2 {
    static class NewArticle{
        String title;
        String content;
        String author;

        NewArticle(String title, String content, String author){
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String editContent(String newContent){
            return this.content = newContent;
        }
        public String changeAuthor(String newAuthor){
            return this.author = newAuthor;
        }
        public String renameTitle(String newTitle){
            return this.title = newTitle;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }


        @Override
        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<NewArticle> articlesList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            NewArticle article = new NewArticle(title, content, author);
            articlesList.add(article);
        }
        String sortedCriteria = scanner.nextLine();

        if (sortedCriteria.equals("author")) {
            articlesList.stream()
                    .sorted((object1, object2) -> object1.getAuthor().compareTo(object2.getAuthor()))
                    .forEach(e -> System.out.printf("%s - %s: %s%n", e.getTitle(), e.getContent(), e.getAuthor()));
        }else if(sortedCriteria.equals("content")){
            articlesList.stream()
                    .sorted((object1, object2) -> object1.getContent().compareTo(object2.getContent()))
                    .forEach(e -> System.out.printf("%s - %s: %s%n", e.getTitle(), e.getContent(), e.getAuthor()));
        }else{
            articlesList.stream()
                    .sorted((object1, object2) -> object1.getTitle().compareTo(object2.getTitle()))
                    .forEach(e -> System.out.printf("%s - %s: %s%n", e.getTitle(), e.getContent(), e.getAuthor()));
        }


    }
}
