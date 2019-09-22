package gamestore.web.controlers;

import gamestore.domain.dtos.UserRegisterDto;
import gamestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class GameStoreController implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public GameStoreController(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputLine = scanner.nextLine();
            String[] inputParams = inputLine.split("\\|");
            switch (inputParams[0]) {
                case "RegisterUser":
                    UserRegisterDto userRegisterDto =
                            new UserRegisterDto(inputParams[1], inputParams[2], inputParams[3], inputParams[4]);
                    System.out.println(this.userService.registerUser(userRegisterDto));
                    //  todo 1:29:42
                    break;
                case "LoginUser":

                    break;
                case "Logout":

                    break;
            }
        }
    }
}
