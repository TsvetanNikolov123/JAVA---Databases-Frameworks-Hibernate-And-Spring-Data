package gamestore.service;

import gamestore.domain.dtos.UserRegisterDto;
import gamestore.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validation;
import javax.validation.Validator;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public String registerUser(UserRegisterDto userRegisterDto) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            return "Passwords don`t match";
        }
        return null;
    }
}
