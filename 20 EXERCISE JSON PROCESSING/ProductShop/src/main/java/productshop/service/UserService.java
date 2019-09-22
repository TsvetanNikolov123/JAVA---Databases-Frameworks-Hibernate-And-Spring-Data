package productshop.service;

import productshop.domain.dtos.binding.UserSeedDto;
import productshop.domain.dtos.view.UserFirstAndLastNameWithAtLeastOneSaleDto;

import java.util.List;

public interface UserService {

    void seedUsers(UserSeedDto[] userSeedDtos);

    List<UserFirstAndLastNameWithAtLeastOneSaleDto> getSuccessfulSellers();
}
