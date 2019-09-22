package productshop.domain.dtos.view;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.Set;

public class UserFirstAndLastNameWithAtLeastOneSaleDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Set<ProductNamePriceAndBuyerFirstLastNameDto> soldProducts;

    public UserFirstAndLastNameWithAtLeastOneSaleDto() {
        this.soldProducts = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductNamePriceAndBuyerFirstLastNameDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductNamePriceAndBuyerFirstLastNameDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
