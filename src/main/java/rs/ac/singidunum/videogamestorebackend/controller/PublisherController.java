package rs.ac.singidunum.videogamestorebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.videogamestorebackend.entity.Publisher;
import rs.ac.singidunum.videogamestorebackend.repository.PublisherRepository;

@RestController
@RequestMapping("/api/publisher")
class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @CrossOrigin(origins = "http://localhost:5180")
    @GetMapping
    public @ResponseBody Iterable<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addPublisher(@RequestBody Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @PutMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher, @PathVariable String name) {
        Publisher existing = publisherRepository.findPublisherByName(name).orElseThrow();
        existing.setName(publisher.getName());
        publisherRepository.save(existing);
    }

}
