package hiberspring.domain.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotNull;

public class EmployeeCardImportDto {

    @Expose
    private String number;

    public EmployeeCardImportDto() {
    }

    @NotNull
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
