package softuni.gamestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.gamestore.services.GameService;
import softuni.gamestore.services.UserService;

import java.util.Scanner;

import static softuni.gamestore.constants.Commands.*;

@Component
public class Runner implements CommandLineRunner {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public Runner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        String inputLine;

        while (!(inputLine = SCANNER.nextLine()).equals(CLOSE)) {
            String[] arguments = inputLine.split("\\|");
            String command = arguments[0];

            String output = switch (command) {
                case REGISTER_USER -> this.userService.registerUser(arguments);
                case LOG_IN_USER -> this.userService.loginUser(arguments);
                case LOG_OUT_USER -> this.userService.logoutUser();
                case ADD_GAME -> this.gameService.addGame(arguments);
                case EDIT_GAME -> this.gameService.editGame(arguments);
                case DELETE_GAME -> this.gameService.deleteGame(arguments);
                default -> "No command found";
            };

            System.out.println(output);
        }
    }
}
