package rs.ac.singidunum.videogamestorebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.videogamestorebackend.entity.Developer;
import rs.ac.singidunum.videogamestorebackend.repository.DeveloperRepository;

@RestController
@RequestMapping("/api/developer")
class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @CrossOrigin(origins = "http://localhost:5180")
    @GetMapping
    public @ResponseBody Iterable<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addDeveloper(@RequestBody Developer developer) {
        developerRepository.save(developer);
    }

    @CrossOrigin(origins = "http://localhost:5180")
    @PutMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDeveloper(@RequestBody Developer developer, @PathVariable String name) {
        Developer existing = developerRepository.findDeveloperByName(name).orElseThrow();
        existing.setName(developer.getName());
        developerRepository.save(existing);
    }

}
