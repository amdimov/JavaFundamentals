import java.util.Scanner;

public class Articles {

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
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(scanner.nextLine());
        String title = input[0];
        String content = input[1];
        String author = input[2];
        NewArticle article = new NewArticle(title, content, author);

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(": ");
            String command = line[0];
            String newText = line[1];
            switch (command) {
                case "Edit":
                    article.editContent(newText);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(newText);
                    break;
                case "Rename":
                    article.renameTitle(newText);
                    break;
            }
        }
        System.out.println(article);


    }
}
