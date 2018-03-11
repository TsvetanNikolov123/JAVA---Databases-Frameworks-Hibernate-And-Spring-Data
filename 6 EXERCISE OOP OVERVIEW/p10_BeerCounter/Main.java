package p10_BeerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        try {
            String line;
            while (!"End".equals(line = reader.readLine())) {
                int[] bottles = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();

                BeerCounter.buyBeer(bottles[0]);
                BeerCounter.drinkBeer(bottles[1]);
            }
        } catch (Exception _ignored) {

        } finally {
            System.out.println(String.format("%d %d", BeerCounter.beerInStock, BeerCounter.beerDrankCount));
        }

    }
}
