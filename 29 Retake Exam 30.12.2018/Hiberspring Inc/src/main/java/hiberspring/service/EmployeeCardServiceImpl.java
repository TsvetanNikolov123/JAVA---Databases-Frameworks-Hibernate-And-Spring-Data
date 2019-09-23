package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.EmployeeCardImportDto;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private final EmployeeCardRepository employeeCardRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, FileUtil fileUtil, Gson gson, ValidationUtil validator, ModelMapper modelMapper) {
        this.employeeCardRepository = employeeCardRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return this.fileUtil.readFile(Constants.PATH_TO_FILES + "employee-cards.json");
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) {

        StringBuilder importResult = new StringBuilder();
        EmployeeCardImportDto[] employeeCardImportDtos =
                this.gson.fromJson(employeeCardsFileContent, EmployeeCardImportDto[].class);

        Arrays.stream(employeeCardImportDtos).forEach(employeeCardImportDto -> {
            if (!validator.isValid(employeeCardImportDto)) {
                importResult
                        .append(Constants.INCORRECT_DATA_MESSAGE)
                        .append(System.lineSeparator());
                return;
            }

            EmployeeCard employeeCardExist =
                    this.employeeCardRepository.findByNumber(employeeCardImportDto.getNumber()).orElse(null);
            if (employeeCardExist != null) {
                importResult
                        .append(Constants.INCORRECT_DATA_MESSAGE)
                        .append(System.lineSeparator());
                return;
            }

            EmployeeCard employeeCard = modelMapper.map(employeeCardImportDto, EmployeeCard.class);
            this.employeeCardRepository.save(employeeCard);

            importResult
                    .append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                            "Employee Card",
//                            employeeCard.getClass().getSimpleName(),
                            employeeCardImportDto.getNumber()))
                    .append(System.lineSeparator());
        });

        return importResult.toString().trim();
    }
}
