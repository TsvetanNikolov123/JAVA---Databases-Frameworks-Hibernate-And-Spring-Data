package hiberspring.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductRootImportDto {

    @XmlElement(name = "product")
    private ProductImportDto[] productImportDtos;

    public ProductRootImportDto() {
    }

    public ProductImportDto[] getProductImportDtos() {
        return productImportDtos;
    }

    public void setProductImportDtos(ProductImportDto[] productImportDtos) {
        this.productImportDtos = productImportDtos;
    }
}
