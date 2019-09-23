package hiberspring.service;

import hiberspring.common.Constants;
import hiberspring.domain.dtos.ProductRootImportDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.ProductRepository;
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
public class ProductsServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validator;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final BranchRepository branchRepository;

    @Autowired
    public ProductsServiceImpl(ProductRepository productRepository, FileUtil fileUtil, ValidationUtil validator, XmlParser xmlParser, ModelMapper modelMapper, BranchRepository branchRepository) {
        this.productRepository = productRepository;
        this.fileUtil = fileUtil;
        this.validator = validator;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.branchRepository = branchRepository;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return this.fileUtil.readFile(Constants.PATH_TO_FILES + "products.xml");
    }

    @Override
    public String importProducts() throws JAXBException {
        StringBuilder importResult = new StringBuilder();

        ProductRootImportDto productRootImportDtos =
                this.xmlParser.parseXml(ProductRootImportDto.class, Constants.PATH_TO_FILES + "products.xml");

        Arrays.stream(productRootImportDtos.getProductImportDtos()).forEach(productImportDto -> {
            if (!validator.isValid(productImportDto)) {
                importResult
                        .append(Constants.INCORRECT_DATA_MESSAGE)
                        .append(System.lineSeparator());
                return;
            }

            Branch branch = this.branchRepository.findByName(productImportDto.getBranch()).orElse(null);
            if (branch == null) {
                return;
            }

            Product product = this.modelMapper.map(productImportDto, Product.class);
            product.setBranch(branch);
            this.productRepository.save(product);

            importResult
                    .append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                            product.getClass().getSimpleName(),
                            productImportDto.getName()))
                    .append(System.lineSeparator());
        });


        return importResult.toString().trim();
    }
}
