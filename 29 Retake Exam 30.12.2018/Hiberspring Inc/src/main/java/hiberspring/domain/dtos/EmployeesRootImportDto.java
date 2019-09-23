package hiberspring.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesRootImportDto {

    @XmlElement(name = "employee")
    private EmployeeImportDto[] employeeImportDtos;

    public EmployeesRootImportDto() {
    }

    public EmployeeImportDto[] getEmployeeImportDtos() {
        return employeeImportDtos;
    }

    public void setEmployeeImportDtos(EmployeeImportDto[] employeeImportDtos) {
        this.employeeImportDtos = employeeImportDtos;
    }
}
