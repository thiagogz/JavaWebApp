package br.com.reviewraid.reviewraid.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.reviewraid.reviewraid.model.Jogos;
import br.com.reviewraid.reviewraid.repository.JogosRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/jogos")
@Slf4j
public class JogosController {

    @Autowired
    JogosRepository repository;


    @GetMapping
    public Page<Jogos> listarCategorias(
        @RequestParam(required = false) String categoria,
        @PageableDefault(size = 3, sort = "launchDate", direction = Direction.ASC  ) Pageable pageable
    ) {
        if (categoria != null){
            return repository.findByCategoriaNome(categoria, pageable);
        }
        return repository.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Jogos cadastrarJogo(@RequestBody @Valid Jogos jogo) {
        log.info("Cadastrando jogo: {}", jogo);
        return repository.save(jogo);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Jogos> listarJogo(@PathVariable Long id){
        log.info("Buscando jogo por id {}", id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletarJogo(@PathVariable Long id){
        log.info("Deletando jogo");

        verificarExistenciaJogo(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Jogos atualizarJogos(@PathVariable Long id, @RequestBody Jogos jogo){
        log.info("Atualizando jogo com id {} para {}", id, jogo);
        
        verificarExistenciaJogo(id);
        jogo.setId(id);
        return repository.save(jogo);
    }

    private void verificarExistenciaJogo(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Não existe jogo com o id informado. Consulte lista em /jogos."));
    }
}