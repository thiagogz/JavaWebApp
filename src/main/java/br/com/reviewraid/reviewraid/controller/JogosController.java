package br.com.reviewraid.reviewraid.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.reviewraid.reviewraid.model.Jogos;
import br.com.reviewraid.reviewraid.repository.JogosRepository;

@RestController
@RequestMapping("/jogos")
public class JogosController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    JogosRepository repository;

    @GetMapping
    public List<Jogos> listarJogos() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Jogos cadastrarJogo(@RequestBody Jogos jogo) {
        log.info("Cadastrando jogo: {}", jogo);
        repository.save(jogo);
        return jogo;
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
    public ResponseEntity<Object> deletarJogo(@PathVariable Long id){
        log.info("Deletando jogo");

        verificarExistenciaJogo(id);
        
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Jogos> atualizarJogos(@PathVariable Long id, @RequestBody Jogos jogo){
        log.info("Atualizando jogo com id {} para {}", id, jogo);
        
        verificarExistenciaJogo(id);
        
        jogo.setId(id);
        repository.save(jogo);
        return ResponseEntity.ok(jogo);
    }

    private void verificarExistenciaJogo(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Não existe jogo com o id informado. Consulte lista em /jogos."));
    }
}