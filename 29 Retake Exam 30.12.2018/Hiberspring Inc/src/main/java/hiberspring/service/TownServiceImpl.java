package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.TownImportDto;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;


    @Autowired
    public TownServiceImpl(TownRepository townRepository, FileUtil fileUtil, Gson gson, ValidationUtil validator, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return this.fileUtil.readFile(Constants.PATH_TO_FILES + "towns.json");
    }

    @Override
    public String importTowns(String townsFileContent) {

        StringBuilder importResult = new StringBuilder();
        TownImportDto[] townImportDtos = this.gson.fromJson(townsFileContent, TownImportDto[].class);

        Arrays.stream(townImportDtos).forEach(townImportDto -> {
            if (!validator.isValid(townImportDto)) {
                importResult
                        .append(Constants.INCORRECT_DATA_MESSAGE)
                        .append(System.lineSeparator());
                return;
            }

            Town town = modelMapper.map(townImportDto, Town.class);
            this.townRepository.save(town);

            importResult
                    .append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                            town.getClass().getSimpleName(),
                            townImportDto.getName()))
                    .append(System.lineSeparator());
        });

        return importResult.toString().trim();
    }
}
