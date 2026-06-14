package rs.ac.singidunum.videogamestorebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.videogamestorebackend.entity.Tag;
import rs.ac.singidunum.videogamestorebackend.repository.TagRepository;

@RestController
@RequestMapping("/api/tag")
class TagController {

    @Autowired
    private TagRepository tagRepository;

    @CrossOrigin(origins = "http://localhost:5180")
    @GetMapping
    public @ResponseBody Iterable<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addTag(@RequestBody Tag tag) {
        tagRepository.save(tag);
    }

}
