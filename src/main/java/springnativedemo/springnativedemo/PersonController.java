package springnativedemo.springnativedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/persons")
@RestController
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") String id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

}
