package br.com.reviewraid.reviewraid.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.reviewraid.reviewraid.model.Categoria;
import br.com.reviewraid.reviewraid.repository.CategoriaRepository;
import jakarta.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("categorias")
public class CategoriaController {
    
    @Autowired
    CategoriaRepository repository;
    
    @GetMapping
    public List<Categoria> listarCategorias() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Categoria criarCategorias(@RequestBody @Valid Categoria categoria) {
        return repository.save(categoria);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Categoria> listarJogo(@PathVariable Long id){

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("{id}")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        
        verificarExistenciaCategoria(id);
        categoria.setId(id);
        return repository.save(categoria);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletarJogo(@PathVariable Long id){
        verificarExistenciaCategoria(id);
        repository.deleteById(id);
    }

    private void verificarExistenciaCategoria(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Não existe categoria com o id informado. Consulte lista em /categorias."));
    }
}
