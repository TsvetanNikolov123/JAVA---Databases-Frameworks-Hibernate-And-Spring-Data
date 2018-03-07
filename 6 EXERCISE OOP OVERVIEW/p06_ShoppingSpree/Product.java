package p06_ShoppingSpree;

public class Product {

    private String name;
    private double coast;

    public Product(String name, double coast) {
        if (name.isEmpty() || name.contains("\\W+")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (coast < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.name = name;
        this.coast = coast;
    }

    public String getName() {
        return name;
    }

    public double getCoast() {
        return coast;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
