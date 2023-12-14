package io.aiven.dataworkshop;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.aiven.dataworkshop.model.Cat;

@RestController 
@RequestMapping(path = "/cats")
public class CatController {
    @Autowired 
    private CatRepository catRepository;

    @PostMapping() 
    public Cat addNewCat(@RequestBody Cat cat) {
        catRepository.save(cat);
        return cat;
    }

    @GetMapping()
    public Iterable<Cat> getCats() {
        return catRepository.findAll();
    }

}
