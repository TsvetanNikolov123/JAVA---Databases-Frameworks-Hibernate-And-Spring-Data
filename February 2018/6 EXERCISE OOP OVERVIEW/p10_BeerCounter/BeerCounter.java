package p10_BeerCounter;

public class BeerCounter {
    public static int beerInStock;
    public static int beerDrankCount;

    public static void buyBeer(int bottlesCount) {
        BeerCounter.beerInStock += bottlesCount;
    }

    public static void drinkBeer(int bottlessCount) {
        BeerCounter.beerDrankCount += bottlessCount;
        BeerCounter.beerInStock -= bottlessCount;
    }
}
