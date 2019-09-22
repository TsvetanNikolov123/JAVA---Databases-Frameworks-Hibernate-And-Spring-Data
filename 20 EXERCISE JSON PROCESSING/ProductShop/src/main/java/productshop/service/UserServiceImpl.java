package productshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import productshop.domain.dtos.binding.UserSeedDto;
import productshop.domain.dtos.view.ProductNamePriceAndBuyerFirstLastNameDto;
import productshop.domain.dtos.view.UserFirstAndLastNameWithAtLeastOneSaleDto;
import productshop.domain.entities.User;
import productshop.repository.UserRepository;
import productshop.util.ValidatorUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        for (UserSeedDto userSeedDto : userSeedDtos) {
            if (!this.validatorUtil.isValid(userSeedDto)) {
                this.validatorUtil.violations(userSeedDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));
                continue;
            }

            User entity = this.modelMapper.map(userSeedDto, User.class);
            this.userRepository.saveAndFlush(entity);
        }
    }

    @Override
    @Transactional
    public List<UserFirstAndLastNameWithAtLeastOneSaleDto> getSuccessfulSellers() {
        return this.userRepository
                .getAllBySellContainsProduct_Buyer()
                .stream()
                .map(user -> {
                    final UserFirstAndLastNameWithAtLeastOneSaleDto userDto =
                            this.modelMapper.map(user, UserFirstAndLastNameWithAtLeastOneSaleDto.class);
                    userDto.setSoldProducts(user
                            .getSell()
                            .stream()
                            .filter(sale -> sale.getBuyer() != null)
                            .map(sale -> this.modelMapper.map(sale, ProductNamePriceAndBuyerFirstLastNameDto.class))
                            .collect(Collectors.toSet()));
                    return userDto;
                })
                .collect(Collectors.toList());
    }
}
