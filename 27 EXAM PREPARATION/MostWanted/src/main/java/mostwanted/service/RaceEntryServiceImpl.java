package mostwanted.service;

import mostwanted.common.Constants;
import mostwanted.domain.dtos.raceentries.RaceEntryRootImportDto;
import mostwanted.domain.entities.Car;
import mostwanted.domain.entities.RaceEntry;
import mostwanted.domain.entities.Racer;
import mostwanted.repository.CarRepository;
import mostwanted.repository.RaceEntryRepository;
import mostwanted.repository.RacerRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import mostwanted.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Service
public class RaceEntryServiceImpl implements RaceEntryService {

    private final static String RACE_ENTRIES_XML_FILE_PATH = System.getProperty("user.dir") +
            "/src/main/resources/files/race-entries.xml";

    private final RaceEntryRepository raceEntryRepository;
    private final RacerRepository racerRepository;
    private final CarRepository carRepository;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public RaceEntryServiceImpl(RaceEntryRepository raceEntryRepository, RacerRepository racerRepository, CarRepository carRepository, FileUtil fileUtil, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.raceEntryRepository = raceEntryRepository;
        this.racerRepository = racerRepository;
        this.carRepository = carRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean raceEntriesAreImported() {
        return raceEntryRepository.count() > 0;
    }

    @Override
    public String readRaceEntriesXmlFile() throws IOException {
        return fileUtil.readFile(RACE_ENTRIES_XML_FILE_PATH);
    }

    @Override
    public String importRaceEntries() throws JAXBException {
        StringBuilder importResult = new StringBuilder();

        RaceEntryRootImportDto raceEntryRootImportDto =
                this.xmlParser.parseXml(RaceEntryRootImportDto.class, RACE_ENTRIES_XML_FILE_PATH);

        Arrays
                .stream(raceEntryRootImportDto.getRaceEntryImportDtos())
                .forEach(raceEntryImportDto -> {
                    // TYK STE PRAVIME VALIDACII ZA KOLATA I ZA RACER-A DALI SA VALIDNI
                    Racer racerEntity = this.racerRepository.findByName(raceEntryImportDto.getRacer()).orElse(null);
                    Car carEntity = this.carRepository.findById(raceEntryImportDto.getCarId()).orElse(null);

                    if (racerEntity == null || carEntity == null) {
                        importResult.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                        return;
                    }
                    // AKO GORNITE DVE NE6TA SA VALIDNI TRQBVA DA SI NAMAPIME DTO-TO KAM ENTITY

                    RaceEntry raceEntryEntity = this.modelMapper.map(raceEntryImportDto, RaceEntry.class);
                    // TYK V VATRESNOTO DTO AVTOMATICNO STE NI SE NAMAPQT PARVITE DVE POLETA ==>>
                    // HASFINISHED I FINISHTIME A DOLNITE DVE SI GI NAMAPVAME RACNO... NE CNE NEMOJE I TQX RACNO MAI!!!

                    raceEntryEntity.setRacer(racerEntity);
                    raceEntryEntity.setCar(carEntity);
                    raceEntryEntity.setRace(null);

                    raceEntryEntity = this.raceEntryRepository.saveAndFlush(raceEntryEntity);
                    /**
                     * SLED TOVA SI IMPORTVAME SAOBSHTENIQTA
                     * KATO FORMATA V KOITO GO ISKAT E:
                     * “Successfully imported {entityClass} – {entityField}.”.
                     * •	For Race, RaceEntry – {id};
                     * kato id-to ste go vzememe s ==>> metoda SaveAndFlush ni vrashta entity i sledovatelno
                     * ste promenime slednoto ==> this.raceEntryRepository.saveAndFlush(raceEntryEntity)  NA
                     *  raceEntryEntity = this.raceEntryRepository.saveAndFlush(raceEntryEntity)
                     *  i potozi nachin vednaga sled kato ni go saveAndFlush-ne ste ni varne entity koeto si imam ve4e ID
                     */

                    importResult
                            .append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                                    raceEntryEntity.getClass().getSimpleName(),
                                    raceEntryEntity.getId()))
                            .append(System.lineSeparator());
                });

        return importResult.toString().trim();
    }
}
