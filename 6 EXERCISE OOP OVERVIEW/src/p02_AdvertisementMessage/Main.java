package p02_AdvertisementMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phrases = {
                "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."
        };

        String[] events = {
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"
        };

        String[] authors = {
                "Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva"
        };

        String[] cities = {
                "Burgas",
                "Sofia",
                "Plovdiv",
                "Varna",
                "Ruse"
        };

        Random rnd = new Random();

        int phraseIndex = rnd.nextInt(phrases.length);
        int eventIndex = rnd.nextInt(events.length);
        int authorIndex = rnd.nextInt(authors.length);
        int cityIndex = rnd.nextInt(cities.length);


        System.out.printf("%s %s %s - %s",
                phrases[phraseIndex],
                events[eventIndex],
                authors[authorIndex],
                cities[cityIndex]);
    }
}
