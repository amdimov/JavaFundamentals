import java.util.*;

public class AdvertisementMessage {
    static class Advertisement{
        List<String> listOfPhrases;
        List<String> listOfEvents;
        List<String> listOfAuthors;
        List<String> listOfCities;

        Advertisement(){
            this.listOfPhrases = addPhrases("Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product.");
            this.listOfEvents = addEvents("Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!");
            this.listOfAuthors = addAuthors("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva");
            this.listOfCities = addCities("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse");
        }

        static List<String> addPhrases(String... phrases){
            return new ArrayList<>(Arrays.asList(phrases));
        }
        static List<String> addEvents(String... events){
            return new ArrayList<>(Arrays.asList(events));
        }
        static List<String> addAuthors(String... authors){
            return new ArrayList<>(Arrays.asList(authors));
        }
        static List<String> addCities(String... cities){
            return new ArrayList<>(Arrays.asList(cities));
        }


        public List<String> getListOfPhrases() {
            return listOfPhrases;
        }

        public List<String> getListOfEvents() {
            return listOfEvents;
        }

        public List<String> getListOfAuthors() {
            return listOfAuthors;
        }

        public List<String> getListOfCities() {
            return listOfCities;
        }


        public String randomize(Random randomIndex){
            int randPhrases = randomIndex.nextInt(getListOfPhrases().size());
            int randEvents = randomIndex.nextInt(getListOfEvents().size());
            int randAuthors = randomIndex.nextInt(getListOfAuthors().size());
            int randCities = randomIndex.nextInt(getListOfCities().size());
            return String.format("%s %s %s – %s.",
                    getListOfPhrases().get(randPhrases),
                    getListOfEvents().get(randEvents), getListOfAuthors().get(randAuthors),
                    getListOfCities().get(randCities));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMessages = Integer.parseInt(scanner.nextLine());
        Advertisement ad = new Advertisement();
        Random randomIndex;
        for (int i = 0; i < numberOfMessages; i++) {
            randomIndex = new Random();
            String result = ad.randomize(randomIndex);
            System.out.println(result);

        }
    }
}
