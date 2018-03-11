package p06_ShoppingSpree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));) {

            Map<String, Product> priceList = new HashMap<>();
            Map<String, Person> personList = new LinkedHashMap<>();
            String[] firstLine = reader.readLine().trim().split(";");
            for (String tokens : firstLine) {
                String[] people = tokens.split("=");
                String name = people[0];
                double money = Double.valueOf(people[1]);
                Person person = new Person(name, money);
                personList.put(name, person);
            }
            String[] secondLine = reader.readLine().trim().split(";");
            for (String tokens : secondLine) {
                String[] products = tokens.split("=");
                String name = products[0];
                double cost = Double.valueOf(products[1]);
                Product product = new Product(name, cost);
                priceList.put(name, product);
            }
            String input = reader.readLine();
            while (!input.equals("END")) {
                String[] params = input.split("\\s+");
                String personName = params[0];
                String productName = params[1];
                personList.get(personName).broughtProduct(
                        priceList.get(productName));
                input = reader.readLine();
            }

            for (String person : personList.keySet()) {
                System.out.println(personList.get(person));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}

