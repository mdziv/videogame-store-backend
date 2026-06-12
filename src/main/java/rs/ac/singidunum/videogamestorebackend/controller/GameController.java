package rs.ac.singidunum.videogamestorebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.videogamestorebackend.entity.Game;
import rs.ac.singidunum.videogamestorebackend.repository.GameRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/game")
class GameController {

    @Autowired
    private GameRepository gameRepository;

    @CrossOrigin(origins = "http://localhost:5180")
    @GetMapping
    public @ResponseBody Iterable<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @GetMapping("/{title}")
    public @ResponseBody Optional<Game> findGameByTitle(@PathVariable String title) {
        return gameRepository.findGameByTitle(title);
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addGame(@RequestBody Game game) {
        gameRepository.save(game);
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @PutMapping("/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Game game, @PathVariable String title) {
        Game existing = gameRepository.findGameByTitle(title).orElseThrow();
        existing.setTitle(game.getTitle());
        existing.setDeveloper(game.getDeveloper());
        existing.setPublisher(game.getPublisher());
        existing.setReleaseDate(game.getReleaseDate());
        existing.setTags(game.getTags());
        gameRepository.save(existing);
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @DeleteMapping("/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable String title) {
        Game existing = gameRepository.findGameByTitle(title).orElseThrow();
        gameRepository.delete(existing);
    }

}
