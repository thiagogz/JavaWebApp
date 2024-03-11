package br.com.reviewraid.reviewraid.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    
    // @GetMapping("{id}")
    // public ResponseEntity<Jogos> listarJogo(@PathVariable Long id){
    //     log.info("Buscando jogo por id {}", id);

    //     var jogoEscolhido = getJogoById(id);

    //     if (jogoEscolhido.isEmpty()){
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //     }

    //     return ResponseEntity.ok(jogoEscolhido.get());
    // }

    // @DeleteMapping("{id}")
    // public ResponseEntity<Object> deletarJogo(@PathVariable Long id){
    //     log.info("Deletando jogo");

    //     var jogoEscolhido = getJogoById(id);

    //     if (jogoEscolhido.isEmpty()){
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //     }

    //     repository.remove(jogoEscolhido.get());
    
    //     return ResponseEntity.noContent().build();
    // }

    // @PutMapping("{id}")
    // public ResponseEntity<Jogos> atualizarJogos(@PathVariable Long id, @RequestBody Jogos jogo){
    //     log.info("Atualizando jogo com id {} para {}", id, jogo);

    //     var jogoEscolhido = getJogoById(id);

    //     if (jogoEscolhido.isEmpty()){
    //         return ResponseEntity.notFound().build();
    //     }

    //     var jogoAntigo = jogoEscolhido.get();
    //     var jogoNovo = new Jogos(id, jogo.name(), jogo.image(), jogo.description(), jogo.launch_date(), jogo.tags());

    //     repository.remove(jogoAntigo);
    //     repository.add(jogoNovo);

    //     return ResponseEntity.ok(jogoNovo);
    // }

    // private Optional<Jogos> getJogoById(Long id) {
    //     var jogoEncontrado = repository
    //         .stream()
    //         .filter( (c) -> c.id().equals(id))
    //         .findFirst();
    //     return jogoEncontrado;
    //}
}