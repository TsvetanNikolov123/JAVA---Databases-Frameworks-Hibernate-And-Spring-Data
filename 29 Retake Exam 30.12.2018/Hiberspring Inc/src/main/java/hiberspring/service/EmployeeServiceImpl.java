package hiberspring.service;

import hiberspring.common.Constants;
import hiberspring.domain.dtos.EmployeesRootImportDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.repository.EmployeeRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validator;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final EmployeeCardRepository cardRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, FileUtil fileUtil, ValidationUtil validator, XmlParser xmlParser, ModelMapper modelMapper, EmployeeCardRepository cardRepository, BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.fileUtil = fileUtil;
        this.validator = validator;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.cardRepository = cardRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return this.fileUtil.readFile(Constants.PATH_TO_FILES + "employees.xml");
    }

    @Override
    public String importEmployees() throws JAXBException {
        StringBuilder importResult = new StringBuilder();

        EmployeesRootImportDto employeesRootImportDto =
                this.xmlParser.parseXml(EmployeesRootImportDto.class, Constants.PATH_TO_FILES + "employees.xml");

        Arrays.stream(employeesRootImportDto.getEmployeeImportDtos()).forEach(employeeImportDto -> {
            if (!validator.isValid(employeeImportDto)) {
                importResult
                        .append(Constants.INCORRECT_DATA_MESSAGE)
                        .append(System.lineSeparator());
                return;
            }

            EmployeeCard employeeCard = this.cardRepository.findByNumber(employeeImportDto.getCard()).orElse(null);
            Branch branch = this.branchRepository.findByName(employeeImportDto.getBranch()).orElse(null);
            if (employeeCard == null || branch == null) {
                return;
            }

            Employee employee = this.modelMapper.map(employeeImportDto, Employee.class);
            employee.setCard(employeeCard);
            employee.setBranch(branch);
            this.employeeRepository.save(employee);

            importResult
                    .append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                            employee.getClass().getSimpleName(),
                            employeeImportDto.getFirstName() +
                                    employeeImportDto.getLastName()))
                    .append(System.lineSeparator());
        });

        return importResult.toString().trim();
    }

    @Override
    public String exportProductiveEmployees() {
        return null;
    }
}
