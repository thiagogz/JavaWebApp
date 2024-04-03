package br.com.reviewraid.reviewraid.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.reviewraid.reviewraid.model.Tags;
import br.com.reviewraid.reviewraid.repository.TagsRepository;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("tags")
public class TagsController {
    
    @Autowired
    TagsRepository repository;
    
    @GetMapping
    public List<Tags> listarTags() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Tags criarTags(@RequestBody Tags tag) {
        return repository.save(tag);
    }
    
    
}
