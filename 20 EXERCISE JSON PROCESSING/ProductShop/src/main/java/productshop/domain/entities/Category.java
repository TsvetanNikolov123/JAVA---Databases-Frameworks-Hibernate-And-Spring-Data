package productshop.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "categories")
public class Category extends BaseEntity {

    private String name;
    private List<Product> products;

    public Category() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(targetEntity = Product.class, mappedBy = "categories")
//    @JoinTable(
//            name = "category_products",
//            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
//    )
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
