package mostwanted.service;

import mostwanted.common.Constants;
import mostwanted.domain.dtos.races.EntryImportDto;
import mostwanted.domain.dtos.races.RaceImportDto;
import mostwanted.domain.dtos.races.RaceImportRootDto;
import mostwanted.domain.entities.District;
import mostwanted.domain.entities.Race;
import mostwanted.domain.entities.RaceEntry;
import mostwanted.repository.DistrictRepository;
import mostwanted.repository.RaceEntryRepository;
import mostwanted.repository.RaceRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import mostwanted.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {

    private final static String RACES_XML_FILE_PATH = System.getProperty("user.dir") +
            "/src/main/resources/files/races.xml";

    private final RaceRepository raceRepository;
    private final DistrictRepository districtRepository;
    private final RaceEntryRepository raceEntryRepository;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository, DistrictRepository districtRepository, RaceEntryRepository raceEntryRepository, FileUtil fileUtil, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.raceRepository = raceRepository;
        this.districtRepository = districtRepository;
        this.raceEntryRepository = raceEntryRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean racesAreImported() {
        return raceRepository.count() > 0;
    }

    @Override
    public String readRacesXmlFile() throws IOException {
        return fileUtil.readFile(RACES_XML_FILE_PATH);
    }

    @Override
    public String importRaces() throws JAXBException {
        StringBuilder importResult = new StringBuilder();
        // VZEXME SI RaceImportRootDto -> KOETO NI E NAI-VANSHNOTO
        RaceImportRootDto raceImportRootDto = this.xmlParser.parseXml(RaceImportRootDto.class, RACES_XML_FILE_PATH);

        /**
         * tozi cikal ste varti po kolekciqta v nai-vanshnoto DTO
         * parvo ste si proverime za District-a
         */
        for (RaceImportDto raceImportDto : raceImportRootDto.getRaceImportDtos()) {
            //
            District districtEntity = this.districtRepository.findByName(raceImportDto.getDistrict()).orElse(null);

            // parvo ste si proverime za district-a.Ako district-a(kvartala) go ima prodaljavame na doly!
            // ako ne e validen prekratqva tazi iteraciq i otiva na sledva6tata
            if (!this.validationUtil.isValid(raceImportDto) || districtEntity == null) {
                importResult.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }
            // obrashtame si DTO-to kam RaceEntity i my setvame "district"-a koito sme namerili che e validen
            Race race = this.modelMapper.map(raceImportDto, Race.class);
            race.setDistrict(districtEntity);

            // sled tova trqbva da si obxodime ot DTO-to entry-tata -> nali vsqko dto si ima kolekcia ot entryta
            // toest .....

            List<RaceEntry> raceEntries = new ArrayList<>();
            for (EntryImportDto entryImportDto : raceImportDto.getEntryImportRootDto().getEntryImportDtos()) {
                // pri koeto pochvame da gi obxojdame-> tarsime v bazata i ako nqma raceEntry ste stane na null
                RaceEntry raceEntry = this.raceEntryRepository.findById(entryImportDto.getId()).orElse(null);
                // ako gornoto e null ste mine na sledva6tata iteraciq
                if (raceEntry == null) {
                    continue;
                }
                //obache ako go imame na tova entry nie trqbva da setneme Race-a, zas6toto
                // RaceEntry class-a sochi kam Race class-a
                //
                //      @Entity(name = "race_entries")
                //      public class RaceEntry extends BaseEntity {
                //
                //          private Boolean hasFinished;
                //          private Double finishTime;
                //          private Car car;
                //          private Racer racer;
                //          private Race race;  <<<==== eto kade sochi

                // setvame my Race-a i pri tova polojenie sled kato sme setnali Race-a nie tezi entity-ta trqbva
                // da gi pazime nqkade za da moje da gi save-neme sled kato sme save-nali race-a
                // zashtoto pri tova polojenie nie imame edin Race koito e bez ID
                // Pribirame si v edin list <RaceEntry> -> i si gi save-a me na6to entry koeto ve4e ima Race v nego
                // zashtoto tyk nqma Race ===>>> RaceEntry raceEntry = this.raceEntryRepository.findById(entryImportDto.getId()).orElse(null);
                // a go polychava chak eto tyk ==>> raceEntry.setRace(race);
                raceEntry.setRace(race);
                // i za tova go saxranqvame eto tyk
                raceEntries.add(raceEntry);
            }

            // i sled kato sme gi zapazili v list-a entry-tata s race-a trqbva da si Save-neme race-a
            // defacto v gorniq cikal toi si obikalq i si gi naglasq i palni v List-a
            // i kato svarshi s palneneto idvame tyk
            // Obache v list-a Race-a o6te namqt ID i trqbva da go save-neme za da polychi ID
            race = this.raceRepository.saveAndFlush(race);
            // i ve4e nashiq Race e save-nat
            // i pslednoto ne6to koeto trqbva da napravime e da save-neme tiq Entry-ta za6toto nie ne sme gi save-nali
            // a samo sme gi izvadili v gorniq for-cikal i sme gi nabili v list-a
            // sled kato sme gi izvadili -> setnali sme im race-a , sled kato sme save-nali race-a te ve4e si imat race
            // koito si ima ID i prosto trqbva da gi save-neme tiq entity-ta
            this.raceEntryRepository.saveAll(raceEntries);


        }

        return importResult.toString().trim();
    }
}
