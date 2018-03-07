package p06_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> shoppingBag;

    public Person(String name, double money) {
        if (name.isEmpty() || name.contains("\\W+")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.name = name;
        this.money = money;
        this.shoppingBag = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getShoppingBag() {
        return shoppingBag;
    }

    public void broughtProduct(Product product) {
        if (product.getCoast() > this.money) {
            System.out.printf("%s can't afford %s%n", this.name, product.getName());
        } else {
            shoppingBag.add(product);
            this.money -= product.getCoast();
            System.out.printf("%s bought %s%n", this.name, product.getName());
        }
    }

    @Override
    public String toString() {
        if (shoppingBag.size() > 0) {
            StringBuilder sb = new StringBuilder(shoppingBag.toString());
            return String.format("%s - %s", this.name, sb.toString().substring(1, sb.length() - 1));
        } else {
            return String.format("%s - Nothing bought", this.name);
        }

    }
}
