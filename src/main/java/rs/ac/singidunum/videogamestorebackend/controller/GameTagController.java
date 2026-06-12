package rs.ac.singidunum.videogamestorebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.videogamestorebackend.entity.GameTag;
import rs.ac.singidunum.videogamestorebackend.repository.GameTagRepository;

@RestController
@RequestMapping("/api/gametag")
class GameTagController {

    @Autowired
    private GameTagRepository gameTagRepository;

    @CrossOrigin(origins = "http://localhost:5180")
    @GetMapping
    public @ResponseBody Iterable<GameTag> getGameTags() {
        return gameTagRepository.findAll();
    }

}
