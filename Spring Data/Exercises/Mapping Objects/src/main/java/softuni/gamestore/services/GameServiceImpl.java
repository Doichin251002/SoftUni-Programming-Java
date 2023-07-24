package softuni.gamestore.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.gamestore.domain.entities.Game;
import softuni.gamestore.domain.models.GameAddDTO;
import softuni.gamestore.domain.models.GameEditDTO;
import softuni.gamestore.repositories.GameRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static softuni.gamestore.constants.ErrorMessages.*;
import static softuni.gamestore.constants.SuccessMessages.*;

@Service
public class GameServiceImpl implements GameService {
    private final ModelMapper mapper;
    private final GameRepository repository;
    private final UserService userService;

    public GameServiceImpl(GameRepository repository, UserService userService) {
        this.mapper = new ModelMapper();
        this.repository = repository;
        this.userService = userService;
    }

    @Override
    public String addGame(String[] args) {
        if (!this.userService.isLoggedUserAdmin()) {
            return USER_IS_NOT_ADMIN;
        }

        int argsLength = args.length;

        String title = argsLength > 1 ? args[1] : "";
        BigDecimal price = argsLength > 2 ? new BigDecimal(args[2]) : BigDecimal.ZERO;
        Float size = argsLength > 3 ? Float.parseFloat(args[3]) : Float.parseFloat("0.0");
        String trailer = argsLength > 4 ? args[4] : "";
        String thumbnailURL = argsLength > 5 ? args[5] : "";
        String description = argsLength > 6 ? args[6] : "";
        LocalDate releaseDate = LocalDate.now();

        GameAddDTO gameDTO;
        try {
            gameDTO = new GameAddDTO(title, price, size, trailer, thumbnailURL, description, releaseDate);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        Game game = mapper.map(gameDTO, Game.class);

        this.repository.saveAndFlush(game);

        return String.format(ADDED_GAME_FORMAT, game.getTitle());

    }

    @Override
    public String editGame(String[] args) {
        if (!this.userService.isLoggedUserAdmin()) {
            return USER_IS_NOT_ADMIN;
        }

        Optional<Game> optionalGame = this.repository.findById(Long.parseLong(args[1]));
        if (optionalGame.isEmpty()) {
            return INVALID_GAME;
        }

        Map<String, String> updatingArguments = new HashMap<>();

        for (int i = 2; i < args.length; i++) {
            String a = args[i];
            String[] currentArgs = a.split("=");
            updatingArguments.put(currentArgs[0], currentArgs[1]);
        }

        GameEditDTO gameDTO = this.mapper.map(optionalGame.get(), GameEditDTO.class);
        gameDTO.updateFields(updatingArguments);

        Game game = this.mapper.map(gameDTO, Game.class);

        this.repository.saveAndFlush(game);

        return String.format(EDITED_GAME_FORMAT, game.getTitle());
    }

    @Override
    public String deleteGame(String[] args) {
        if (!this.userService.isLoggedUserAdmin()) {
            return USER_IS_NOT_ADMIN;
        }

        Optional<Game> optionalGame = this.repository.findById(Long.parseLong(args[1]));
        if (optionalGame.isEmpty()) {
            return INVALID_GAME;
        }


        Game game = optionalGame.get();
        String title = game.getTitle();
        this.repository.delete(game);

        return String.format(DELETED_GAME_FORMAT, title);
    }
}
